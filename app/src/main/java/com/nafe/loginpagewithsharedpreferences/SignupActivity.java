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

public class SignupActivity extends AppCompatActivity {

   private EditText firstname,lastname,emailSigned,passwordSigned;
   private Button login,signUp;
   private   TextView textView;
   private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
   private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setTitle("Sign Up Page");
        firstname=findViewById(R.id.first);
        lastname=findViewById(R.id.last);
        emailSigned=findViewById(R.id.emailSign);
        passwordSigned=findViewById(R.id.passwordSign);
        login=findViewById(R.id.log);
        signUp=findViewById(R.id.sign);
        textView = (TextView)findViewById(R.id.val);
        sharedPreferences=getSharedPreferences("Userdata",0);


        passwordSigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailSigned.getText().toString().length()>1&&passwordSigned.getText().toString().length()>1
               && firstname.getText().toString().length()>1&& lastname.getText().toString().length()>1) {
                    Button btn = (Button) findViewById(R.id.sign);
                    btn.setEnabled(true);

                }
            }
        });


       firstname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (firstname.getText().toString().trim().length() < 2)
                        firstname.setError("Failed");
                    else
                        firstname.setError(null);
                }
                else {
                    if (firstname.getText().toString().trim().length() < 2) {
                        firstname.setError("Failed");
                    } else {

                        firstname.setError(null);
                    }
                }
            }
        });


       lastname.setOnFocusChangeListener(new View.OnFocusChangeListener(){

           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if (hasFocus) {
                   if (lastname.getText().toString().trim().length() < 2)
                       lastname.setError("Failed");
                   else
                       lastname.setError(null);
               }
               else {
                   if (lastname.getText().toString().trim().length() < 2) {
                       lastname.setError("Failed");
                   } else {

                       lastname.setError(null);
                   }
               }
           }


       });

        passwordSigned.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (passwordSigned.getText().toString().trim().length() <6)
                        passwordSigned.setError("Failed");
                    else
                        passwordSigned.setError(null);
                }
                else {
                    if (passwordSigned.getText().toString().trim().length() < 6) {
                        passwordSigned.setError("Failed");
                    } else {

                        passwordSigned.setError(null);
                    }
                }
            }


        });


       emailSigned.addTextChangedListener(new TextWatcher() {

           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               if ( emailSigned.getText().toString().trim().matches(emailPattern))  {
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

               if ( emailSigned.getText().toString().trim().matches(emailPattern))  {
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
               if ( emailSigned.getText().toString().trim().matches(emailPattern))  {
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





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNameValue = firstname.getText().toString();
                String lastNameValue = lastname.getText().toString();
                String emailValue = emailSigned.getText().toString();
                String passValue = passwordSigned.getText().toString();


                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("firstname", firstNameValue);
                    editor.putString("lastname", lastNameValue);
                    editor.putString("email", emailValue);
                    editor.putString("password", passValue);
                    editor.apply();
                    Toast.makeText(SignupActivity.this, "User Signed Up", Toast.LENGTH_SHORT).show();


            }

        });



    }
}
