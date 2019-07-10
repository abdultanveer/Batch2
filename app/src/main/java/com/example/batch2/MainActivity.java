package com.example.batch2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //AppCompatActivity -- its backwards compatible
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
                startActivityForResult(loginIntent,007);
                //mainactivty = parent, loginactivity = child
                break;
            case R.id.buttonAlarm:
                createAlarm("wakeup",19,48);

                break;
            case R.id.mbutton:
               Intent mIntent = new Intent("abdul.calendar");
               int res = add(10,20);
               startActivity(mIntent);
               /*Intent commonIntent = new Intent(Intent.ACTION_VIEW,
                       Uri.parse("http://www.android.com"));
               startActivity(commonIntent);*/

                break;
            case R.id.buttonContact:
                getContact();
                break;
        }

    }

    private void getContact(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 987);
        }
    }

    private int add(int i, int i1) {
        return i+i1;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent resIntent) {
        super.onActivityResult(requestCode, resultCode, resIntent);
        TextView resTextView = findViewById(R.id.textViewres);
        if(requestCode == 007){
            String first = resIntent.getExtras().getString(LoginActivity.F_KEY);
            String second = resIntent.getExtras().getString(LoginActivity.S_KEY);

            resTextView.setText(first + "\n"+second);
           // Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
        if(requestCode == 987){
            Uri contactUri = resIntent.getData();  //uri is like url which points to the db table
            Cursor cursor = getContentResolver().query(contactUri, null,
                    null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                /*int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);*/
                int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                String name = cursor.getString(nameIndex);
                resTextView.setText(name);

            }

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
