package com.example.madprojectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class showAllBooks extends AppCompatActivity {

    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_books);

        listView = findViewById(R.id.listViewId);
        databaseHelper = new DatabaseHelper(this);
        loadData();
    }

    public void loadData()
    {
        ArrayList<String> listData = new ArrayList<>();

        Cursor cursor = databaseHelper.showAllData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(),"No data to show",Toast.LENGTH_LONG).show();

        } else {
            while (cursor.moveToNext())
            {
                listData.add("Book:" + cursor.getString(0) + "\t " + "Author:"+ cursor.getString(1) + "\t " + "Language:" + cursor.getString(2) + "\t " + "Location:" + cursor.getString(3)+ "\t " + "Mobile No:" + cursor.getString(4));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item,R.id.textViewId,listData);
        listView.setAdapter(adapter);


    }
}