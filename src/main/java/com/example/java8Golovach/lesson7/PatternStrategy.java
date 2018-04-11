package com.example.java8Golovach.lesson7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Паттерн Стратегия описывает способ изменения алгоритма програм-
 * мы на этапе выполнения. Конкретная реализация этого паттерна за-
 * висит от обстоятельств, но в любом случае идея одна и та же: опреде-
 *  * лить общую задачу, решаемую разными алгоритмами, а затем скрыть
 * все алгоритмы за единым программным интерфейсом.
 * В качестве примера инкапсулируемого алгоритма можно взять
 * сжатие файлов. Мы дадим пользователям возможность сжимать фай-
 * лы с помощью алгоритма zip или gzip и реализуем обобщенный класс
 * Compressor, который сможет выбирать любой из этих алгоритмов.
 *
 * Прежде всего необходимо определить API нашей стратегии,  которую я назову CompressionStrategy. Все алгоритмы сжа-
 * тия будут реализовывать этот интерфейс. У них будет метод compress,
 * который принимает и возвращает OutputStream. Выходной объект
 * OutputStream – результат сжатия входного
 */
public class PatternStrategy {
    public static void main(String[] args) throws IOException {

        Path inFile = Paths.get("автономное тестирование лямбда.txt");
        File outFile = new File("out");

        //традиционная реализация паттерна Стратегия: пишем клиента, который создает объект Compressor, задавая нужную стратегию

        Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
        gzipCompressor.compress(inFile, outFile);

        Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
        zipCompressor.compress(inFile, outFile);

        //Создание экземпляров класса Compressor
        //с помощью ссылок на методы
        //В данном случае мы можем отказаться
        //от реализации конкретных стратегий и сослаться на метод, реали-
        //зующий алгоритм. Алгоритмы будут представлены конструкторами
        //соответствующих реализаций интерфейса OutputStream. При таком
        //подходе классы GzipCompressionStrategy и ZipCompressionStrategy ока-
        //зываются вообще лишними
        Compressor gzip = new Compressor(GZIPOutputStream::new);
        gzip.compress(inFile, outFile);

        Compressor zip = new Compressor(ZipOutputStream::new);
        zip.compress(inFile, outFile);

    }


}

interface CompressionStrategy{
    OutputStream compress(OutputStream data) throws IOException;
}

class GzipCompressionStrategy implements CompressionStrategy{

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new GZIPOutputStream(data);
    }
}

class ZipCompressionStrategy implements CompressionStrategy{

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new ZipOutputStream(data);
    }
}

/**
 * Теперь можно реализовать класс Compressor, являющийся контек-
 * стом, в котором используется наша стратегия. В этом классе есть метод
 * compress, который принимает пути к входному и выходному файлам
 * и записывает сжатую версию входного файла в выходной. Конструк-
 * тору в качестве параметра передается объект CompressionStrategy,
 * с помощью которого вызывающая программа на этапе выполнения
 * принимает решение о том, какую стратегию сжатия использовать, –
 * например, спросив пользователя о предпочтительном способе сжатия
 */

class Compressor {
    private final CompressionStrategy strategy;

    Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(outFile)){
            Files.copy(inFile, strategy.compress(outputStream));
        }
    }
}