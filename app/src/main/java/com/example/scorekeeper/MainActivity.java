package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG1, TAG2;
    private int val1, val2;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.text1);
        tv2 = findViewById(R.id.text2);
        TAG1="team1value";
        TAG2="team2value";
        val1 = 0;
        val2 = 0;
        if (savedInstanceState != null) {
            val1 = savedInstanceState.getInt(TAG1);
            Log.d("patata", "Despues " + Integer.toString(val1));
            val2 = savedInstanceState.getInt(TAG2);
            Log.d("patata", Integer.toString(val2));
            tv1.setText(Integer.toString(val1));
            tv2.setText(Integer.toString(val2));
        }
    }

    public void increaseScore(View view) {
        if (view.equals(findViewById(R.id.plus1))) {
            tv1.setText(Integer.toString(++val1));
        } else {
            tv2.setText(Integer.toString(++val2));
        }
    }


    public void decreaseScore(View view) {
        if (view.equals(findViewById(R.id.minus1))) {
            tv1.setText(Integer.toString(--val1));
        } else {
            tv2.setText(Integer.toString(--val2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(TAG1, val1);
        outState.putInt(TAG2, val2);
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.daymode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.nightmode);
        }
        return true;
    }

}