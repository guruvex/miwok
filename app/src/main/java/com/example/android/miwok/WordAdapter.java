package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by james on 6/13/2018.
 */

public class WordAdapter extends ArrayAdapter<word> {

     private final int mResource;

     public WordAdapter (Context context, int resource, List word){
         super(context,0 ,word);
         mResource = resource;
     }
}