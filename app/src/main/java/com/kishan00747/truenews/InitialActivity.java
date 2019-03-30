package com.kishan00747.truenews;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.kishan00747.truenews.components.CheckableButton;
import com.kishan00747.truenews.model.NewsCategory;
import com.kishan00747.truenews.model.NewsCategoryList;

public class InitialActivity extends AppCompatActivity {

    ImageView nextIcon;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        fragment = new CategoryFragment();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nextIcon = findViewById(R.id.next_icon);

        //calling next fragment on next item click icon
        nextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manageFragments();
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    fragment).commit();
        }
    }

    private void manageFragments(){

        if(fragment instanceof CategoryFragment)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new MediaSourcesFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(fragment instanceof MediaSourcesFragment)
        {
            Intent home = new Intent(this, MainActivity.class);
            startActivity(home);
            finish();
        }

    }
}
