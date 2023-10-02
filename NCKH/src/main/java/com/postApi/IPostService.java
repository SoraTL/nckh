package com.postApi;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    PostDTO save(PostDTO postDTO);
    void delete(UUID id);

    List<PostDTO> getByAuthorId(UUID id);

    PostDTO getById(UUID id);

    List<PostEntity> getAllPost();
}