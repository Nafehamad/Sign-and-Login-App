package com.nafe.loginpagewithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

   private EditText emailText, passwordText;
   private Button loginButton , signUpButton;
   private TextView textView;
   private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
   private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login Page");

        emailText=findViewById(R.id.email);
        passwordText=findViewById(R.id.password);
        loginButton=findViewById(R.id.login);
        signUpButton=findViewById(R.id.signup);
        textView = (TextView)findViewById(R.id.val);

        sharedPreferences=getSharedPreferences("Userdata",0);

        passwordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailText.getText().toString().length()>1&&passwordText.getText().toString().length()>1 ) {
                    Button btn = (Button) findViewById(R.id.login);
                    btn.setEnabled(true);

                }
            }
        });

        passwordText.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (passwordText.getText().toString().trim().length() < 6)
                        passwordText.setError("Failed");
                    else
                        passwordText.setError(null);
                }
                else {
                    if (passwordText.getText().toString().trim().length() < 2) {
                        passwordText.setError("Failed");
                    } else {

                        passwordText.setError(null);
                    }
                }
            }


        });

        emailText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if ( emailText.getText().toString().trim().matches(emailPattern))  {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();

                    textView.setText("valid email");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();

                    textView.setText("invalid email");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if ( emailText.getText().toString().trim().matches(emailPattern))  {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();

                    textView.setText("valid email");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();

                    textView.setText("invalid email");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( emailText.getText().toString().trim().matches(emailPattern))  {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();

                    textView.setText("valid email");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();

                    textView.setText("invalid email");
                }

            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailValue=emailText.getText().toString();
                String passValue=passwordText.getText().toString();

                String userEmail=sharedPreferences.getString("email","");
                System.out.println(userEmail);
                String userPass=sharedPreferences.getString("password","");
                System.out.println(userPass);
                String userFirstName=sharedPreferences.getString("username","");
                String userLastName=sharedPreferences.getString("lastname","");




                 String FullName=userFirstName.concat(userLastName);

                if(emailValue.equals(userEmail)&& passValue.equals(userPass)) {
                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    intent.putExtra("FullName", FullName);
                    startActivity(intent);
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });



    }
}
