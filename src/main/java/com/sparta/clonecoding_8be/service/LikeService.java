package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.model.Like;
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
            Like like = new Like(member,post,null);
            like.setHeart("like");
            likeRepository.save(like);
        }else{
            Like like = likeRepository.getLikeByMemberAndPost(member,post);
            likeRepository.delete(like);
        }

        int count = likeRepository.findAllByPost(post).size();
        post.setLikeCount(count);
        postRepository.save(post);
    }



    public boolean checkLike(Long postID, String username){
        Member member = memberRepository.findById(new member("test").getId()).orElseThrow(
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
