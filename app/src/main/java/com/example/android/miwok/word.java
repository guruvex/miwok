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

    // builds word objects that are the english to miwok translations.
    public word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    //builds the word objects that are english to miwok with images.
    public word(String defaultTranslation, String miwokTranslation, int imageResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() {return mImageResourceID;}

}



