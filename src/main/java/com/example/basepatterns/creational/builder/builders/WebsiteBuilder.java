package com.example.basepatterns.creational.builder.builders;

import com.example.basepatterns.creational.builder.Website;

//класс который строит сущность website
public abstract class WebsiteBuilder {
  Website website;

  void createWebsite(){
      website = new Website();
  }

  abstract void buildName();
  abstract void buildCms();
  abstract void buildPrice();

  Website getWebsite(){
      return website;
  }
}
