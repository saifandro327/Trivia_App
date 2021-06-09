package com.app.triviaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.app.triviaapp.utils.SwipeDisabledViewPager;
import com.app.triviaapp.view.HistoryActivity;
import com.app.triviaapp.view.NameFragment;
import com.app.triviaapp.view.Question1Fragment;
import com.app.triviaapp.view.Question2Fragment;
import com.app.triviaapp.view.SummaryFragment;
import com.app.triviaapp.view.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity {
    public static SwipeDisabledViewPager viewPager;
    private String username;

    private String answer1;

    private Question1Fragment question1Fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (SwipeDisabledViewPager) findViewById(R.id.view_pager);

        //Adding fragments to the ViewPager
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(NameFragment::new);
        pagerAdapter.addFragment(Question1Fragment::new);
        pagerAdapter.addFragment(Question2Fragment::new);
        pagerAdapter.addFragment(SummaryFragment::new);
        viewPager.setAdapter(pagerAdapter);
        question1Fragment = new Question1Fragment();

    }

    //Sending name to the Other Fragment
    public String getUsernamet() {
        return this.username;
    }

    public void setUsername(String newValue) {
        this.username = newValue;
    }

    // Implementing the Menu in Main Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.history_menu:
                startActivity(new Intent(this, HistoryActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}