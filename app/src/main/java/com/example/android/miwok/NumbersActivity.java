package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


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

        ArrayAdapter<word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        //int i = 0;
        //while (i < words.size() ) {
        //    TextView wordView = new TextView(this);
        //    wordView.setText(words.get(i));
        //    rootView.addView(wordView);
        //    i++;
        //}
    }
}
