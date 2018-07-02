package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        words.add(new word("father","әpә",R.drawable.family_father, R.raw.family_father));
        words.add(new word("mother","әṭa",R.drawable.family_mother, R.raw.family_mother));
        words.add(new word("son","angsi",R.drawable.family_son, R.raw.family_son));
        words.add(new word("daughter","tune",R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new word("older brother","taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new word("younger brother","chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new word("older sister","teṭe",R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new word("younger sister","kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new word("grandmother","ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new word("grandfather","paapa",R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter displayWordAdapter = new WordAdapter (this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(displayWordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                word sound = words.get(position);

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, sound.getSoundResourceID());
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
