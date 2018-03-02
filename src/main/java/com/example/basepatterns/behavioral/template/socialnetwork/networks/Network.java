package com.example.basepatterns.behavioral.template.socialnetwork.networks;

/**
 * Базовый класс социальной сети
 */
public abstract class Network {
    protected String username;
    protected String password;

    public Network() {
    }

    /**
     * Публикация данных в любой сети.
     */
    public boolean post(String message) {
        // Проверка данных пользователя перед постом в соцсеть. Каждая сеть для
        // проверки использует разные методы.
        if(logIn(this.username, this.password)){
            //отправка данных
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }


    abstract boolean logIn(String username, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}
