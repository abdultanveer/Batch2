package com.example.batch2;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public  static String KEY = "mykey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//inflating[parsing] activity_main  -- layoutinflater
        /*Button loginButton = new Button(this);
        loginButton.setText("login");
        loginButton.setWidth(100);*/

    }

    public void handleClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                Intent loginIntent =
                        new Intent(this,LoginActivity.class); //explicit intent
                loginIntent.putExtra(KEY,"abdul");
                startActivity(loginIntent);
                break;
            case R.id.buttonAlarm:
                createAlarm("wakeup",19,48);

                break;
        }

    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
