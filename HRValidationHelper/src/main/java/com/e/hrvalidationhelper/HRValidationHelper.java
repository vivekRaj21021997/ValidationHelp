package com.e.hrvalidationhelper;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class HRValidationHelper {

    //This method is used to validate the email
    public static boolean isValidEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.toLowerCase().trim().matches(emailPattern);
    }

    //This is used to check string null
    public static boolean isNull(String input) {
        return (input == null || input.trim().equals("") || input.length() < 1 || input.trim().equals("null"));
    }

    //This is used to check the string is optional or not
    public static String optional(String input){
        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){
            return "";
        }else {
            return input;
        }
    }

    //This is used to String will be blank or not
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
    public static int setScreenWidthDouble(View view, Context context, double width) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().width = (int) (displayMetrics.widthPixels * width);
        return view.getLayoutParams().width;
    }


    public static int setScreenHeightDouble(View view, Context context, double height) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().height = (int)(displayMetrics.heightPixels * height);
        return view.getLayoutParams().height;
    }



    // This is used to set the screen width of the mobile
    public static int setScreenWidth(View view, Context context, int width) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().width = (int)(displayMetrics.widthPixels * width);
        return view.getLayoutParams().width;
    }

    // This is used to set the height of the mobile
    public static int setScreenHeight(View view, Context context, int height) {
        DisplayMetrics displayMetrics =new  DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.getLayoutParams().height = (int)(displayMetrics.heightPixels * height);
        return view.getLayoutParams().height;
    }

    //This can be used to set the maximum mobile Number length
    public static  void setEditTextMaxLength(final EditText editText, int length) {
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(length);
        editText.setFilters(FilterArray);
    }

    //This method is restrict the emoji in the edittext
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

    //This method help to find tha address for using lat and lng
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

    // This method is used to find the current postal code of the current location
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

    //This method is used to fixed number decimal position
    public static void setNumberBeforeAfterDecimal(final EditText editText, final int beforeDecimal, final int afterDecimal){

        editText.setFilters(new InputFilter[]{
                new DigitsKeyListener(Boolean.FALSE, Boolean.TRUE) {

                    @Override
                    public CharSequence filter(CharSequence source, int start, int end,
                                               Spanned dest, int dstart, int dend) {

                        String temp = editText.getText() + source.toString();

                        if (temp.equals(".")) {
                            return "0";
                        } else if (temp.equals("0")) {
                            return ""; // don't allow beginning with a 0
                        } else if (!temp.contains(".")) {
                            // no decimal point placed yet
                            if (temp.length() > beforeDecimal) {
                                return "";
                            }
                        } else {
                            temp = temp.substring(temp.indexOf(".") + 1);
                            if (temp.length() > afterDecimal) {
                                return "";
                            }
                        }
                        return super.filter(source, start, end, dest, dstart, dend);
                    }
                }
        });
    }

    //This method add the time zone in your project
    public static String getTimezone() {
        TimeZone tz = TimeZone.getDefault();
        return tz.getID() + "";
    }

    //This method change date format
   public static String getDateFormat(String date,String inputDate,String outputDate) {
        if (date == null) return "";
        SimpleDateFormat input = new SimpleDateFormat(inputDate, Locale.US);
        SimpleDateFormat output = new SimpleDateFormat(outputDate, Locale.US);
        Date d = null;
        try {
            d = input.parse(date);
            assert d != null;
            return output.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }





}
