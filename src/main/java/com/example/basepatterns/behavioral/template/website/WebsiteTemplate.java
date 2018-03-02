package com.example.basepatterns.behavioral.template.website;

public abstract class WebsiteTemplate {
    public void showPage(){
        System.out.println("Header");
        showContent();
        System.out.println("Footer");
    }

    abstract void showContent();
}
