package com.threefourfive.joel.currencyconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public boolean t = true;
    public void fader(View view){
        ImageView img = (ImageView)findViewById(R.id.imageView);
        ImageView rup = (ImageView)findViewById(R.id.rupee);
        if(t) {
            img.animate().alpha(0f).setDuration(1000);
            rup.animate().alpha(1f).setDuration(1000);
            t=!t;
        }
        else if(!t) {
            img.animate().alpha(1f).setDuration(1000);
            rup.animate().alpha(0f).setDuration(1000);
            t=!t;
        }
    }

    public void convert(View view){

        EditText txt = (EditText) findViewById(R.id.editText);
        String s= txt.getText().toString();
        if (s.matches("")) {
            Toast.makeText(this, "You did not enter anything!!", Toast.LENGTH_SHORT).show();
            return;
        }
        double res = Double.parseDouble(txt.getText().toString());
        res *= 66.10;
        String newres = Double.toString(res);
        Toast toast = Toast.makeText(getApplicationContext(),"INR "+newres , Toast.LENGTH_SHORT);
        toast.show();

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Email me at jbandi@uci.edu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
