package com.ns.qosetqoe.utils;

import android.content.res.Resources;
import android.location.Location;
import android.text.TextUtils;

import com.ns.qosetqoe.models.ItemClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

public class UtilsClass {

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static String getRawResource(Resources res, int id) throws IOException {
        InputStream is = res.openRawResource(id);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        return writer.toString();
    }

    public static double parseDMS(String dms) {
        String[] temp1 =  dms.split("°");
        String[] temp2 = temp1[1].split("'");

        return Double.parseDouble(temp1[0]) + (Double.parseDouble(temp2[0])/60) + (Double.parseDouble(temp2[1])/3600);
    }

    public static int getSmallestDistance(List<ItemClass> items, Location location) {
        int index = 0;
        double min = items.get(0).getDistanceToLocation(location);

        for (int i=1; i<items.size(); i++){
            if (items.get(i).getDistanceToLocation(location) < min ){
                min = items.get(i).getDistanceToLocation(location);
                index = i;
            }
        }

        return index ;
    }
}
