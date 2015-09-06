package com.suyonoion.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences ganti_pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        final String ganti_str = ganti_pref.getString("pilihLayout", "layout1");
        setContentView(setResource(ganti_str,"layout"));
    }

    public void onResume() {
        super.onResume();
        this.onCreate(null);
    }

    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }

}
