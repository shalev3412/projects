package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button BTNlogout = findViewById(R.id.BTNlogout);

        BTNlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "goodby ", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(j);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myintent;
        int id = item.getItemId();
        if (id == R.id.a1) {
            Intent i = new Intent(getApplicationContext(), Main4Activity.class);
            startActivity(i);
            return false;
        }
        if (id == R.id.a2) {
            Toast.makeText(getBaseContext(), "you choosed chat", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.a3) {
            Toast.makeText(getBaseContext(), "you choosed trade", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
