package com.example.manan.materialdemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "Row " + position + " clicked", Toast.LENGTH_SHORT).show();
                final CoordinatorLayout mCordLayout = (CoordinatorLayout) findViewById(R.id.mainView);
                Snackbar.make(mCordLayout, "Row " + position + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        final ArrayList<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            dataList.add("Item" + i);
        }

        final MyListAdapter mListAdapter = new MyListAdapter(getApplicationContext(), dataList);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.add("FAB Item");
                mListAdapter.notifyDataSetChanged();
            }
        });

        mListView.setAdapter(mListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
