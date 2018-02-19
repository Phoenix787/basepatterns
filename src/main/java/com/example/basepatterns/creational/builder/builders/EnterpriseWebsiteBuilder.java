package com.example.basepatterns.creational.builder.builders;

import com.example.basepatterns.creational.builder.Cms;

/**
 * класс-билдер реализующий абстрактный класс {@link WebsiteBuilder} специально для создания EnterpriseWebsite
 */
public class EnterpriseWebsiteBuilder extends WebsiteBuilder {
    @Override
    void buildName() {
        website.setName("Enterprise web site");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    @Override
    void buildPrice() {
        website.setPrice(10000);
    }
}
