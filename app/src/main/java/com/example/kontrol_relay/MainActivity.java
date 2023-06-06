package com.example.kontrol_relay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button onDinamo = (Button)  findViewById(R.id.onDinamo);
        final Button offDinamo = (Button)  findViewById(R.id.offDinamo);

        final Button onDinamo2 = (Button)  findViewById(R.id.onDinamo2);
        final Button offDinamo2 = (Button)  findViewById(R.id.offDinamo2);

        final TextView status1 = (TextView) findViewById(R.id.status1);
        final TextView status2 = (TextView) findViewById(R.id.status2);
        final TextView status3 = (TextView) findViewById(R.id.status3);

        DatabaseReference databaseReference = null;

        final Button onDinamo3 = (Button)  findViewById(R.id.onDinamo3);
        final Button offDinamo3 = (Button)  findViewById(R.id.offDinamo3);
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        DatabaseReference refDinamo = database.getReference("STATUS_DINAMO");
        DatabaseReference refDinamo2 = database.getReference("STATUS_DINAMO2");
        DatabaseReference refDinamo3 = database.getReference("STATUS_DINAMO3");

        refDinamo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);

                    status1.setText(message.toString());

                    if(message==0){
                        offDinamo.setVisibility(View.GONE);
                        status1.setText("mati");
                        onDinamo.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        onDinamo.setVisibility(View.GONE);
                        status1.setText("nyala");
                        offDinamo.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refDinamo2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);

                    if(message==0){
                        offDinamo2.setVisibility(View.GONE);
                        status2.setText("mati");
                        onDinamo2.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        onDinamo2.setVisibility(View.GONE);
                        status2.setText("nyala");
                        offDinamo2.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refDinamo3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);

                    status3.setText(message.toString());

                    if(message==0){
                        offDinamo3.setVisibility(View.GONE);
                        status3.setText("mati");
                        onDinamo3.setVisibility(View.VISIBLE);
                    }else if(message==1){
                        onDinamo3.setVisibility(View.GONE);
                        status3.setText("nyala");
                        offDinamo3.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        onDinamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DINAMO");

                myref.setValue(1);
            }
        });

        offDinamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DINAMO");

                myref.setValue(0);
            }
        });

        onDinamo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DINAMO2");

                myref.setValue(1);
            }
        });

        offDinamo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DINAMO2");

                myref.setValue(0);
            }
        });

        onDinamo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DINAMO3");

                myref.setValue(1);
            }
        });

        offDinamo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DINAMO3");

                myref.setValue(0);
            }
        });

    }
}