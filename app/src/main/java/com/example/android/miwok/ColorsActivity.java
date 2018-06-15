package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<word> words = new ArrayList<>();
        words.add(new word("red","weṭeṭṭi"));
        words.add(new word("green","chokokki"));
        words.add(new word("brown","ṭakaakki"));
        words.add(new word("gray","ṭopoppi"));
        words.add(new word("black","kululli"));
        words.add(new word("white","kelelli"));
        words.add(new word("dusty yellow","ṭopiisә"));
        words.add(new word("mustard yellow","chiwiiṭә"));

        WordAdapter displayWordAdapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(displayWordAdapter);
    }

}
