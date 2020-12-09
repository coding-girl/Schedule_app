package com.nau.schedule.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nau.schedule.fragments.SettingsFragment;
import com.nau.schedule.R;

public class SettingsActivity extends AppCompatActivity {
    public static final String
            KEY_SEVEN_DAYS_SETTING = "sevendays";
    public static final String
            KEY_LANGUAGE_SETTING = "language";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
