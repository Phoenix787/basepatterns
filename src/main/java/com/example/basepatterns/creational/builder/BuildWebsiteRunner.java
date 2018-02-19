package com.example.basepatterns.creational.builder;

import com.example.basepatterns.creational.builder.builders.AnyWebsiteBuilder;
import com.example.basepatterns.creational.builder.builders.Director;
import com.example.basepatterns.creational.builder.builders.EnterpriseWebsiteBuilder;
import com.example.basepatterns.creational.builder.builders.FluentDirector;

public class BuildWebsiteRunner {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new EnterpriseWebsiteBuilder());

        FluentDirector fluentDirector = new FluentDirector();
        fluentDirector.setBuilder(new AnyWebsiteBuilder());

        //пример создания сайта с билдером основанном на fluentInterface'ах
//        BaseWebsiteBuilder builder = new AnyWebsiteBuilder();
//        Website any = builder.createWebsite().buildName().buildCms().getWebsite();

        Website any = fluentDirector.build();

        Website website = director.buildWebsite();

        System.out.println(website);
        System.out.println(any);
    }
}
