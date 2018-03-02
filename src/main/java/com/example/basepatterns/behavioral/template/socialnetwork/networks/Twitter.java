package com.example.basepatterns.behavioral.template.socialnetwork.networks;

public class Twitter extends Network {
    public Twitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("User: " + this.username);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLog in success in Twitter");
        return true;
    }

    @Override
    boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted){
            System.out.println("Message: '" + new String(data) + "' was posted on Twitter.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    void logOut() {
        System.out.println("User '" + this.username + "' was logged out from Twitter");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.currentThread().sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
