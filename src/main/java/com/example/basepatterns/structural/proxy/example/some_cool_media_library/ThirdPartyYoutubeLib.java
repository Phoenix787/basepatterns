package com.example.basepatterns.structural.proxy.example.some_cool_media_library;


import java.util.HashMap;

/*
Интерфейс удалённого сервиса
 */
public interface ThirdPartyYoutubeLib {
     HashMap<String, Video> popularVideos();

     Video getVideo(String videoId);
}
