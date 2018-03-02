package com.example.basepatterns.behavioral.template.socialnetwork;

import com.example.basepatterns.behavioral.template.socialnetwork.networks.Facebook;
import com.example.basepatterns.behavioral.template.socialnetwork.networks.Network;
import com.example.basepatterns.behavioral.template.socialnetwork.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;

        System.out.println("Input username: ");
        String username = bufferedReader.readLine();
        System.out.println("Input password: ");
        String password = bufferedReader.readLine();
        System.out.println("Input message:");
        String message = bufferedReader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(bufferedReader.readLine());

        //создаем сетевые объекты и публикуем пост
        if (choice == 1){
            network = new Facebook(username, password);
        } else if (choice == 2){
            network = new Twitter(username, password);
        }
        assert network != null;
        network.post(message);

    }
}
