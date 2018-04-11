package com.example.java8Golovach;

import java.lang.annotation.Documented;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Стрим - это НЕ коллекция, это как бы способ смотреть на данные. обычно стрим кто-то порождает
 * это просто как вьюшка. но при этом у стрима может быть больше методов чем в коллекциях.
 *
 * Spliterator - это начинка потока, публичная часть его внутренней логики (внутренность Стрима). Это интерфейс,
 * который содержит 8 методов, 4 из них уже имеют реализацию по умолчанию. он похож на обычный итератор,
 * основное отличие - умение разделиться на две части - лежит в основе параллельной работы потоков. сплитератор
 * никогда не модифицирует источник данных.
 *
 * flatmap -
 *
 */

public class App00 {
    public static void main(String[] args) {
        Stream.of("A", "BB", "CСС", "EEEE")       //asList("A", "BB", "C").stream() can be replaced
                                                  //asList("A", "BB", "CCC").parallelStream() - порядок элементов неопределен
                .filter(s -> s.length() > 1)      //фильтруем где количество знаков больше 1, каждый раз порождается новый стрим
                .map(String::length)              //возвращает стрим, содержащий результаты применения функции
                .forEach(System.out::println);
    }

    //.filter(s -> s.length() > 1) <--- .filter(new Predicate<String>() {     <-- функциональный интерфейс
    //                                          @Override
    //                                          public boolean test(String s) {
    //                                              return s.length() > 1;
    //                                          }
    //                                        })
    //.forEach(System.out::println)     <--- .forEach(new Consumer<Integer>() {
    //                                              @Override
    //                                              public void accept(Integer integer) {
   //                                                   System.out.println(integer);
   //                                               }
   //                                           });
}


//объявление своей аннотации

@interface U {}

@U
interface X{
    void f();
    void g();
}

/**
 * Аннотации представляют собой некую мета-информацию.
 * Они не выполняют какого-либо действия сами по себе,
 * но они могут предоставлять дополнительную информацию,
 * которая может быть использована компилятором, различными утилитами сборки и генерации кода,
 * а также они могут обрабатываться во время выполнения программы
 * см. read_about_annotation.txt
 */

//объявление аннотации с параметрами и предопределенными аннотациями
@Documented
@interface Monstr{
    String author();
    String sprites();
    String sound();
    String code();
    String description();
}
//применение аннотации с параметрами
@Monstr(author = "John",
        sprites = "Izabella",
        sound = "Michael",
        code = "Push",
        description = "Goblin")
class Goblin{

}