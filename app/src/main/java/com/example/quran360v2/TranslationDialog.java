package com.example.holyquranv2v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TranslationDialog extends AppCompatActivity {
    Button engTrans;
    Button urduTrans;
    TextView translation;
    TextView arabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_dialog);

        engTrans=findViewById(R.id.engTrans);
        urduTrans=findViewById(R.id.urduTrans);

        translation=findViewById(R.id.translation);
        arabic=findViewById(R.id.arabic);



        Intent intent=getIntent();
        String surahNameA=intent.getStringExtra("SurahNameA");
        String surahNameE=intent.getStringExtra("SurahNameE");

        translation.setText(surahNameE);
        arabic.setText(surahNameA);


        engTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(TranslationDialog.this, AyahList.class);

                intent2.putExtra("SurahName", surahNameA);
                intent2.putExtra("Translation", "eng");
                startActivity(intent);

            }
        });

        urduTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(TranslationDialog.this, AyahList.class);

                intent2.putExtra("SurahName", surahNameA);
                intent2.putExtra("Translation", "urdu");
                startActivity(intent);

            }
        });


    }
}