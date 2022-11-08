package com.e.hrvalidationhelper;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

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

    public static int setScreenWidth(View view, Context context, int width) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().width = (int)(displayMetrics.widthPixels * width);
        return view.getLayoutParams().width;
    }

    public static int setScreenHeight(View view, Context context, int height) {
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
//This method is not show the emoji in the edittext
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

    //This method help to find tha address of using lat and lng
    public static String getCompleteAddressString(Context context, double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 10);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.i("Address=========>", strReturnedAddress.toString());
            } else {
                Log.i("Address=======>", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Address:========>", "Can not get Address!");
        }
        return strAdd;
    }
    public static String getCurrentPostalCode(Context context, double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getPostalCode());
                }
                strAdd = strReturnedAddress.toString();
                Log.i("Postal code=========>", strReturnedAddress.toString());
            } else {
                Log.i("Postal code=======>", "No postal code returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Postal code:========>", "Can not get postal code!");
        }
        return strAdd;
    }








}
