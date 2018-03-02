package com.example.basepatterns.behavioral.chain.auth.middlewire;
/**
 * Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class RoleCheckMiddleware extends Middlewire {
    @Override
    public boolean check(String mail, String password) {
        if (mail.equalsIgnoreCase("admin@example.com")){
            System.out.println("Hello, admin");
            return true;
        }
        System.out.println("Hello, user");
        return checkNext(mail, password);
    }
}
