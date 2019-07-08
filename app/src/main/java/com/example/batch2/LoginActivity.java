package com.example.batch2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String name = getIntent().getExtras().getString(MainActivity.KEY);

        TextView salTextView = findViewById(R.id.textViewSalution);
        salTextView.setText(name);
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case R.id.buttonDialer:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));//implicit intent
                startActivity(dialIntent);
                break;
            case R.id.buttonCalculator:
                break;
        }
    }
}
