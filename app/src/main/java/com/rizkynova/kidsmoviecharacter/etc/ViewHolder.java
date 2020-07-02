package com.rizkynova.kidsmoviecharacter.etc;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rizkynova.kidsmoviecharacter.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView){
        super(itemView);

        mView = itemView;

    }

    public void setDetails(Context ctx,String name, String film, String image){
        TextView mNameTv = mView.findViewById(R.id.rNameTv);
        TextView mFilmTv = mView.findViewById(R.id.rFilm);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);

        //set data buat di view
        mNameTv.setText(name);
        mFilmTv.setText(film);
        Picasso.get().load(image).into(mImageIv);


    }
}
