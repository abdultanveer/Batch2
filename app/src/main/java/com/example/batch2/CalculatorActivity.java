package com.example.batch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        /*LinkedList<String> words = new LinkedList<>();
        words.add("word1");
        words.add("word12");
        words.add("word13");
        words.add("word14");
        words.add("word15");
        words.add("word16");

       RecyclerView mRecyclerView = (RecyclerView)
                findViewById(R.id.recyclerview);
       WordListAdapter mAdapter = new WordListAdapter(this, words);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new
                LinearLayoutManager(this));

*/
    }

    public void clickHandler(View view) {
        EditText editText = findViewById(R.id.editTextfirst);
        String first = editText.getText().toString();
        TextView res = findViewById(R.id.textViewSalution);
        res.setText(first);
    }
}
