package com.example.messanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessengerActivity extends AppCompatActivity {
    private EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMsg = findViewById(R.id.editTextMessenger);
    }

    public void onClickSentMsg(View view) {
        String editText = editTextMsg.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT,editText);
        Intent choseIntent = Intent.createChooser(intent,getString(R.string.chose_title));
        startActivity(choseIntent);
    }

}