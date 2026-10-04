package com.example.assignment_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvGender;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Connect Java variables to XML views
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvGender = findViewById(R.id.tvGender);
        btnBack = findViewById(R.id.btnBack);

        // Receive values from Screen 1
        String name =
                getIntent().getStringExtra("USER_NAME");

        String email =
                getIntent().getStringExtra("USER_EMAIL");

        String gender =
                getIntent().getStringExtra("USER_GENDER");

        // Display received values
        tvName.setText("Name     :  " + name);
        tvEmail.setText("Email    :  " + email);
        tvGender.setText("Gender   :  " + gender);

        // Return to Screen 1
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}