package com.suyonoion.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Suyono on 9/12/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

public class PilihLayout extends LinearLayout {
    View view;
    PilihLayout v;
    String  pilihlayout="pilihlayout",
            pilihLayout="pilihLayout",
            id="id",
            layout="layout",
            layout1="layout1";
    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }
    public PilihLayout(Context context) {
        super(context);
        if (!isInEditMode()){
         init();
        }
    }
    public PilihLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()){
         init();
        }
    }

    private void init() {

        SharedPreferences ganti_pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        final String ganti_str = ganti_pref.getString(pilihLayout, layout1);

        view= LayoutInflater.from(getContext()).inflate(setResource(ganti_str,layout), null, true);
        v = (PilihLayout) findViewById(setResource(pilihlayout,id));
        v.addView(view);
    }
}
