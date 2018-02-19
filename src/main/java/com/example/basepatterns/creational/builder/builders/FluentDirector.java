package com.example.basepatterns.creational.builder.builders;

import com.example.basepatterns.creational.builder.Website;

public class FluentDirector {
    private BaseWebsiteBuilder builder;

    public void setBuilder(BaseWebsiteBuilder builder) {
        this.builder = builder;
    }

    public Website build(){
       return builder.createWebsite().buildName().buildCms().getWebsite();
    }
}
