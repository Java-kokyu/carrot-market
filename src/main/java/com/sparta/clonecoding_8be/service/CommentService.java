package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.dto.comment.CommentRequestDto;
import com.sparta.clonecoding_8be.dto.comment.CommentResponseDto;
import com.sparta.clonecoding_8be.dto.comment.EditCommentRequestDto;
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
    public CommentResponseDto saveComment(Long postid, String memberProxy, CommentRequestDto commentRequestDto){
        Member member = memberRepository.findByUsername(memberProxy).orElseThrow(RuntimeException::new);
        Post post = postRepository.findById(postid).orElseThrow(IllegalAccessError::new);
        Comment comment = commentRequestDto.toEntity();
        comment.registCommentInfo(post,member);
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment.getId(), comment.getComment(), member.getNickname(), member.getProfileImage(), member.getModifiedAt());
        return commentResponseDto;
    }

    //댓글 조회
    @Transactional
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
    @Transactional
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
    @Transactional
    public CommentResponseDto updateComment(Long id, EditCommentRequestDto editCommentRequestDto, Member member) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );
        // comment내의 memberid와 로그인한 member아이디 일치하는지 확인
        Comment commentByCommentId = commentRepository.findById(id).get();

        String username = member.getUsername();
        String nickname = member.getNickname();
        String profileImage = member.getProfileImage();

        CommentResponseDto commentResponseDto = null;

        if (!Objects.equals(username, comment.getMember().getUsername())){
            return null;
        } else {
            comment.updateComment(editCommentRequestDto);
            commentRepository.save(comment);
            commentResponseDto = new CommentResponseDto(id, editCommentRequestDto.getComment(), nickname, profileImage, comment.getModifiedAt());
        }
        return commentResponseDto;
    }
}
