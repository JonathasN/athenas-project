package com.athenas.am.athenas.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.athenas.am.athenas.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView imageCard,audioCard,notebookCard;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando os cards
        imageCard = (CardView) findViewById(R.id.image_card);
        audioCard = (CardView) findViewById(R.id.audio_card);
        notebookCard = (CardView) findViewById(R.id.notebook_card);

        //Adicionando o listener nos cards
        imageCard.setOnClickListener(this);
        audioCard.setOnClickListener(this);
        notebookCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            //@TODO - CRIAR CLASSES E AJUSTAR O SWITCH - AJUSTAR O CICLO DE VIDA DA ACTIVITY
            case R.id.image_card: i = new Intent(this, CameraActivity.class);
                    /*
                    String timestamp = new SimpleDateFormat("HH:mm").format(new Date());
                    notebookRef.orderBy("hourInit").whereGreaterThanOrEqualTo("hourInit",timestamp)
                                .whereLessThanOrEqualTo("hourEnd",timestamp)
                                .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            Log.i("Teste", document.getId() + " => " + document.getData());
                                        }
                                    } else {
                                        Log.i("Teste", "Error getting documents: ", task.getException());
                                    }
                                }
                            });
                    */

                    startActivity(i);

                break;
            case R.id.audio_card: i = new Intent(this, AudioActivity.class); startActivity(i); break;
            case R.id.notebook_card: i = new Intent(this, ListNotebooksActivity.class); startActivity(i); break;
            default: break;
        }
    }



}
