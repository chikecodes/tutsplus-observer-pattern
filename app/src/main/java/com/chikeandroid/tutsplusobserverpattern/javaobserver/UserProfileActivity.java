package com.chikeandroid.tutsplusobserverpattern.javaobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.chikeandroid.tutsplusobserverpattern.R;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Chike on 6/6/2017.
 */

public class UserProfileActivity extends AppCompatActivity implements Observer {
    private Observable mUserDataRepositoryObservable;
    private TextView mTextViewUserFullName;
    private TextView mTextViewUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mTextViewUserAge = (TextView) findViewById(R.id.tv_age);
        mTextViewUserFullName = (TextView) findViewById(R.id.tv_fullname);

        mUserDataRepositoryObservable = UserDataRepository.getInstance();
        mUserDataRepositoryObservable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof UserDataRepository) {
            UserDataRepository userDataRepository = (UserDataRepository)observable;
            mTextViewUserAge.setText(String.valueOf(userDataRepository.getAge()));
            mTextViewUserFullName.setText(userDataRepository.getFullName());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserDataRepositoryObservable.deleteObserver(this);
    }
}
