package com.example.basepatterns.structural.proxy.example.proxy;

import com.example.basepatterns.structural.proxy.example.some_cool_media_library.ThirdPartyYoutubeClass;
import com.example.basepatterns.structural.proxy.example.some_cool_media_library.ThirdPartyYoutubeLib;
import com.example.basepatterns.structural.proxy.example.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * Сервисный класс для работы с кешем
 */
public class YoutubeProxyClass implements ThirdPartyYoutubeLib {
    private ThirdPartyYoutubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YoutubeProxyClass() {
        youtubeService = new ThirdPartyYoutubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()){
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        }else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;

    }

    public void reset(){
        cachePopular.clear();
        cacheAll.clear();
    }
}