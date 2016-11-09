package info.devexchanges.gridlistrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import info.devexchanges.gridlistrecyclerview.adapter.GridViewAdapter;
import info.devexchanges.gridlistrecyclerview.adapter.ListViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;
    private RecyclerView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private ArrayList<RecyclerViewItem> corporations;
    private ArrayList<RecyclerViewItem> operatingSystems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (RecyclerView) findViewById(R.id.list);
        gridView = (RecyclerView) findViewById(R.id.grid);

        setDummyData();

        listView.setHasFixedSize(true);
        gridView.setHasFixedSize(true);

        //set layout manager and adapter for "ListView"
        LinearLayoutManager horizontalManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(horizontalManager);
        listViewAdapter = new ListViewAdapter(this, corporations);
        listView.setAdapter(listViewAdapter);

        //set layout manager and adapter for "GridView"
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        gridView.setLayoutManager(layoutManager);
        gridViewAdapter = new GridViewAdapter(this, operatingSystems);
        gridView.setAdapter(gridViewAdapter);
    }

    private void setDummyData() {
        corporations = new ArrayList<>();
        corporations.add(new RecyclerViewItem(R.drawable.microsoft, "Microsoft"));
        corporations.add(new RecyclerViewItem(R.drawable.apple, "Apple"));
        corporations.add(new RecyclerViewItem(R.drawable.google, "Google"));
        corporations.add(new RecyclerViewItem(R.drawable.oracle, "Oracle"));
        corporations.add(new RecyclerViewItem(R.drawable.yahoo, "Yahoo"));
        corporations.add(new RecyclerViewItem(R.drawable.mozilla, "Mozilla"));

        operatingSystems = new ArrayList<>();
        operatingSystems.add(new RecyclerViewItem(R.drawable.bbos, "BlackBerry OS"));
        operatingSystems.add(new RecyclerViewItem(R.drawable.ios, "iOS"));
        operatingSystems.add(new RecyclerViewItem(R.drawable.tizen, "Tizen"));
        operatingSystems.add(new RecyclerViewItem(R.drawable.android, "Android"));
        operatingSystems.add(new RecyclerViewItem(R.drawable.symbian, "Symbian"));
        operatingSystems.add(new RecyclerViewItem(R.drawable.firefox_os, "Firefox OS"));
        operatingSystems.add(new RecyclerViewItem(R.drawable.wp_os, "Windows Phone OS"));
    }
}
