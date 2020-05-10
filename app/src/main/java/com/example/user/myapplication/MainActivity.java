package com.example.user.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Dialog d;
    EditText pasu;
    EditText signuse;
    Button BtnSign;
    Button BtnSubmit;
    TextView  TvSignup;
    EditText  EtUsername;
    EditText  EtPass;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EtUsername = findViewById(R.id.EtUsername);
         EtPass = findViewById(R.id.EtPass);
        TvSignup = findViewById(R.id.TvSignup);
        BtnSubmit = findViewById(R.id.BtnSubmit);
        BtnSign = findViewById(R.id.signo);
        TvSignup.setOnClickListener(this);
        BtnSubmit.setOnClickListener(this);
        sp= getSharedPreferences("details",0);


    }

    public void createDialog() {
        d = new Dialog(this);
        d.setContentView(R.layout.dialog);
        d.setTitle("Login");
        d.setCancelable(true);
        signuse = (EditText) d.findViewById(R.id.signuse);
        pasu = (EditText) d.findViewById(R.id.pasu);
        BtnSign = (Button) d.findViewById(R.id.signo);
        BtnSign.setOnClickListener (this);
        d.show();
    }

    @Override
    public void onClick(View view) {
        if (BtnSubmit == view) {
            String usernameValue = EtUsername.getText().toString();
            String passwordValue =EtPass.getText().toString();
            String registeredUsername = sp.getString("username", "");
            String registeredPassword = sp.getString("password", "");
            if (usernameValue.equals("") && passwordValue.equals("")){
                Toast.makeText(this, "fill the fields", Toast.LENGTH_LONG).show();
            }
            else if (usernameValue.equals(registeredUsername)&&passwordValue.equals(registeredPassword)) {
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                Toast.makeText(this, "Welcome Back", Toast.LENGTH_LONG).show();
            }
            else if(!usernameValue.equals(registeredUsername)||!passwordValue.equals(registeredPassword)){
                Toast.makeText(this, "one or more of the fields is incorrect", Toast.LENGTH_LONG).show();
            }
        }
       else if (TvSignup == view) {
            createDialog();
        }
        if (BtnSign == view) {
            String usernameValue=signuse.getText().toString();
            String passwordValue = pasu.getText().toString();
            if (usernameValue.length()>1&&passwordValue.length()>1) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", usernameValue);
                editor.putString("password", passwordValue);
                editor.commit();
                Intent intent=new Intent(this,Main2Activity.class);
                startActivity(intent);
                Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "Enter Value", Toast.LENGTH_LONG).show();
            }

        }
    }
}























