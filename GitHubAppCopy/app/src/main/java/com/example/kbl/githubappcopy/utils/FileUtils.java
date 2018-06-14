package com.example.kbl.githubappcopy.utils;

import android.content.res.AssetManager;

import com.example.kbl.githubappcopy.MyApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utils for files
 */
public class FileUtils {

    private FileUtils() {
    }

    public static String loadJsonFromAssets(final String file) throws IOException {
        AssetManager assetManager = MyApplication.getInstance().getApplicationContext().getAssets();
        StringBuilder buf = new StringBuilder();
        BufferedReader in = null;
        InputStream json = null;
        try {
            json = assetManager.open(file);
            in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (json != null) {
                json.close();
            }
        }
        return buf.toString();
    }
}
