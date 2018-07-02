package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    // make the MediaPlayer object as a global object
    private MediaPlayer mMediaPlayer;

    // make the OnCompletionListener a global object
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);


        final ArrayList<word> words = new ArrayList<>();
        words.add(new word("one","lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new word("two","otiiko",R.drawable.number_two, R.raw.number_two));
        words.add(new word("three","tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new word("four","oyyisa",R.drawable.number_four, R.raw.number_four));
        words.add(new word("five","massokka",R.drawable.number_five, R.raw.number_five));
        words.add(new word("six","temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new word("seven","kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("eight","kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("nine","wo'e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("ten","na'aacha",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter displayWordAdapter = new WordAdapter (this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(displayWordAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                word sound = words.get(position);

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, sound.getSoundResourceID());
                mMediaPlayer.start();

                // release the media player after it has finished.
               mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });


    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}


