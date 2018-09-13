package ru.ele638.android_academy.test2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {

    String text;
    TextView text_tv;
    Button email_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        text_tv = findViewById(R.id.preview_textview);
        email_btn = findViewById(R.id.email_btn);
        text = "";

        if (savedInstanceState != null){
            text = savedInstanceState.getString("Text");
        } else {
            text = getIntent().getStringExtra("Text");
        }

        text_tv.setText(text);
        email_btn.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Text", text);
    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(Intent.ACTION_SENDTO);
        myIntent.setData(Uri.parse("mailto:ele638@gmail.com"));
        myIntent.putExtra(Intent.EXTRA_SUBJECT, "ANDROID_ACADEMY");
        myIntent.putExtra(Intent.EXTRA_TEXT, text);
        if (myIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(myIntent);
        } else {
            Toast.makeText(this, "NO APP", Toast.LENGTH_SHORT).show();
        }
    }
}
