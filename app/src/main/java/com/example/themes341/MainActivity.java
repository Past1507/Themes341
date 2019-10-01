package com.example.themes341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.app.Activity;

import java.util.Locale;

import static com.example.themes341.Utils.*;

public class MainActivity extends AppCompatActivity {
    Spinner switch_language;
    Button btn_switch;
    Spinner switching_theme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select = switch_language.getSelectedItemPosition();
                Locale locale = null;
                if (select==0) {
                    locale = new Locale("ru");}
                else {
                    locale = new Locale("en");
                }

                int selected_theme = switching_theme.getSelectedItemPosition();
                switch (selected_theme) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }

    private void initView() {
        switch_language = findViewById(R.id.switching);
        btn_switch = findViewById(R.id.btn_switch);
        switching_theme = findViewById(R.id.switching_theme);
    }
}
