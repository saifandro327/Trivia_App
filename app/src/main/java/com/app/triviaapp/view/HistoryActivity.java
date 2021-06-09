package com.app.triviaapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.triviaapp.R;
import com.app.triviaapp.db.DatabaseHelper;
import com.app.triviaapp.model.HistoryModel;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
RecyclerView recyclerViewHistory;
    DatabaseHelper database_helper;
    ArrayList<HistoryModel> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    recyclerViewHistory=(RecyclerView)findViewById(R.id.recyclerview);
    database_helper=new DatabaseHelper(HistoryActivity.this);
        arrayList = new ArrayList<HistoryModel>(database_helper.getgamesHistory());
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewHistory.setItemAnimator(new DefaultItemAnimator());
        HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(), this, arrayList);
        recyclerViewHistory.setAdapter(adapter);
    }
}