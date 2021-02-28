package com.example.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    EditText name, password, repassword, birthDate, email, number, city;
    Button register, cancel;
    DBHelper DB;
    RadioGroup gender;
    User new_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final DBHelper DBHelper1 = new DBHelper(this);

        name = (EditText) findViewById(R.id.FullName);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.BtnRegister);
        repassword = (EditText) findViewById(R.id.RetypePassword);
        cancel = (Button) findViewById(R.id.BtnCancel);
        gender = (RadioGroup) findViewById(R.id.RadioGroup);
        birthDate = (EditText) findViewById(R.id.BirthDate);
        email = (EditText) findViewById(R.id.Email);
        number = (EditText) findViewById(R.id.PhoneNumber);
        city = (EditText) findViewById(R.id.city);
        ;
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user1 = name.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String date1 = birthDate.getText().toString();
                String email1 = email.getText().toString();
                String number1 = number.getText().toString();
                String city1 = city.getText().toString();

                if (user1.equals("") || pass.equals("") || repass.equals("") || date1.equals("")
                        || email1.equals("") || number1.equals("") || city1.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all information", Toast.LENGTH_SHORT).show();
                else {
                    if (!emptyValidation()) {
                        DBHelper1.addUser(new User(user1, pass, repass, date1, email1, number1, city1));
                        Toast.makeText(RegisterActivity.this, "Added User", Toast.LENGTH_SHORT).show();
                        email.setText("");
                        password.setText("");
                    } else {
                        Toast.makeText(RegisterActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                    }
                }
                if (pass.equals(repass)) {

                            Toast.makeText(RegisterActivity.this, "successfully registerd", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), home.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "registration failed", Toast.LENGTH_SHORT).show();
                        }

            }

            private boolean emptyValidation() {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}