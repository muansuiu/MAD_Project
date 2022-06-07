package com.example.madprojectfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MyBooksFragment extends Fragment  {

    EditText bookName, author, language, location, mobileNo;
    Button addBook;
    DatabaseHelper DB;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_my_books, container, false);



        bookName = (EditText) view.findViewById(R.id.bookNameId);
        author = (EditText) view.findViewById(R.id.authorId);
        language = (EditText) view.findViewById(R.id.languageId);
        location = (EditText) view.findViewById(R.id.locationId);
        mobileNo = (EditText) view.findViewById(R.id.mobileId);


        addBook = (Button) view.findViewById(R.id.btnAddBook);
        DB = new DatabaseHelper(getActivity());

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String book = bookName.getText().toString();
                String auth = author.getText().toString();
                String lang = language.getText().toString();
                String loc = location.getText().toString();
                String mobile = mobileNo.getText().toString();

                if(book.equals("")||auth.equals("")||lang.equals("")||loc.equals(""))
                    Toast.makeText(getActivity(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean insert =  DB.insertBookData(book,auth,lang,loc,mobile);
                    if(insert)
                    {
                        bookName.setText("");
                        author.setText("");
                        language.setText("");
                        location.setText("");
                        mobileNo.setText("");
                        Toast.makeText(getActivity(), "Book ADDED successfully", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

        // Inflate the layout for this fragment
       return view;
    }

}