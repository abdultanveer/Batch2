package com.example.batch2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText firstEditText , secondEditText;
    public static String F_KEY = "first";
    public static String S_KEY = "second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firstEditText = findViewById(R.id.editTextfirst);
        secondEditText = findViewById(R.id.editTextsecond);
       /* String name = getIntent().getExtras().getString(MainActivity.KEY);

        TextView salTextView = findViewById(R.id.textViewSalution);//taking handle
        salTextView.setText(name);*/
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case R.id.buttonDialer:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:1234567890"));//implicit intent
                startActivity(dialIntent);
                break;
            case R.id.buttonCalculator:
                //result = first + second string
                String first = firstEditText.getText().toString();
                String second = secondEditText.getText().toString();
                //, put resultIntent in an intent
                Intent resultIntent = new Intent();
                resultIntent.putExtra(F_KEY,first);
                resultIntent.putExtra(S_KEY,second);
                //to send result to parent activity
                setResult(RESULT_OK,resultIntent);
                finish(); //this will kill the login activity

                break;
        }
    }
}
