package com.e.hrvalidationhelper;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import java.util.regex.Pattern;

public class HRValidationHelper {

    private  String countryCode;

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

    public static  void setEditTextMaxLength(final EditText editText, int length) {
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(length);
        editText.setFilters(FilterArray);
    }

    public static void setDisableEmojiInTitle(final EditText editText) {
        InputFilter emojiFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int index = start; index < end - 1; index++) {
                    int type = Character.getType(source.charAt(index));

                    if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
                        return "";
                    }
                }
                return null;
            }
        };
        editText.setFilters(new InputFilter[]{ emojiFilter });
    }
}
