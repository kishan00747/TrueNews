package com.kishan00747.truenews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    Button btnNext, btnCancel;

    TextInputEditText name, mobile, email, password;

    //private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //private DocumentReference users = db.collection("Users").document();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        name = findViewById(R.id.et_name);
        mobile = findViewById(R.id.et_mobile);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_pass);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strName = name.getText().toString();
                String strMobile = mobile.getText().toString();
                String strEmail = email.getText().toString();
                String strPass = password.getText().toString();

                //Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
                intent.putExtra("name", strName);
                intent.putExtra("mobile", strMobile);
                intent.putExtra("email", strEmail);
                intent.putExtra("pass", strPass);
                startActivity(intent);
                finish();
            }
        });

    }

}
