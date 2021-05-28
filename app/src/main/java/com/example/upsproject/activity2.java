package com.example.upsproject;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity2 extends AppCompatActivity {
    EditText Voltage, Current, Temperature, Output;
    TextView text1, text2, text3, text4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Voltage = findViewById(R.id.edit_1);
        Current = findViewById(R.id.edit_2);
        Temperature = findViewById(R.id.edit_3);
        Output = findViewById(R.id.edit_4);

        text1 = findViewById(R.id.txt_1);
        text2 = findViewById(R.id.txt_2);
        text3 = findViewById(R.id.txt_3);
        text4 = findViewById(R.id.txt_4);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String voltage = snapshot.child("voltage value").getValue().toString();
                String current = snapshot.child("current value").getValue().toString();
                String temperature = snapshot.child("temperature").getValue().toString();
                String output = snapshot.child("humidity").getValue().toString();

                Voltage.setText(voltage);
                Current.setText(current);
                Temperature.setText(temperature);
                Output.setText(output);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}

