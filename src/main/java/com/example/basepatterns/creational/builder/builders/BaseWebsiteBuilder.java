package com.example.basepatterns.creational.builder.builders;

import com.example.basepatterns.creational.builder.Website;

/**
 * класс пример реализации fluent интерфейсов,
 * когда каждый вызов методов билдера возвращает фактически this
 */

public abstract class BaseWebsiteBuilder {
    Website website;

    BaseWebsiteBuilder createWebsite(){
        website = new Website();
        return this;
    }

    abstract BaseWebsiteBuilder buildName();
    abstract BaseWebsiteBuilder buildCms();
    abstract BaseWebsiteBuilder buildPrice();

    Website getWebsite(){       // аналог метода build()
        //можно в этом методе проверить (если нужно) что все поля объекта не null
        return website;
    }
}
