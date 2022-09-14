package com.example.quran360v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.quran360v2.R;

import java.util.ArrayList;

public class AyahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_list);

        Intent intent=getIntent();
        String surahName=intent.getStringExtra("SurahName");
        DBHelper dbhelper=new DBHelper(this);

        ArrayList<GenericListItem> SurahList=dbhelper.displayAyah(dbhelper.getSurahNumber(surahName));
//ee


//        ArrayList<String> AANList;
//        AANList=dbhelper.displayAyah(3,index+1);
//
//        ArrayList<String> ATNList;
//        ATNList=dbhelper.displayAyah(4,index+1);

        ListView ayahList=findViewById(R.id.ayahList);

        CustomArrayAdapterAyah customArrayAdapter=new CustomArrayAdapterAyah(this,SurahList);

        ayahList.setAdapter(customArrayAdapter);
    }
}