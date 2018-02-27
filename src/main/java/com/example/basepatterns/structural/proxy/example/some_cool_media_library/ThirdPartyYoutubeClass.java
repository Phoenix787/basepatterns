package com.example.basepatterns.structural.proxy.example.some_cool_media_library;

import java.util.HashMap;

/**
 * Реализация удалённого сервиса
 */
public class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {
    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }


    //-------------------------------------------

    private int random(int min, int max){
        return min + (int) (Math.random() * ((max - min) + 1));
    }
    //Fake methods to simulate network activity

    private void experienceNetworkLatency(){
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void connectToServer(String server) {
        System.out.println("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.println("Connected!" + "\n");
    }

    private HashMap<String,Video> getRandomVideos() {
        System.out.println("Downloading populars...");
        experienceNetworkLatency();

        HashMap<String, Video> hmap = new HashMap<String, Video>();
        hmap.put("catzzzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        hmap.put("dancescideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));
        System.out.println("Done!");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.println("Downloading video...");
        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        System.out.println("Done!");

        return video;
    }
}
