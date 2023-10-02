package com.postApi;

import java.util.UUID;

public class PostDTO {

    private UUID id;
    private UUID authorId;
    private String title;
    private String content;
    private String imageUrl;

    public PostDTO(UUID id, UUID authorId, String title, String content, String imageUrl) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public PostDTO(){

    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
