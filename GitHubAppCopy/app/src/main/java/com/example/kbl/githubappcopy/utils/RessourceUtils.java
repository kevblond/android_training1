package com.example.kbl.githubappcopy.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.example.kbl.githubappcopy.MyApplication;

/**
 * utils for resources
 */
public final class RessourceUtils {
    private RessourceUtils() {

    }

    /**
     * Get the color code given its ressource ID
     *
     * @param ressourceID the color searched
     * @return the color code
     */
    public static Integer getColor(final Integer ressourceID) {
        return ContextCompat.getColor(MyApplication.getInstance().getApplicationContext(), ressourceID);
    }

    /**
     * Get the drawable given its ressource ID
     *
     * @param ressourceID the drawable searched
     * @return the drawable code
     */
    public static Drawable getDrawable(final Integer ressourceID) {
        return ContextCompat.getDrawable(MyApplication.getInstance().getApplicationContext(), ressourceID);
    }

    /**
     * Gets the resource of the app.
     *
     * @return the resource of the app.
     */
    public static Resources getResources() {
        return MyApplication.getInstance().getApplicationContext().getResources();
    }

    /**
     * Gets a string from the resources.
     *
     * @param resId of the string.
     * @return the desired string.
     */
    public static String getString(final int resId) {
        return getResources().getString(resId);
    }

    /**
     * Gets a string from the resources.
     *
     * @param resId of the string.
     * @param args  arguments
     * @return the desired string.
     */
    public static String getString(final int resId, Object... args) {
        return getResources().getString(resId, args);
    }

    /**
     * Gets a string quantity from the resources.
     *
     * @param resId    of the string quantity.
     * @param quantity the quantity
     * @param args     arguments
     * @return the desired string quantity.
     */
    public static String getQuantityString(final int resId, final int quantity, final Object... args) {
        return getResources().getQuantityString(resId, quantity, args);
    }

    /**
     * Gets a string array from the resources.
     *
     * @param resId of the string array.
     * @return the desired string array.
     */
    public static String[] getStringArray(final int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * Gets an integer from the resources.
     *
     * @param resId of the integer.
     * @return the desired integer.
     */
    public static int getInteger(final int resId) {
        return getResources().getInteger(resId);
    }

    /**
     * Gets a dimen from the resources.
     *
     * @param resId of the integer.
     * @return the desired integer.
     */
    public static float getDimen(final int resId) {
        return getResources().getDimension(resId);
    }
}
