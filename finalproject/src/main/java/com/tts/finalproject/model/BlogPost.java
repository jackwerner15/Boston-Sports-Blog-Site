package com.tts.finalproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String blogentry;

    public BlogPost() {
    }

    public BlogPost(String title, String author, String blogentry) {
        this.title = title;
        this.author = author;
        this.blogentry = blogentry;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogentry() {
        return blogentry;
    }

    public void setBlogentry(String blogentry) {
        this.blogentry = blogentry;
    }

    @Override
    public String toString() {
        return "Blog [author=" + author + ", blogentry=" + blogentry + ", id=" + id + ", title=" + title + "]";
    }


    
}
