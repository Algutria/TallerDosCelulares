package com.tallerdosclases.tallerdosclase;

import android.content.res.Resources;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Phone> phones = new ArrayList();

    public static void savePhone(Phone operation){
        phones.add(operation);
    }

    public static ArrayList<Phone> getPhones(){
        return phones;
    }

    public static int getBlackApplesCount(Resources resources){
        int count = 0;
        for (int i = 0; i < phones.size(); i++) {
            String dataColor = new String(phones.get(i).getColor());
            String colorTxt = new String(resources.getString(R.string.black));

            String dataBrand = new String(phones.get(i).getBrand());
            String brandTxt = new String(resources.getString(R.string.apple));

            boolean isApple = dataBrand.equals(brandTxt);
            boolean isBlack = dataColor.equals(colorTxt);

            if(isApple && isBlack){
                count++;
            }
        }

        return count;
    }

    public static double getNokiaPriceAverage(Resources resources){
        double sum = 0, count = 0;

        for (int i = 0; i < phones.size(); i++) {
            String dataBrand = new String(phones.get(i).getBrand());
            String brandTxt = new String(resources.getString(R.string.nokia));

            boolean isNokia = dataBrand.equals(brandTxt);

            if(isNokia){
                count++;
                sum += phones.get(i).getPrice();
            }
        }

        if(count == 0){
            return 0;
        }

        return sum / count;

    }
}
