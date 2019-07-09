package com.example.batch2;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static String KEY = "mykey";
    public  static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//inflating[parsing] activity_main  -- layoutinflater
        /*Button loginButton = new Button(this);
        loginButton.setText("login");
        loginButton.setWidth(100);*/
        Toast.makeText(this, "created - m/y allocated", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "started -- visible", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStart"+"interacting user");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "paused -- partially visible", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onPause"+"save game state");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "resumed", Toast.LENGTH_SHORT).show();
        Log.w(TAG,"onResume"+"restore game state");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "stopped", Toast.LENGTH_SHORT).show();
        Log.e(TAG,"onStop"+"release resources");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destroyed", Toast.LENGTH_SHORT).show();

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
            case R.id.mbutton:
                Intent mIntent = new Intent("abdul.android.batch2");
                startActivity(mIntent);
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
