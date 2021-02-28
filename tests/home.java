package com.example.tests;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvUser = findViewById(R.id.tvUser);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvUser.setText(bundle.getString("user"));
        }
    }

}
