package com.example.personaltrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    Button login;
    Button dBtnSignUp;
    TextView signUp;
    Dialog d;
    EditText email, password;
    EditText dEtEmail;
    EditText dEtPassword;
    EditText dEtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("userinfo",0);
        signUp=(Button)findViewById(R.id.signUp);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
        dEtEmail=(EditText)findViewById(R.id.dEtEmail);
        dEtPassword=(EditText)findViewById(R.id.dEtPassword);
        dEtAge=(EditText)findViewById(R.id.dEtAge);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);


    }
    public void createDialog(){
        d=new Dialog(this);
        d.setContentView(R.layout.signup_dialog);
        d.setTitle("Login");
        d.setCancelable(true);
        dEtEmail=(EditText)d.findViewById(R.id.dEtEmail);
        dEtPassword=(EditText)d.findViewById(R.id.dEtPassword);
        dEtAge=(EditText)d.findViewById(R.id.dEtAge);
        dBtnSignUp=(Button)d.findViewById(R.id.dBtnSignUp);
        dBtnSignUp.setOnClickListener(this);
        d.show();
    }

    @Override
    public void onClick(View v) {
        if(login==v) {
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();
            String registeredEmail = sp.getString("email", "");
            String registeredPassword = sp.getString("password", "");
            if (emailValue.equals("") || passwordValue.equals("")){
                Toast.makeText(this, "fill the fields", Toast.LENGTH_LONG).show();
            }
            else if (emailValue.equals(registeredEmail)&&passwordValue.equals(registeredPassword)) {
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                Toast.makeText(this, "Welcome Back", Toast.LENGTH_LONG).show();
            }
            else if(!emailValue.equals(registeredEmail)||!passwordValue.equals(registeredPassword)){
                Toast.makeText(this, "one or more of the fields is incorrect", Toast.LENGTH_LONG).show();
            }
        }
        else if (signUp==v) {
            createDialog();
        }
        if (dBtnSignUp==v){
            String emailValue=dEtEmail.getText().toString();
            String passwordValue = dEtPassword.getText().toString();
            String ageValue=dEtAge.getText().toString();

            if (emailValue.length()>1&&passwordValue.length()>1&&ageValue.length()>1) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", emailValue);
                editor.putString("password", passwordValue);
                editor.putString("age", ageValue);
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
