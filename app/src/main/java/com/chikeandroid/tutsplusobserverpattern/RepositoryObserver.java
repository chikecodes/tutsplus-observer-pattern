package com.chikeandroid.tutsplusobserverpattern;

/**
 * Created by Chike on 6/6/2017.
 */

public interface RepositoryObserver {
    void onUserDataChanged(String fullname, int age);
}
