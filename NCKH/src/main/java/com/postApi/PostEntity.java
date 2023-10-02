package com.postApi;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    private UUID id;
    @Column(name = "authorId")
    private UUID authorId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name= "imageUrl")
    private String imageUrl;

    public void setId(UUID id) { this.id = id; }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
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