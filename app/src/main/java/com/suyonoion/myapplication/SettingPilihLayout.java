package com.suyonoion.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by Suyono on 9/4/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
@SuppressWarnings("ALL")
public class SettingPilihLayout extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{
    String title = "Pemberitahuan";
    String message = "Sekedar Contoh";

    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        addPreferencesFromResource(setResource("pref_pilihlayout", "xml"));
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage(message);
        b.setCancelable(false);
        b.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.setTitle(title);
        AlertDialog ad = b.create();
        ad.show();
    }

    @Override
    public void onResume(){
        super.onResume();

        final String key_pilih="pilihLayout";
        ListPreference listPreference_pilih=(ListPreference)findPreference(key_pilih);
        final String values_pilih=PreferenceManager.getDefaultSharedPreferences(this).getString(key_pilih,key_pilih);
        final int index_pilih=listPreference_pilih.findIndexOfValue(values_pilih);
        if (index_pilih>=0){
            final String summary_pilih = (String) listPreference_pilih.getEntries()[index_pilih];
            listPreference_pilih.setSummary(summary_pilih);
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences options, String key) {

        if (key.equals("pilihLayout")){
            ListPreference listPreference=(ListPreference)findPreference(key);
            final String values=options.getString(key,key);
            final int index=listPreference.findIndexOfValue(values);
            if (index>=0){
                final String summary = (String) listPreference.getEntries()[index];
                listPreference.setSummary(summary);
            }
        }
    }

}
