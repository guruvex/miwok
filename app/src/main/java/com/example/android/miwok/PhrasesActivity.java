package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        words.add(new word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here.","әnni'nem", R.raw.phrase_come_here));

        WordAdapter displayWordAdapter = new WordAdapter (this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(displayWordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                word sound = words.get(position);

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, sound.getSoundResourceID());
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
