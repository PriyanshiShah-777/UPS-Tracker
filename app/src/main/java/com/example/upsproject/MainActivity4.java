package com.example.upsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity4 extends AppCompatActivity {
    public TextView temp,mon,tim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        temp = (TextView) findViewById(R.id.temperature);
        mon = findViewById(R.id.month);
        tim = findViewById(R.id.time);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String dateTime= simpleDateFormat.format(calendar.getTime());
        mon.setText(dateTime);
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss a");
        String dateTime1= simpleDateFormat1.format(calendar1.getTime());
        tim.setText(dateTime1);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String temperature = snapshot.child("temperature").getValue().toString();
                temp.setText(temperature);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}