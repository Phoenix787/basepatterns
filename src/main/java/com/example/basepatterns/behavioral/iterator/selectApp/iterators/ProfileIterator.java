package com.example.basepatterns.behavioral.iterator.selectApp.iterators;

import com.example.basepatterns.behavioral.iterator.selectApp.profile.Profile;

public interface ProfileIterator {
    public boolean hasNext();
    public Profile getNext();
    public void reset();
}
