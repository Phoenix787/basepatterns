package com.example.basepatterns.behavioral.chain.auth.middlewire;

import com.example.basepatterns.behavioral.chain.auth.server.Server;

/**
        * Конкретный элемент цепи обрабатывает запрос по-своему.
        */
public class UserExistsMiddleware extends Middlewire {

    @Override
    public boolean check(String mail, String password) {
        if(!Server.hasEmail(mail)){
            return false;
        }
        return checkNext(mail, password);
    }
}
