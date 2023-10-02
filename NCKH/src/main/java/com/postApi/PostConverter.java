package com.postApi;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostConverter {

    public PostEntity toEntity(PostDTO dto) {
        PostEntity entity = new PostEntity();
        entity.setAuthorId(dto.getAuthorId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

    public PostDTO toDTO(PostEntity entity) {
        PostDTO dto = new PostDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setAuthorId(entity.getAuthorId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setImageUrl(entity.getImageUrl());
        return dto;
    }

    public PostEntity toEntity(PostDTO dto, PostEntity entity) {
        entity.setAuthorId(dto.getAuthorId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

    public List<PostDTO> listToDTO(List<PostEntity> postEntities) {
        return postEntities.stream()
                .map(postEntity -> {
                    PostDTO postDTO = new PostDTO();
                    postDTO.setId(postEntity.getId());
                    postDTO.setAuthorId(postEntity.getAuthorId());
                    postDTO.setTitle(postEntity.getTitle());
                    postDTO.setContent(postEntity.getContent());
                    postDTO.setImageUrl(postEntity.getImageUrl());
                    return postDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PostEntity> listToEntity(List<PostDTO> postDTOs) {
        return postDTOs.stream()
                .map(postDTO -> {
                    PostEntity postEntity = new PostEntity();
                    postEntity.setId(postDTO.getId());
                    postEntity.setAuthorId(postDTO.getAuthorId());
                    postEntity.setTitle(postDTO.getTitle());
                    postEntity.setContent(postDTO.getContent());
                    postEntity.setImageUrl(postDTO.getImageUrl());
                    return postEntity;
                })
                .collect(Collectors.toList());
    }
}