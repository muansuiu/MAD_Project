package com.example.madprojectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ActivityForFragment extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    BookListFragment bookListFragment = new BookListFragment();

    MyBooksFragment myBooksFragment = new MyBooksFragment();

    Logoutfragment logoutfragment = new Logoutfragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragment);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,bookListFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,bookListFragment).commit();
                        return true;

                    case R.id.logout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,logoutfragment).commit();
                        return true;


                    case R.id.myList:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,myBooksFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}