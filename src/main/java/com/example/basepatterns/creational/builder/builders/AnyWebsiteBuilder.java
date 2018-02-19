package com.example.basepatterns.creational.builder.builders;

import com.example.basepatterns.creational.builder.Cms;

public class AnyWebsiteBuilder extends BaseWebsiteBuilder {
    @Override
    BaseWebsiteBuilder buildName() {
        website.setName("Any other website with fluent Interface builder");
        return this;
    }

    @Override
    BaseWebsiteBuilder buildCms() {
        website.setCms(Cms.ALIFRESCO);
        return this;
    }

    @Override
    BaseWebsiteBuilder buildPrice() {
        return this;
    }
}
