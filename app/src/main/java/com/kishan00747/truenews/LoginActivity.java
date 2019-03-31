package com.kishan00747.truenews;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    TextView tvSignUp;
    Button btnLogin, btnGuest;

    TextInputEditText email, pass;

    FirebaseFirestore db;
    DocumentReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvSignUp = (TextView) findViewById(R.id.tv_signUp);
        btnLogin = (Button) findViewById(R.id.btn_Login);
        email = (TextInputEditText) findViewById(R.id.et_email);
        pass = (TextInputEditText) findViewById(R.id.et_pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
                finish();
            }
        });

        db = FirebaseFirestore.getInstance();
        users = db.collection("Users").document();
        users.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


        setListeners();
    }

    private void setListeners() {
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register);
                finish();

            }
        });


    }
}