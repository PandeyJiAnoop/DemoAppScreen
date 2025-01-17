package com.akp.android.Basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akp.android.MainActivity;
import com.akp.android.R;

public class LoginActivity extends AppCompatActivity {
    AppCompatButton login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findId();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void findId() {
        login=findViewById(R.id.login_btn);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}