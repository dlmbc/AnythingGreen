package com.example.anythinggreen;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private static final String TOTAL_TRASH = "total";
    private static final String TOTAL_TRASH_KEY = "total_key";
    private static final String TOTAL_CLOTHES = "clothes";
    private static final String TOTAL_CLOTHES_KEY = "clothes_key";
    private static final String TOTAL_EWASTE = "ewaste";
    private static final String TOTAL_EWASTE_KEY = "ewaste_key";
    private static final String TOTAL_PAPER = "paper";
    private static final String TOTAL_PAPER_KEY = "paper_key";
    private static final String TOTAL_PLASTIC = "plastic";
    private static final String TOTAL_PLASTIC_KEY = "plastic_key";
    private static final String TOTAL_GLASS = "glass";
    private static final String TOTAL_GLASS_KEY = "glass_key";
    private static final String TOTAL_METAL = "metal";
    private static final String TOTAL_METAL_KEY = "metal_key";


    public static void saveTotalTrashInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_TRASH, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_TRASH_KEY, total);
        editor.apply();
    }

    public static int loadTotalTrashFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_TRASH, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_TRASH_KEY, 0);
    }

    public static void saveTotalClothesInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_CLOTHES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_CLOTHES_KEY, total);
        editor.apply();
    }

    public static int loadTotalClothesFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_CLOTHES, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_CLOTHES_KEY, 0);
    }
    public static void saveTotalEwasteInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_EWASTE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_EWASTE_KEY, total);
        editor.apply();
    }

    public static int loadTotalEwasteFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_EWASTE, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_EWASTE_KEY, 0);
    }
    public static void saveTotalPaperInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_PAPER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_PAPER_KEY, total);
        editor.apply();
    }

    public static int loadTotalPaperFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_PAPER, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_PAPER_KEY, 0);
    }
    public static void saveTotalPlasticInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_PLASTIC, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_PLASTIC_KEY, total);
        editor.apply();
    }

    public static int loadTotalPlasticFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_PLASTIC, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_PLASTIC_KEY, 0);
    }
    public static void saveTotalGlassInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_GLASS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_GLASS_KEY, total);
        editor.apply();
    }

    public static int loadTotalGlassFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_GLASS, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_GLASS_KEY, 0);
    }
    public static void saveTotalMetalInPref(Context context, int total) {
        SharedPreferences pref = context.getSharedPreferences(TOTAL_METAL, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(TOTAL_METAL_KEY, total);
        editor.apply();
    }

    public static int loadTotalMetalFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOTAL_METAL, Context.MODE_PRIVATE);
        return pref.getInt(TOTAL_METAL_KEY, 0);
    }
}
