package com.example.batch2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class CalculatorActivity extends AppCompatActivity {
    private NotificationCompat.Builder mNotifyBuilder;

    private NotificationManager mNotifyManager;

    private static final int NOTIFICATION_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        createNotificationChannel();



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
        switch (view.getId()){
            case R.id.buttonDialer:
                EditText editText = findViewById(R.id.editTextfirst);
                String first = editText.getText().toString();
                TextView res = findViewById(R.id.textViewSalution);
                res.setText(first);
                break;
            case R.id.buttonCalculator:
                showNotification();
                break;
        }

    }

    private void showNotification() {
        mNotifyBuilder = new NotificationCompat.Builder(this,"mychannelid")
                .setContentTitle("title!")
                .setContentText("content text.")

                .setSmallIcon(R.drawable.ic_menu_camera)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        ;
        Notification myNotification = mNotifyBuilder.build();
        mNotifyManager.notify(NOTIFICATION_ID,  myNotification);

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //o= oreo
            CharSequence name = "mychannel";
            //getString(R.string.channel_name);
            String description = "channel description";
            //getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("mychannelid", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
