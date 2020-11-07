package com.theknights.drugprev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class StressedActivity extends AppCompatActivity {

    private Button quote_btn, call_btn, txt_btn;
    private TextView quote_text;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stressed);
        Toolbar toolbar = findViewById(R.id.help_toolbar);
        setSupportActionBar(toolbar);

        setTitle("Help");


        quote_btn = findViewById(R.id.quote_button);
        call_btn = findViewById(R.id.call_button);
        txt_btn = findViewById(R.id.text_button);

        quote_text = findViewById(R.id.quote);

        quote_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int randomNum = (int)(Math.random() * 12);

                    CollectionReference InventoryRef = db.collection("quotes");
                    InventoryRef.get()
                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                        Note note = documentSnapshot.toObject(Note.class);
                                        note.setDocumentId(documentSnapshot.getId());
                                        String documentId = note.getDocumentId();
                                        String Firebase_message = note.getMessage();

                                        if(documentId.equals(String.valueOf(randomNum)))
                                        {
                                            quote_text.setText(Firebase_message);
                                        }
                                    }

                                }
                            });
                }
        });

        txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StressedActivity.this, MessageActivity.class));
            }
        });

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0701448559"));
                startActivity(callIntent);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.Exit:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(StressedActivity.this, LoginActivity.class));
                finish();
                return true;


            case R.id.Settings:
                Toast.makeText(StressedActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}