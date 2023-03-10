package com.rokterkhoje.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
boolean isSkipSignUp;
TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        isSkipSignUp = preferences.getBoolean("isSkipSignUp", false);

        textView4=findViewById(R.id.textView4);


        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isSkipSignUp", true);
                editor.apply();
                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            }
        });

    }
}