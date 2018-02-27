package com.example.basepatterns.structural.proxy.example;

import com.example.basepatterns.structural.proxy.example.downloader.YoutubeDownloader;
import com.example.basepatterns.structural.proxy.example.proxy.YoutubeProxyClass;
import com.example.basepatterns.structural.proxy.example.some_cool_media_library.ThirdPartyYoutubeClass;

public class Demo {
    public static void main(String[] args) {
        YoutubeDownloader nativeDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeProxyClass());

        long naive = test(nativeDownloader);
        long smart = test(smartDownloader);

        System.out.println("Time saved by caching proxy: " + (naive - smart) + " ms");
    }

    private static long test(YoutubeDownloader downloader) {
        long start = System.currentTimeMillis();
        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - start;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
