package com.example.batch2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] sports = new String[]{"football","hockey","tennis","cricket"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                //android.R.layout.simple_list_item_1, //layout file
                R.layout.list_row_layout,
                //android.R.id.text1, //id of the textview
                R.id.mytextView,
                sports);//data
        ListView listView = findViewById(R.id.mlistview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mylist_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.deleteMenuitem:
                 Toast.makeText(this, "deleting", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.editMenuitem:
                 Toast.makeText(this, "editing", Toast.LENGTH_SHORT).show();

                 break;
         }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mylist_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
         super.onContextItemSelected(item);
         switch (item.getItemId()){
             case R.id.del:
                 Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                 break;
         }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    public void handleClick(View view) {
        showAlertDialog();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new
                AlertDialog.Builder(this);
        alertDialog.setTitle("title of alert dialog");
        alertDialog.setMessage("alert message");
        alertDialog.show();
    }
}
