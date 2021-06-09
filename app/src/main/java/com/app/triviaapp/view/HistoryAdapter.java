package com.app.triviaapp.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.triviaapp.R;
import com.app.triviaapp.db.DatabaseHelper;
import com.app.triviaapp.model.HistoryModel;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.viewHolder> {

    Context context;
    Activity activity;
    ArrayList<HistoryModel> arrayList;
    DatabaseHelper database_helper;

    public HistoryAdapter(Context context, Activity activity, ArrayList<HistoryModel> arrayList) {
        this.context = context;
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @Override
    public HistoryAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.viewHolder holder, final int position) {
        holder.textViewName.setText(arrayList.get(position).getName());
        holder.textViewTime.setText(arrayList.get(position).getDateandtime());
        holder.textViewAnswer1.setText(arrayList.get(position).getAnswer1());
        holder.textViewAnswer2.setText(arrayList.get(position).getAnswer2());

        holder.textViewGame.setText("Game"+String.valueOf(position+1)+" ");


        database_helper = new DatabaseHelper(context);

//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            ;
//
//            @Override
//            public void onClick(View v) {
//                //deleting note
//                database_helper.delete(arrayList.get(position).getID());
//                arrayList.remove(position);
//                notifyDataSetChanged();
//            }
//        });
//
//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            ;
//
//            @Override
//            public void onClick(View v) {
//                //display edit dialog
//                showDialog(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textViewTime, textViewName,textViewAnswer1,textViewAnswer2;
        TextView textViewGame;


        public viewHolder(View itemView) {
            super(itemView);
            textViewTime = (TextView) itemView.findViewById(R.id.history_time_tv);
            textViewName = (TextView) itemView.findViewById(R.id.history_name_tv);
            textViewAnswer1 = (TextView) itemView.findViewById(R.id.history_answer1_tv);
            textViewAnswer2 = (TextView) itemView.findViewById(R.id.history_answer2_tv);
            textViewGame = (TextView) itemView.findViewById(R.id.game_textview);

        }
    }
}