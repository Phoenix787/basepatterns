package com.example.basepatterns.creational.factoryMethod;

/**
 * класс-клиент
 */
public class Program {
    public static void main(String[] args) {
        // с помощью интерфейса удобнее, но всё равно мы в самом клиенте должны изменять код и создавать сами либо javadeveloper либо cppdeveloper
        //это не так гибко как нам хотелось бы
        Developer developer = new JavaDeveloper();
        developer.writeCode();

        //теперь для того, чтобы сменить разработчика, нам достаточно только сменить саму фабрику
        DeveloperFactory factory = new CppDeveloperFactory();
        Developer developer1 = factory.createDeveloper();
        developer1.writeCode();

        //третий вариант
        String spec = "php";
        DeveloperFactory developerFactory = createDeveloperBySpeciality(spec);
        Developer developer2 = developerFactory.createDeveloper();
        System.out.println("Третий вариант");
        developer2.writeCode();


    }
    //но мы можем сделать программу еще более гибкой, создадим некий метод - это для третьего варианта
    //в котором будем по признаку выбирать какая фабрика нам нужна. это и есть фабричный метод
    private static DeveloperFactory createDeveloperBySpeciality(String speciality){
        if (speciality.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        } else if (speciality.equalsIgnoreCase("c++")){
            return new CppDeveloperFactory();
        }if (speciality.equalsIgnoreCase("php")){
            return new PhpDeveloperFactory();
        }
        else {
            throw new RuntimeException(speciality + " is unknown.");
        }
    }
}
