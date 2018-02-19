package com.example.basepatterns.creational.prototype;

public class Application {
    public static void main(String[] args) {
        Project master = new Project(1, "SuperProject", "SourceCode sourceCode = new SourceCode();");

        System.out.println(master);

        //первый способ
        Project masterClone = (Project) master.copy();
        System.out.println("\n============================================\n");
        System.out.println(masterClone);

        //второй способ, чтобы не заморачиваться в клиентском коде с привидением типов
        ProjectFactory projectFactory = new ProjectFactory(master);
        Project masterClone1 = projectFactory.cloneProject();
        System.out.println("\n============================================\n");
        System.out.println(masterClone1);

        //три экземпляра - это три разных объекта, находятся  в разных ячейках памяти, т.е. при изменении какого-то поля
        //в одном объекте, не приведет к изменению этого же поля в другом, они полностью независимы друг от друга
        master.setId(2);
        System.out.println("\n============================================\n");
        System.out.println(master);
        System.out.println(masterClone);
        System.out.println(masterClone1);
    }
}
