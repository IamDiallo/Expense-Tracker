package com.example.expensetracker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.expensetracker.TabFragments.Analysis;
import com.example.expensetracker.TabFragments.List;
import com.example.expensetracker.TabFragments.Transaction;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements Transaction.TransactionListener {

    private static final String TAG = "MainActivity";

    ViewPager viewPager;
    TabLayout tabLayout;

    Transaction transaction;
    Analysis analysis;
    List list;
    private DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        transaction = new Transaction();
        analysis = new Analysis();
        list = new List();

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPagerAdapter);

       // db = new DatabaseHandler(this);
       // db.getWritableDatabase();
       // db.clear();
    }

    @Override
    public void onAddButtonClicked() {
        analysis.display();
    }

    class MyPagerAdapter extends FragmentPagerAdapter   {

        String fragmentNames[] = {"Transaction", "Analysis", "List"};


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position)    {
                case 0: return transaction;
                case 1: return analysis;
                case 2: return list;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return fragmentNames.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentNames[position];
        }
    }

}
