package com.example.basepatterns.behavioral.chain.auth.server;

import com.example.basepatterns.behavioral.chain.auth.middlewire.Middlewire;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Map<String, String> users = new HashMap<>();
    private Middlewire middlewire;

    /**
     * Клиент подаёт готовую цепочку в сервер. Это увеличивает гибкость и
     * упрощает тестирование класса сервера.
     */

    public void setMiddlewire(Middlewire middlewire) {
        this.middlewire = middlewire;
    }

    /**
     * Сервер получает email и пароль от клиента и запускает проверку авторизации у цепочки
     */

    public boolean logIn(String email, String password) {
        if (middlewire.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Здесь должен быть какой-то полезный код, работающий для
            // авторизированных пользователей.
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public static boolean hasEmail(String email) {
        return users.containsKey(email);
    }
}
