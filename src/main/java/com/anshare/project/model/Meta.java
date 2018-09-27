package com.anshare.project.model;


//菜单标识
public class Meta {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "title='" + title + '\'' +
                '}';
    }

    public Meta(String title) {
        this.title = title;
    }

}
