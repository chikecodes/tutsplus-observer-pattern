package com.chikeandroid.tutsplusobserverpattern;

/**
 * Created by Chike on 6/6/2017.
 */

public interface Subject {
    void registerObserver(RepositoryObserver repositoryObserver);
    void removeObserver(RepositoryObserver repositoryObserver);
    void notifyObservers();
}
