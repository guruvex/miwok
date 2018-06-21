package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        ArrayList<word> words = new ArrayList<>();
        words.add(new word("one","lutti"));
        words.add(new word("two","otiiko"));
        words.add(new word("three","tolookosu"));
        words.add(new word("four","oyyisa"));
        words.add(new word("five","massokka"));
        words.add(new word("six","temmokka"));
        words.add(new word("seven","kenekaku"));
        words.add(new word("eight","kawinta"));
        words.add(new word("nine","wo'e"));
        words.add(new word("ten","na'aacha"));

        WordAdapter displayWordAdapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(displayWordAdapter);
    }
}


