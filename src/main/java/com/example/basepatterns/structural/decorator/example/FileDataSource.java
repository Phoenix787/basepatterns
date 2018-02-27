package com.example.basepatterns.structural.decorator.example;

import java.io.*;

/**
 * Класс, реализующий прямое чтение и запись данных
 * прямая реализация интерфейса DataSource
 */
public class FileDataSource implements DataSource {

    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try(OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try(FileReader reader = new FileReader(file)){
            buffer = new char[(int)file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert buffer != null;
        return new String(buffer);
    }
}
