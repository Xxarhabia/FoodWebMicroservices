package com.msara.post.services;

import com.msara.post.entities.PostEntity;
import com.msara.post.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostEntity createPost(PostEntity post) {
        return postRepository.save(post);
    }

    public PostEntity findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public List<PostEntity> findAllPost() {
        return postRepository.findAll();
    }

    public PostEntity updatePostById(Long id, PostEntity post) {
         PostEntity postFound = findPostById(id);

         postFound.setDescription(post.getDescription());
         postFound.setImage(post.getImage());
         postFound.setDateModify(LocalDateTime.now());

         return postRepository.save(postFound);
    }
}
