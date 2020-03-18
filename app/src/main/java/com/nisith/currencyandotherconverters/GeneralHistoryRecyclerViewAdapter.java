package com.nisith.currencyandotherconverters;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GeneralHistoryRecyclerViewAdapter extends RecyclerView.Adapter<GeneralHistoryRecyclerViewAdapter.MyViewHolder> {

    private Cursor dbCursor;
    private OnDeleteIconClickListener deleteIconClickListener;
    private OnSpeakerIconClickListener speakerIconClickListener;
    private TextView noItemTextView;
    private ImageView toolbarSoundIconImageView;

    public GeneralHistoryRecyclerViewAdapter(OnDeleteIconClickListener deleteIconClickListener, OnSpeakerIconClickListener speakerIconClickListener,
                                             TextView noItemTextView, ImageView toolbarSoundIconImageView, Cursor dbCursor){
        this.deleteIconClickListener = deleteIconClickListener;
        this.speakerIconClickListener = speakerIconClickListener;
        this.noItemTextView = noItemTextView;
        this.toolbarSoundIconImageView = toolbarSoundIconImageView;
        this.dbCursor = dbCursor;
    }

    public interface OnDeleteIconClickListener{
        void onDeleteIconClick(int position,int dataBaseRowId);
    }

    public interface OnSpeakerIconClickListener{
        void onSpeakerIconClick(int position,String audioText);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance_for_currency_history,viewGroup,false);
        return new MyViewHolder(view,deleteIconClickListener,speakerIconClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        if(!dbCursor.moveToPosition(position)){
          return;
        }
        int rowId = dbCursor.getInt(dbCursor.getColumnIndex(AllTables.ConvertHistory.columnId));
        String convertionText = dbCursor.getString(dbCursor.getColumnIndex(AllTables.ConvertHistory.columnConvertionText));
        String currentDate = dbCursor.getString(dbCursor.getColumnIndex(AllTables.ConvertHistory.columnDate));
        String currentTime = dbCursor.getString(dbCursor.getColumnIndex(AllTables.ConvertHistory.columnTime));
        myViewHolder.converTionText.setText(convertionText);
        myViewHolder.date.setText(currentDate);
        myViewHolder.time.setText(currentTime);
        /*Here I set database each record(ROW) row id in deleteImageView and speakerImageView which is not shown By the user but it store on them
          Later we an use that row id for deleting data from database.. */
        myViewHolder.deleteImageView.setTag(rowId);
        myViewHolder.speakerImageView.setTag(convertionText);



    }

    @Override
    public int getItemCount() {
        int totalItems = 0;
        if (dbCursor != null){
            totalItems = dbCursor.getCount();
        }
        if (totalItems == 0){
            //If no item is present then noItemTextView is visible and  toolbarSoundIconImageView is not visible
            noItemTextView.setVisibility(View.VISIBLE);
            toolbarSoundIconImageView.setVisibility(View.GONE);
        }else {
            noItemTextView.setVisibility(View.GONE);
            toolbarSoundIconImageView.setVisibility(View.VISIBLE);
        }
        return totalItems;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView converTionText,date,time;
        ImageView deleteImageView,speakerImageView;
        public MyViewHolder(@NonNull View itemView,final OnDeleteIconClickListener deleteIconClickListener,final OnSpeakerIconClickListener speakerIconClickListener) {
            super(itemView);
            converTionText = itemView.findViewById(R.id.convertion_text_view);
            date = itemView.findViewById(R.id.date_text_view);
            time = itemView.findViewById(R.id.time_text_view);
            deleteImageView = itemView.findViewById(R.id.delete_image_view);
            speakerImageView = itemView.findViewById(R.id.speaker_image_view);
            deleteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //This id is set onBindViewHolder() method
                    int dataBaseRowId = (int)v.getTag();// dataBaseRowId is the database's row id of that row of recycler view
                    deleteIconClickListener.onDeleteIconClick(getAdapterPosition(),dataBaseRowId);
                }
            });

            speakerImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String audioText = (String) v.getTag();
                    speakerIconClickListener.onSpeakerIconClick(getAdapterPosition(),audioText);
                }
            });


        }
    }

    public void setCursor(Cursor newCursor) {
        //This method set a new Cursor in recycler view adapter
        if (dbCursor != null) {
            dbCursor.close();
        }
        dbCursor = newCursor;
    }



}
