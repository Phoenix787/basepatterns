package com.example.basepatterns.behavioral.chain.auth.middlewire;
//Базовый класс проверок
public abstract class Middlewire {
    Middlewire next;

    /**
     * помогает строить цепь объектов-проверок
     */

    public Middlewire linkWith(Middlewire next) {
        this.next = next;
        return next;
    }

    /**
     * запускаем проверку в следующем объекте или завершаем проверку,
     * если мы в последнем элементе цепи
     */

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }


    /**
     * подклассы реализуют в этом методе конкретные проверки
     */

    public abstract boolean check(String mail, String password);

}
