package com.example.themes341;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
    private static int selectedTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_BLACK = 1;
    public final static int THEME_BLUE = 2;

    public static void changeToTheme(Activity activity, int theme)
    {
        selectedTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (selectedTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppThemeGreen);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.AppThemeBlack);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppThemeBlue);
                break;
        }
    }
}
