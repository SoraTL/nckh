package com.postApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping("/api/posts")
public class PostAPI {
    @Autowired
    private IPostService postService;

    @Autowired
    private PostConverter postConverter;

    @PostMapping("/create")
    public PostApiResponse<PostDTO> createPost(@RequestBody PostDTO model) {
        // Thực hiện tạo bài viết và kiểm tra kết quả
        PostDTO post = postService.save(model);

        if (post != null) {
            // Nếu tạo thành công, trả về một CustomResponse với HttpStatus OK và dữ liệu
            // (postId)
            PostApiResponse<PostDTO> rp = new PostApiResponse<>(
                    HttpStatus.CREATED.value(),
                    "ok",
                    "POST_SERVICE");
            rp.getBody().setData(post);
            return rp;
        } else {
            // Nếu không thành công, trả về một CustomResponse với HttpStatus BAD_REQUEST và
            // thông báo lỗi
            PostApiResponse<PostDTO> rp = new PostApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "error",
                    "POST_SERVICE");
            rp.getBody().setError("Failed to create post");

            return rp;
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostApiResponse<PostDTO>> getPostById(@PathVariable("id") UUID id) {
        try {
            PostDTO post = postService.getById(id);

            HttpStatus status = HttpStatus.OK;
            int statusCode = status.value();
            PostApiResponse<PostDTO> response = new PostApiResponse<>(
                    statusCode,
                    "ok",
                    "POST_SERVICE"
            );
            response.getBody().setData(post);

            return ResponseEntity.ok(response);
        } catch (NullPointerException e) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            int statusCode = status.value();
            PostApiResponse<PostDTO> errorResponse = new PostApiResponse<>(
                    statusCode,
                    "error",
                    "POST_SERVICE"
            );
            errorResponse.getBody().setError("Post not found with ID: " + id);
            return ResponseEntity.status(status).body(errorResponse);
        }
    }



    @GetMapping(value = "author/{authorId}")
    public ResponseEntity<PostApiResponse<List<PostEntity>>> getPostByAuthorId(@PathVariable("authorId") UUID authorId) {
        List<PostEntity> post = postConverter.listToEntity(postService.getByAuthorId(authorId));

        if (post.isEmpty()) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            int statusCode = status.value();
            PostApiResponse<List<PostEntity>> errorResponse = new PostApiResponse<>(
                    statusCode,
                    "error",
                    "POST_SERVICE"
            );
            errorResponse.getBody().setError("No post found with ID: " + authorId);
            return ResponseEntity.status(status).body(errorResponse);

        } else {
            HttpStatus status = HttpStatus.OK;
            int statusCode = status.value();
            PostApiResponse<List<PostEntity>> response = new PostApiResponse<>(
                    statusCode,
                    "ok",
                    "POST_SERVICE"
            );
            response.getBody().setData(post);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping(value = "/all")
    public PostApiResponse<List<PostEntity>> getAllPost() {
        try {
            List<PostEntity> post = postService.getAllPost();
            HttpStatus status=HttpStatus.OK;
            int s = status.value();
            PostApiResponse<List<PostEntity>> rp = new PostApiResponse<>(
                    s,
                    "ok",
                    "POST_SERVICE");
            rp.getBody().setLData(post);
            return rp;
        } catch (Exception e) {
            int s=HttpStatus.INTERNAL_SERVER_ERROR.value();
            return new PostApiResponse<>(
                    s,
                    "error",
                    "POST_SERVICE");
        }
    }

    @PutMapping(value = "/update/{id}")
    public PostDTO updatePost(@RequestBody PostDTO model, @PathVariable("id") UUID id) {
        model.setId(id);
        return postService.save(model);
    }

    @DeleteMapping(value = "/{id}")
    public PostApiResponse<Boolean> deleteNew(@PathVariable("id") UUID id) {
        postService.delete(id);
        int s=HttpStatus.OK.value();
        PostApiResponse<Boolean> rp = new PostApiResponse<>(
                s,
                "ok",
                "POST_SERVICE");
        return rp;
    }
}