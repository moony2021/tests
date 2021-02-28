package com.example.tests;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Email, password;
    private Button login, signup;
    DBHelper DB;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.Email1);
        password = (EditText) findViewById(R.id.password1);
        login = (Button) findViewById(R.id.btnSignIn);
        signup = (Button) findViewById(R.id.btnSignUp);
        final DBHelper DBHelper1 = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    User user = DBHelper1.queryUser(Email.getText().toString(), password.getText().toString());
                    if (user != null) {
                        Bundle mBundle = new Bundle();
                        mBundle.putString("user", user.getEMail());
                        Intent intent = new Intent(MainActivity.this, home.class);
                        intent.putExtras(mBundle);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Welcome " + user.getEMail(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                       password.setText("");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(Email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }
}


