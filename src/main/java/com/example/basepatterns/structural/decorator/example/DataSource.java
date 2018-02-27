package com.example.basepatterns.structural.decorator.example;

/**
 * Интерфейс, задающий базовые операции чтения и записи данных
 */
public interface DataSource {
    void writeData(String data);

    String readData();
}
