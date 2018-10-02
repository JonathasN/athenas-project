package com.athenas.am.athenas.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenas.am.athenas.R;
import com.athenas.am.athenas.classes.Response;
import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResponseActivity extends AppCompatActivity {
    @BindView(R.id.progress_circle)
    ProgressBar progressBar;

    @BindView(R.id.recycler_view)
    RecyclerView friendList;

    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapter;
    private String notebookId;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        ButterKnife.bind(this);
        init();
        getFriendList();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            notebookId = extras.getString("NotebookId");
            //Log.d("NotebookID", notebookId);
            //The key argument here must match that used in the other activity
        }
    }

    private void init(){
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        friendList.setLayoutManager(linearLayoutManager);
        db = FirebaseFirestore.getInstance();
    }

    private void getFriendList(){
        Query query = db.collection("Notebook").document(notebookId).collection("Imagem");

        FirestoreRecyclerOptions<Response> response = new FirestoreRecyclerOptions.Builder<Response>()
                .setQuery(query, Response.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<Response, FriendsHolder>(response) {
            @Override
            public void onBindViewHolder(FriendsHolder holder, int position, Response model) {
                progressBar.setVisibility(View.GONE);
                holder.textName.setText(model.getName());
                //holder.textTitle.setText(model.getTitle());
                //holder.textCompany.setText(model.getCompany());
                Glide.with(getApplicationContext())
                        .load(model.getImage())
                        .into(holder.imageView);


            }

            @Override
            public FriendsHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.image_item, group, false);

                return new FriendsHolder(view);
            }

            @Override
            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };

        adapter.notifyDataSetChanged();
        friendList.setAdapter(adapter);
    }

    public class FriendsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_name)
        TextView textName;
        @BindView(R.id.image_view_upload)
        ImageView imageView;
        //@BindView(R.id.title)
        //TextView textTitle;
        //@BindView(R.id.company)
        //TextView textCompany;

        public FriendsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
