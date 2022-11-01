package com.e.hrvalidationhelper;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;

public class HRValidationHelper {

    public static boolean isValidEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.toLowerCase().trim().matches(emailPattern);
    }

    public static boolean isNull(String input) {
        return (input == null || input.trim().equals("") || input.length() < 1 || input.trim().equals("null"));
    }

    public static String optional(String input){
        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){
            return "";
        }else {
            return input;
        }
    }
    public static String optionalBlank(String input){
        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){
            return "";
        }else {
            return input;
        }
    }

    public static String optional(String input, @NonNull String optionalValue){
        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){
            return optionalValue;
        }else {
            return input;
        }
    }
    public static int setDimension(View view, Context context, int width, int height) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().width = (int)(displayMetrics.widthPixels * width);
        view.getLayoutParams().height=(int)(displayMetrics.heightPixels* height);
        return view.getLayoutParams().width;
    }

    public static int setWidth(View view, Context context, int width) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().width = (int)(displayMetrics.widthPixels * width);
        return view.getLayoutParams().width;
    }

    public static int setHeight(View view, Context context, int height) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().height = (int)(displayMetrics.heightPixels * height);
        return view.getLayoutParams().height;
    }
}
