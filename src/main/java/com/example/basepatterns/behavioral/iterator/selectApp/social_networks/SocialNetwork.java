package com.example.basepatterns.behavioral.iterator.selectApp.social_networks;

import com.example.basepatterns.behavioral.iterator.selectApp.iterators.ProfileIterator;

public interface SocialNetwork {
    public ProfileIterator createFriendsIterator(String profileEmail);

    public ProfileIterator createCoworkersIterator(String profileEmail);
}
