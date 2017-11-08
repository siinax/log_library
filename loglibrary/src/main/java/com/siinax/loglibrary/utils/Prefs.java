package com.siinax.loglibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import java.util.Map;
import java.util.Set;

/**
 * Created by siinax on 2017/10/7.
 */

public class Prefs {

    private SharedPreferences mPreferences ;

    private SharedPreferences.Editor mEditor ;

    private Prefs(){}

    private Prefs(Context context){
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPreferences.edit();
    }

    public Prefs getInstan(Context context){
        return new Prefs(context);
    }


    /**
     * ============================PUT===================================
     * */

    public void putInt(String key, int value){
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    public void putBoolean(String key, boolean value){
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    public void putString(String key, String value){
        mEditor.putString(key, value);
        mEditor.apply();
    }

    public void putFloat(String key, float value){
        mEditor.putFloat(key, value);
        mEditor.apply();
    }

    public void putLong(String key, long value){
        mEditor.putLong(key, value);
        mEditor.apply();
    }

    public void putStringSet(String key, Set<String> value){
        mEditor.putStringSet(key, value);
        mEditor.apply();
    }

    public void remove(String key){
        mEditor.remove(key);
        mEditor.apply();
    }

    public void clear(){
        mEditor.clear();
        mEditor.apply();
    }

    /**
     * ============================GET===================================
     * */
    public int getInt(String key,int defValue){
        return mPreferences.getInt(key, defValue);
    }

    public String getString(String key,String defValue){
        return mPreferences.getString(key, defValue);
    }

    public boolean getBoolean(String key,boolean defValue){
        return mPreferences.getBoolean(key, defValue);
    }

    public float getFloat(String key,float defValue){
        return mPreferences.getFloat(key, defValue);
    }

    public long getLong(String key,long defValue){
        return mPreferences.getLong(key, defValue);
    }

    public Map<String, ?> getAll(){
        return mPreferences.getAll();
    }

    public Set<String> getStringSet(String key,Set<String> defValue){
        return mPreferences.getStringSet(key, defValue);
    }
}
