package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.dto.CommentRequestDto;
import com.sparta.clonecoding_8be.dto.CommentResponseDto;
import com.sparta.clonecoding_8be.dto.EditCommentRequestDto;
import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.repository.CommentRepository;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    //댓글 등록
    @Transactional
    public void saveComment(Long postid, String memberProxy, CommentRequestDto commentRequestDto){
        Member member = memberRepository.findByUsername(memberProxy).orElseThrow(RuntimeException::new);
        Post post = postRepository.findById(postid).orElseThrow(IllegalAccessError::new);
        Comment comment = commentRequestDto.toEntity();
        comment.registCommentInfo(post,member);
        commentRepository.save(comment);
    }

    //댓글 조회
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getCommentsByPostId(Long postid) {
        List<Comment> commentListByPostId =  commentRepository.findAllByPostId(postid);

        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

        for(Comment comment : commentListByPostId){
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            commentResponseDtoList.add(commentResponseDto);
        }
        return commentResponseDtoList;
    }

    //댓글 삭제
    public Boolean deleteComment(Long id, String member) {
        Comment commentByCommentId = commentRepository.findById(id).get();
        if (!Objects.equals(member, commentByCommentId.getMember().getUsername())) {
            return false;
        } else {
            commentRepository.deleteById(id);
        }
        return true;
    }


    // 댓글 수정
    public Boolean updateComment(Long id, EditCommentRequestDto editCommentRequestDto, String member) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        // comment내의 memberid와 로그인한 member아이디 일치하는지 확인
        Comment commentByCommentId = commentRepository.findById(id).get();

        if (!Objects.equals(member, comment.getMember().getUsername())){
            return false;
        } else {
            comment.updateComment(editCommentRequestDto);
            commentRepository.save(comment);
        }
        return true;
    }
}
