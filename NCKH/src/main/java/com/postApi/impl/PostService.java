package com.postApi.impl;

import com.postApi.PostConverter;
import com.postApi.PostDTO;
import com.postApi.PostEntity;
import com.postApi.PostRepository;
import com.postApi.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    @Override
    public PostDTO save(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        if (postDTO.getId() != null) {
            PostEntity oldPostEntity = postRepository.findOne(postDTO.getId());
            postEntity = postConverter.toEntity(postDTO, oldPostEntity);
            postEntity.setId(UUID.randomUUID());
        } else {
            postEntity = postConverter.toEntity(postDTO);
            postEntity.setId(UUID.randomUUID());
        }
        postEntity = postRepository.save(postEntity);
        return postConverter.toDTO(postEntity);

    }

    public PostDTO getById(UUID id){
        return postConverter.toDTO(postRepository.findOne(id));
    }

    public void delete(UUID id) {
        postRepository.delete(id);
    }

    public List<PostDTO> getByAuthorId(UUID authorId){
        return postConverter.listToDTO(postRepository.findByAuthorId(authorId));
    }

    public List<PostEntity> getAllPost(){
        return postRepository.findAll();
    }

}
