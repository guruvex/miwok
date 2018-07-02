package com.example.android.miwok;

/**
 * Created by james on 6/12/2018.
 */

public class word {

    //this is the devices default language word
    private String mDefaultTranslation;
    //miwok translation of the word.
    private String mMiwokTranslation;
    //image for the miwok word
    private int mImageResourceID;
    //sound for the miwok word
    private int mSoundID;

    // builds word objects that are the english to miwok translations.
    // adds sound to the object
    public word(String defaultTranslation, String miwokTranslation,int soundResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundID = soundResourceID;
    }
    //builds the word objects that are english to miwok with images.
    //adds sound and image to the object
    public word(String defaultTranslation, String miwokTranslation, int imageResourceID, int  soundResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
        mSoundID = soundResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() {return mImageResourceID;}

    public int getSoundResourceID() {return mSoundID;}
}



