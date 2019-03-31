package com.kishan00747.truenews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kishan00747.truenews.components.CheckableButton;
import com.kishan00747.truenews.model.NewsCategory;
import com.kishan00747.truenews.model.NewsCategoryList;
import com.kishan00747.truenews.model.NewsSourceList;
import com.kishan00747.truenews.model.User;

import java.util.ArrayList;

public class InitialActivity extends AppCompatActivity {

    private static final String TAG = "InitialActivity";

    ImageView nextIcon;
    Fragment fragment;

    String strName, strMobile, strEmail, strPass;

    ArrayList<String> categoryList;
    ArrayList<String> sourceList;

    FirebaseFirestore db;
    DocumentReference users;

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }

    public ArrayList<String> getSourceList() {
        return sourceList;
    }

    public void setSourceList(ArrayList<String> sourceList) {
        this.sourceList = sourceList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        NewsCategoryList newsCategoryList = new NewsCategoryList();
        categoryList = new ArrayList<>(newsCategoryList.getCategoryArrayList().size());

        NewsSourceList newsSourceList = new NewsSourceList();
        sourceList = new ArrayList<>(newsSourceList.getSourceArrayList().size());

        db = FirebaseFirestore.getInstance();
        users = db.collection("Users").document();

        fragment = new CategoryFragment();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nextIcon = findViewById(R.id.next_icon);

        //getting intent extras
        strName = getIntent().getStringExtra("name");
        strMobile = getIntent().getStringExtra("mobile");
        strEmail = getIntent().getStringExtra("email");
        strPass = getIntent().getStringExtra("pass");


        //calling next fragment on next item click icon
        nextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: InitialActivity");
                manageFragments(view);
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    fragment).commit();
        }
    }

    private void manageFragments(View view){

        if(fragment instanceof CategoryFragment)
        {
            Log.d(TAG, "manageFragments: CategoryFragment");
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new MediaSourcesFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(fragment instanceof MediaSourcesFragment)
        {
            Log.d(TAG, "manageFragments: MediaSourceFragment");
            User user = new User(strName, strMobile, strEmail, strPass, categoryList, sourceList);
            users.set(user)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "onSuccess: data inserted ");
                            startNextIntent();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: data not inserted");
                            Toast.makeText(InitialActivity.this, "Registration Failed!!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }

    void startNextIntent(){

        Toast.makeText(this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        finish();

    }
}
