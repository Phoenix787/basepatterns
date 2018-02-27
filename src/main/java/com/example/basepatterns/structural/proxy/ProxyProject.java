package com.example.basepatterns.structural.proxy;

/**
 * объект-заместитель, создается объект с тем же самым интерфейсом который нам нужен, при этом
 * запуск ресурсоемкой операции приходится не на момент инициализации объекта, а тогда когда необходима эта операция
 */
public class ProxyProject implements Project {
    private String url;
    private RealProject realProject;

    public ProxyProject(String url) {
        this.url = url;
    }


    @Override
    public void run() {
        if (realProject == null) {
            realProject = new RealProject(url);
        }
        realProject.run();

    }
}
