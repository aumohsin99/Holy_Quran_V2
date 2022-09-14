package com.example.holyquranv2v2.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holyquranv2v2.AyahList;
import com.example.holyquranv2v2.GenericListItem;
import com.example.holyquranv2v2.R;
import com.example.holyquranv2v2.SurahList;
import com.example.holyquranv2v2.TranslationDialog;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<GenericListItem> genericListItems;

    public RecyclerViewAdapter(Context context, ArrayList<GenericListItem> genericListItems) {
        this.context = context;
        this.genericListItems = genericListItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_custom_surah_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        GenericListItem genericListItem=genericListItems.get(position);
        holder.suraha.setText(genericListItem.getSecendEntity());
        holder.surahe.setText(genericListItem.getFirstEntity());
    }

    @Override
    public int getItemCount() {
        return genericListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView suraha;
        TextView surahe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            suraha=itemView.findViewById(R.id.surahA);
            surahe=itemView.findViewById(R.id.surahE);
        }

        @Override
        public void onClick(View view) {
           // Log.i("Clicked on list:",String.valueOf(position));
            Intent intent=new Intent(context, TranslationDialog.class);
            TextView textA=(TextView)view.findViewById(R.id.surahA);
            TextView textE=(TextView)view.findViewById(R.id.surahE);

            String surahNameA = textA.getText().toString();
            String surahNameE = textE.getText().toString();
            //String selectedFromList = (String) (surahList.getItemAtPosition(i));
            //Log.i("Itemmm String::>:",surahName);

            intent.putExtra("SurahNameA", surahNameA);
            intent.putExtra("SurahNameE", surahNameE);
            context.startActivity(intent);

        }
    }
}
