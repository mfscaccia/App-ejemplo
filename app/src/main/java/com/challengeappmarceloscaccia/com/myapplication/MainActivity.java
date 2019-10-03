package com.challengeappmarceloscaccia.com.myapplication;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.challengeappmarceloscaccia.com.myapplication.Interfaces.OnBudgetCreationListener;

public class MainActivity extends AppCompatActivity implements OnBudgetCreationListener
        {

    private  FloatingActionButton mFabMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFabMain = (FloatingActionButton) findViewById(R.id.fabuttonMain);
        mFabMain.setOnClickListener(new View.OnClickListener() {
            Fragment fragment = null;
            @Override
            public void onClick(View view) {
                fragment = new BudgetsCreationFragment();
                if(fragment!=null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();
                }
            }
        });
    }

    @Override
    public void onBudgetCreationGuardarClickListener() {

    }


}
