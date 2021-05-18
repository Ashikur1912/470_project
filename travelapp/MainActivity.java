package com.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.travelapp.Adapter.RecentsAdapter;
import com.travelapp.Adapter.TopPlacesAdapter;
import com.travelapp.model.RecentsData;
import com.travelapp.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<RecentsData> recentsDataList = new ArrayList<>();

        recentsDataList.add(new RecentsData("AM Lake","India","Starting From $150",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","Starting From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","Starting From $150",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","Starting From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","Starting From $150",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","Starting From $300",R.drawable.recentimage2));

        setRecentRecycler(recentsDataList);


        List<TopPlacesData> topPlacesDataList = new ArrayList<>();

        topPlacesDataList.add(new TopPlacesData("AM Lake","India","Starting From $150",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Nilgiri Hills","India","Starting From $300",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("AM Lake","India","Starting From $150",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Nilgiri Hills","India","Starting From $300",R.drawable.topplaces));

        setTopPlacesRecycler(topPlacesDataList);

    }

    private void setRecentRecycler(List<RecentsData> recentsDataList){
        recentRecycler = findViewById(R.id.recents_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);



    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){
        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this,topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);



    }
}