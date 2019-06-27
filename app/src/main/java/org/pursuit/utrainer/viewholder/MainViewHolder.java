package org.pursuit.utrainer.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.utrainer.R;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView main_TextView;
    private ImageView mainImageView;


    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        setViews(itemView);
    }

    public void onBind(){



    }


    private void setViews(View v){
        main_TextView = v.findViewById(R.id.main_recylcerview_textview);
        mainImageView = v.findViewById(R.id.main_recylcerview_icon);

    }

}
