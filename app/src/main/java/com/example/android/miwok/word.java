package com.example.android.miwok;

/**
 * Created by james on 6/12/2018.
 */

public class word {

    //this is the devices default language word
    private String mDefaultTranslation;
    //miwok translation of the word.
    private String mMiwokTranslation;

    public word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

}



