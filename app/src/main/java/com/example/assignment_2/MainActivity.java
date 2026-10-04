package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    RadioGroup rgGender;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Java variables to XML views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Handle Submit button click
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            int selectedId = rgGender.getCheckedRadioButtonId();

            // Validate the form
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this,
                        "Please enter your name and email",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedId == -1) {
                Toast.makeText(this,
                        "Please select your gender",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedGender =
                    findViewById(selectedId);

            String gender =
                    selectedGender.getText().toString();

            // Create an Intent to open Screen 2
            Intent intent =
                    new Intent(MainActivity.this,
                            DetailsActivity.class);

            // Pass values to Screen 2
            intent.putExtra("USER_NAME", name);
            intent.putExtra("USER_EMAIL", email);
            intent.putExtra("USER_GENDER", gender);

            // Open Screen 2
            startActivity(intent);
        });
    }
}