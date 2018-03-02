package com.example.basepatterns.behavioral.chain.auth.middlewire;
//проверка на лимит запросов
public class TrottlingMiddleware extends Middlewire {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public TrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

     /**
     * Обратите внимание, вызов checkNext() можно вставить как в начале этого
     * метода, так и в середине или в конце.
     *
     * Это даёт еще один уровень гибкости по сравнению с проверками в цикле.
     * Например, элемент цепи может пропустить все остальные проверки вперёд и
     * запустить свою проверку в конце.
     */
    @Override
    public boolean check(String mail, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(mail, password);
    }
}
