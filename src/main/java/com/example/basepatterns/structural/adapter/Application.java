package com.example.basepatterns.structural.adapter;

//мы не можем из базы данных загружать информацию с помощью класса JavaApplication
//нужно создать класс-адаптер, который будет связывать эти два интерфейса
public class Application {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();

        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}
