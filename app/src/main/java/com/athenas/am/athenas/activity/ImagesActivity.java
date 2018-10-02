package com.athenas.am.athenas.activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.athenas.am.athenas.R;
import com.athenas.am.athenas.classes.ImageAdapter;
import com.athenas.am.athenas.classes.Upload;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    private ProgressBar mProgressCircle;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;    //change the url according to your firebase app
    private String notebookId;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        //@todo - falta recuperar lista de imagens do storage
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            notebookId = extras.getString("NotebookId");
            //Log.d("NotebookID", notebookId);
            //The key argument here must match that used in the other activity
        }

        FloatingActionButton buttonAddNote = findViewById(R.id.btn_camera);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImagesActivity.this, CameraActivity.class);
                intent.putExtra("NotebookId", notebookId);
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProgressCircle = findViewById(R.id.progress_circle);

        mUploads = new ArrayList<>();

        if(notebookId == null){
            storageRef = storage.getReferenceFromUrl("gs://app-samsung.appspot.com/PodeSerUtil");

            //mDatabaseRef = FirebaseDatabase.getInstance().getReference("gs://app-samsung.appspot.com/PodeSerUtil");

            //StorageReference gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg");
//                    CollectionReference notebookRef = FirebaseFirestore.getInstance().collection("Notebook").document("Pode Ser Util")
//                            .collection("Imagem");
//                    Imagem imagemDoc = new Imagem(PathPhoto,  file, notebookId);
//                    notebookRef.set(imagemDoc);
        }else{
            storageRef = storage.getReferenceFromUrl("gs://app-samsung.appspot.com/"+notebookId);

            //mDatabaseRef = FirebaseDatabase.getInstance().getReference("gs://app-samsung.appspot.com/"+notebookId);

            //CollectionReference notebookRef = FirebaseFirestore.getInstance().collection("Notebook").document(notebookId).collection("Imagem");
            //Imagem imagemDoc = new Imagem(PathPhoto,  file, notebookId);
            //notebookRef.set(imagemDoc);
        }



        //mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

//        mDatabaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    Upload upload = postSnapshot.getValue(Upload.class);
//                    mUploads.add(upload);
//                }
//
//                mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
//
//                mRecyclerView.setAdapter(mAdapter);
//                mProgressCircle.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//                mProgressCircle.setVisibility(View.INVISIBLE);
//            }
//        });
    }
}