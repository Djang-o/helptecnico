package com.example.tecnichelp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("mensagem");
        LinearLayout layout = findViewById(R.id.layout2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue(String.class);
                adicionar(data);
                // Cria um novo TextView



                // Adiciona o TextView ao layout da sua Activity

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
            public void adicionar(String datas){
                TextView textView = new TextView(getApplicationContext());
                String textoAtual = textView.getText().toString();
                textView.setText(textoAtual + "\n" + datas);
                textView.setTextSize(20);

                LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
                layout.addView(textView);
            }
        });

    }
}










