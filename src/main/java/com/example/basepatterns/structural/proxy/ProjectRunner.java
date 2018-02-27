package com.example.basepatterns.structural.proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        //при создании объекта Project происходит сразу скачивание проекта
        Project project = new RealProject("https://github.com/spring-projects/spring-petclinic");
     //   project.run();

        //нам нужно, чтобы проект начал скачиваться во время запуска метода run()
        //не запустив метод run() у нас создается просто объект и при этом не происходит скачивания
        //и только запустив метод run() происходит и скачивание и запуск проекта
        //для этого используем объект заместитель
        System.out.println("-----------***********--------------------\n");
        Project project1 = new ProxyProject("https://github.com/spring-projects/spring-petclinic");
      //  project1.run();
    }
}
