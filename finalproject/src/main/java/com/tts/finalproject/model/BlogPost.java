package com.tts.finalproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    @Length(max = 25000)
    private String blogentry;
    private String typeof;


    public BlogPost() {
    }

    public BlogPost(String title, String author, String blogentry, String typeof) {
        this.title = title;
        this.author = author;
        this.blogentry = blogentry;
        this.typeof = typeof;
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


    public String getTypeof() {
        return typeof;
    }

    public void setTypeof(String typeof) {
        this.typeof = typeof;
    }

    @Override
    public String toString() {
        return "BlogPost [author=" + author + ", blogentry=" + blogentry + ", id=" + id + ", title=" + title
                + ", typeof=" + typeof + "]";
    }


    
}
