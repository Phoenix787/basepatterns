package com.example.basepatterns.creational.builder.builders;

import com.example.basepatterns.creational.builder.Cms;

/**
класс, который реализует абстрактный класс {@link WebsiteBuilder} создан специально для создания сайта-визитки
 */

public class VisitCardWebsiteBuilder extends WebsiteBuilder {

    @Override
    void buildName() {
        website.setName("Visit card");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(500);
    }
}
