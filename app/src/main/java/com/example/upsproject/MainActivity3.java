package com.example.upsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {
    ProgressBar volt;
    TextView text_1,mon;
    String progr;
    Integer progr1;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        volt = findViewById(R.id.progress_bar);
        text_1 = findViewById(R.id.text_view_progress);
        mon = findViewById(R.id.month);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String dateTime= simpleDateFormat.format(calendar.getTime());
        mon.setText(dateTime);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                progr =  snapshot.child("current value").getValue().toString();
                progr1 = Integer.parseInt(progr);
                volt.setProgress(progr1);
                text_1.setText(progr+"A");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
}