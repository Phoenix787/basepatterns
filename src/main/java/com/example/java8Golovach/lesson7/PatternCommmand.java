package com.example.java8Golovach.lesson7;

import java.util.ArrayList;
import java.util.List;

/**
 * Команда – это объект, который инкапсулирует всю информацию, не-
 * обходимую для вызова метода в будущем. Паттерн Команда – это
 * способ использования такого объекта, позволяющий писать обоб-
 * щенный код, в котором последовательность вызовов методов опреде-
 * ляется на этапе выполнения.
 *
 * В паттерне Команда принимают участие
 * четыре класса:
 *  Получатель – фактически выполняет работу.
 *  Команда – инкапсулирует всю информацию, необходимую для
 * вызова получателя.
 *  Активатор – управляет последовательностью выполнения од-
 * ной или нескольких команд.
 *  Клиент – создает конкретные экземпляры команд.
 *
 *
 * Паттерн Команда изначально служил заменой отсутствующим
 * в языке лямбда-выражениям. Пользуясь настоящими лямбда-выра-
 * жениями или ссылками на методы, мы можем сделать код чище, убрав
 * служебные стереотипные конструкции и прояснив его назначение.
 * Макросы – лишь один пример возможного использования паттер-
 * на Команда. Он часто применяется при реализации компонентных
 * систем графического интерфейса пользователя (ГИП), функции от-
 * мены, пулов потоков, транзакций и мастеров.
 * В базовых библиотеках Java уже имеется функциональный интерфейс
 * Runnable с такой же структурой, как у нашего интерфейса Action. Мы могли бы
 * использовать его для построения класса макроса, но в данном случае слово
 * Action лучше отражает специфику предметной области, так что я решил соз-
 * дать собственный интерфейс.
 *
 *
 *
 */
public class PatternCommmand {

    public static void main(String[] args) {
        Editor editor = new Editor() {
            @Override
            public void save() {
                System.out.println("Save");
            }

            @Override
            public void open() {
                System.out.println("Open");
            }

            @Override
            public void close() {
                System.out.println("Close");
            }
        };

        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();


        /**
         * На самом деле все наши
         * классы команд, в частности Save и Open, – это просто лямбда-выраже-
         * ния, жаждущие выбраться из своих скорлупок на свет Божий. Это ин-
         * капсулированные поведения, для передачи которых из одного места
         * в другое мы написали классы. Благодаря лямбда-выражениям весь
         * паттерн можно значительно упростить, полностью отказавшись от
         * обертывающих классов
         */

        Macro macroLambda = new Macro();
        macroLambda.record(()->editor.open());
        macroLambda.record(()->editor.save());
        macroLambda.record(()->editor.close());
        macroLambda.record(editor::close);

        macroLambda.run();
        //Создание макроса с помощью ссылок на методы
        //macroLambda.record(editor::close);
    }



}

/**
 * Предположим, что имеется компонент графического интерфейса Editor, и
 * в нем определены действия, которые мы можем вызывать, например
 * open или save
 * Мы хотим реализовать функциональность макроса,
 * то есть последовательности операций, которую можно
 * где-то сохранить, а затем выполнить как одну операцию. Это и будет
 * наш получатель.
 */

interface Editor{
    void save();
    void open();
    void close();
}

/**
 * В этом примере все операции, в частности open и save, – команды.
 * Нам необходим обобщенный интерфейс команды, которому отвечали
 * бы различные операции. Я назову этот интерфейс Action, поскольку
 * он представляет выполнение одного действия в нашей предметной
 * области. Этот интерфейс будут реализовывать все объекты-команды
 */
interface Action{
    void perform();
}

//Действие save делегирует работу методу Editor
class Save implements Action{

    private final Editor editor;

    Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}

//Действие open также делегирует работу методу Editor
class Open implements Action{

    private final Editor editor;

    Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}

class Close implements Action{
    private final Editor editor;

    Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}



/**
 * Теперь можно реализовать класс Macro. Этот класс умеет записы-
 * вать последовательность действий методом record и исполнять ее
 * как единую группу. Мы будем хранить последовательность действий
 * в объекте List, а для выполнения их по очереди воспользуемся мето-
 * дом forEach. В примере 8.5 показан наш активатор.
 */
class Macro{
    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(action -> action.perform());
    }
}