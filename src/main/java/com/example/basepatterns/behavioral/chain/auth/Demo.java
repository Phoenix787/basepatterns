package com.example.basepatterns.behavioral.chain.auth;

import com.example.basepatterns.behavioral.chain.auth.middlewire.Middlewire;
import com.example.basepatterns.behavioral.chain.auth.middlewire.RoleCheckMiddleware;
import com.example.basepatterns.behavioral.chain.auth.middlewire.TrottlingMiddleware;
import com.example.basepatterns.behavioral.chain.auth.middlewire.UserExistsMiddleware;
import com.example.basepatterns.behavioral.chain.auth.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init(){
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");
        //Проверки связаны в одну цепь, клиент может строить различные цепи,
        //используя одни и теже компоненты
        Middlewire middlewire = new TrottlingMiddleware(2);
        middlewire.linkWith(new UserExistsMiddleware())
                .linkWith(new RoleCheckMiddleware());

        //сервер получает цепочку от клиентского кода
        server.setMiddlewire(middlewire);

    }

    public static void main(String[] args) throws IOException {
        init();
        boolean success;

        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();

            success = server.logIn(email, password);
        } while (!success);
    }



}
