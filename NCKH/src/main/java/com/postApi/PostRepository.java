package com.postApi;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    @Query("SELECT p FROM PostEntity p WHERE p.authorId = :authorId")
    List<PostEntity> findByAuthorId(@Param("authorId") UUID authorId);
}
