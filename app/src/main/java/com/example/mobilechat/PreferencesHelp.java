package com.example.mobilechat;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelp {

	public static final String LOCAL_SETTINGS = "localsettings";
	@SuppressWarnings("deprecation")
	public static final int MODE = Context.MODE_PRIVATE ;

	public static boolean isVal(Context mContext, String name) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		return sf.getBoolean(name, false);
	}

	public static void putVal(Context mContext, String name, boolean val) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		sf.edit().putBoolean(name, val).commit();
	}

	public static String getVal(Context mContext, String name) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		return sf.getString(name, "");
	}

	public static void putVal(Context mContext, String name, String val) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		sf.edit().putString(name, val).commit();
	}

	public static int getInt(Context mContext, String name) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		return sf.getInt(name, R.mipmap.soldier);
	}

	public static void putInt(Context mContext, String name, int val) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		sf.edit().putInt(name, val).commit();
	}

	public static void clearSettings(Context mContext) {
		SharedPreferences sf = mContext.getSharedPreferences(LOCAL_SETTINGS, MODE);
		sf.edit().clear().commit();
	}

}
