package com.example.java8Golovach.lesson7;

import java.util.List;
import java.util.stream.Collectors;

public class TestLambdaTesting {
    public static void main(String[] args) {

    }

    //пример 1
    //преобразование строк в верхний регистр

    /**
     * Единственное, что делает лямбда-выражение в теле этого метода, –
     * прямой вызов метода из базовой библиотеки. В силу простоты пове-
     * дения тестировать это лямбда-выражение как независимую единицу
     * кода вообще не имеет смысла.
     *
     * Если бы нужно было автономно протестировать этот код, я со-
     * средоточился бы на поведении всего метода. Так, в примере 7.9 при-
     * веден тест, проверяющий, что если в потоке есть несколько слов, то
     * все они преобразуются в верхний регистр.
     * @param words
     * @return
     */
    public static List<String> allUpperCase(List<String> words) {
        return words.stream()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());
    }

    //Пример 2
    //Преобразование первого символа каждого слова из списка в верхний регистр
    public static List<String> elementFirstToUpperCaseLambdas(List<String> words){
        return words.stream()
                .map(value -> { //точка 1
                    char firstChar = Character.toUpperCase(value.charAt(0));
                    return firstChar + value.substring(1);
                })
                .collect(Collectors.toList());
    }

    //Пример 2а

    //создаем метод
    public static String firstToUpperCase(String value){
        char firstChar = Character.toUpperCase(value.charAt(0));
        return firstChar + value.substring(1);
    }
    // используем ссылку на верхний метод в лямбда, так проще будет тестировать этот кусок
    public static List<String> elementFirstToUpperCaseWithLink(List<String> words){
        return words.stream()
                .map(TestLambdaTesting::firstToUpperCase)
                .collect(Collectors.<String>toList());
    }

}
