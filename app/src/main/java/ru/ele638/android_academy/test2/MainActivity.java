package ru.ele638.android_academy.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText msg_textedit;
    Button preview_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg_textedit = findViewById(R.id.msg_edittext);
        preview_btn = findViewById(R.id.preview_btn);
        preview_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(this, PreviewActivity.class);
        if (!msg_textedit.getText().toString().isEmpty())
            myIntent.putExtra("Text", msg_textedit.getText().toString());
        startActivity(myIntent);
    }
}
