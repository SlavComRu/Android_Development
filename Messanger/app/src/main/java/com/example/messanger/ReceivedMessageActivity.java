package com.example.messanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedMessageActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieved_message);
        Intent intent = getIntent();
        textView = findViewById(R.id.textViewReceivedMsg);
        String smg = intent.getStringExtra("msg");
        textView.setText(smg);


    }
}