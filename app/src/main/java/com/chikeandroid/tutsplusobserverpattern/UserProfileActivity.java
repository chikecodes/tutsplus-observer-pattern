package com.chikeandroid.tutsplusobserverpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Chike on 6/6/2017.
 */

public class UserProfileActivity extends AppCompatActivity implements RepositoryObserver {

    private Subject mUserDataRepository;
    private TextView mTextViewUserFullName;
    private TextView mTextViewUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mUserDataRepository = UserDataRepository.getInstance();
        mUserDataRepository.registerObserver(this);

        mTextViewUserFullName = (TextView) findViewById(R.id.tv_fullname);
        mTextViewUserAge = (TextView) findViewById(R.id.tv_age);
    }

    @Override
    public void onUserDataChanged(String fullname, int age) {
        mTextViewUserFullName.setText(fullname);
        mTextViewUserAge.setText(String.valueOf(age));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserDataRepository.removeObserver(this);
    }
}
