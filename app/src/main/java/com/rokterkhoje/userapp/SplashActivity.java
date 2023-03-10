package com.rokterkhoje.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstTime = preferences.getBoolean("isFirstTime", true);
       // SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isSkipSignUp = preferences.getBoolean("isSkipSignUp", false);


        if (isFirstTime) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();

            Thread thread =new Thread(){
                public void run(){
                    try {

                        sleep(1500);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        Intent intent=new Intent(SplashActivity.this , OneTimeActivity.class);
                        startActivity(intent);
                    }
                }
            };thread.start();

        }else if (isSkipSignUp){

            Thread thread =new Thread(){
                public void run(){
                    try {

                        sleep(1500);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        Intent intent=new Intent(SplashActivity.this , MainActivity.class);
                        startActivity(intent);
                    }
                }
            };thread.start();
        }
        else {
            Thread thread =new Thread(){
                public void run(){
                    try {

                        sleep(1500);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        Intent intent=new Intent(SplashActivity.this , SignUpActivity.class);
                        startActivity(intent);
                    }
                }
            };thread.start();
            finish();

        }


//        Thread thread =new Thread(){
//            public void run(){
//                try {
//
//                    sleep(1500);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//                finally {
//                    Intent intent=new Intent(SplashActivity.this , SignUpActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };thread.start();
//        finish();


    }
}