package com.chikeandroid.tutsplusobserverpattern.javaobserver;

import android.os.Handler;

import java.util.Observable;

/**
 * Created by Chike on 6/6/2017.
 */
public class UserDataRepository extends Observable {

    private String mFullName;
    private int mAge;
    private static UserDataRepository INSTANCE = null;

    private UserDataRepository() {
        getNewDataFromRemote();
    }

    /**
     * Returns a single instance of this class, creating it if necessary.
     * @return the {@link UserDataRepository} instance
     */
    public static UserDataRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserDataRepository();
        }

        return INSTANCE;
    }

    // Simulate network
    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUserData("Johnson Onu", 5000);
            }
        }, 10000);
    }

    public void setUserData(String fullName, int age) {
        mFullName = fullName;
        mAge = age;
        setChanged();
        notifyObservers();
    }

    public String getFullName() {
        return mFullName;
    }

    public int getAge() {
        return mAge;
    }
}
