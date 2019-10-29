package com.cookandroid.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login");

        Button loginBtn = (Button) findViewById(R.id.loginbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText id = (EditText) findViewById(R.id.id);
                EditText pwd = (EditText) findViewById(R.id.pwd);
                if(id.length() == 0 || id.equals("")) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if(pwd.length() == 0 || pwd.equals("")) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("id", id.getText().toString());
                    startActivityForResult(intent, 0);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
        }
    }
}
