package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.model.Likes;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.repository.LikeRepository;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;


    @Transactional
    public void uplike(Long postID, String username){
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new NullPointerException("해당 ID가 존재하지 않습니다.")
        );
        Post post = postRepository.findById(postID).orElseThrow(
                () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        if(likeRepository.findByMemberAndPost(member,post)==null){
            Likes like = new Likes(member,post);
            likeRepository.save(like);
        }else{
            Likes like = likeRepository.getLikeByMemberAndPost(member,post);
            likeRepository.delete(like);
        }
        int count = likeRepository.findAllByPost(post).size();
        post.setLikeCnt(count);
        postRepository.save(post);
    }


    public boolean checkLike(Long postID, String username){
        Member member = memberRepository.findByUsername(username).orElseThrow(
                ()->new NullPointerException("해당 ID가 존재하지 않습니다.")
        );
        Post post = postRepository.findById(postID).orElseThrow(
                ()->new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        if (likeRepository.findByMemberAndPost(member, post)==null){
            return true;
        }else {
            return false;
        }
    }
}
