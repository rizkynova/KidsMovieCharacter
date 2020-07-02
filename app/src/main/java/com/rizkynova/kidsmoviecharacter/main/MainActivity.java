package com.rizkynova.kidsmoviecharacter.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rizkynova.kidsmoviecharacter.R;
import com.rizkynova.kidsmoviecharacter.etc.Model;
import com.rizkynova.kidsmoviecharacter.etc.ViewHolder;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mfirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        //set LinearLayour
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ngirim query ke firebasedatabasenya
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mfirebaseDatabase.getReference("character");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ){
                @Override
                    protected void populateViewHolder(ViewHolder viewHolder,Model model, int position){

                    viewHolder.setDetails(getApplicationContext(),model.getName(),model.getFilm(),model.getImage());

                }};
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
