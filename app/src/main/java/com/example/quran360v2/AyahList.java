package com.example.holyquranv2v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.holyquranv2v2.R;
import com.example.holyquranv2v2.adapter.RecyclerViewAdapter;
import com.example.holyquranv2v2.adapter.RecyclerViewAdapterAyah;

import java.util.ArrayList;

public class AyahList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapterAyah recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_list);

        recyclerView=findViewById(R.id.ayahList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=getIntent();
        String surahName=intent.getStringExtra("SurahName");
        String trans=intent.getStringExtra("Translation");

        DBHelper dbhelper=new DBHelper(this);

        ArrayList<GenericListItem> AyahList=dbhelper.displayAyah(dbhelper.getSurahNumber(surahName),trans);
//ee


//        ArrayList<String> AANList;
//        AANList=dbhelper.displayAyah(3,index+1);
//
//        ArrayList<String> ATNList;
//        ATNList=dbhelper.displayAyah(4,index+1);

//        ListView ayahList=findViewById(R.id.ayahList);
//
//        CustomArrayAdapterAyah customArrayAdapter=new CustomArrayAdapterAyah(this,SurahList);
//
//        ayahList.setAdapter(customArrayAdapter);
        recyclerViewAdapter=new RecyclerViewAdapterAyah(this,AyahList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}