package com.example.apekshakhandelwal.client;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apekshakhandelwal.client.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity implements View.OnClickListener{

    private EditText mEmailView;
    private EditText mPasswordView;
    private FirebaseAuth mAuth;
    Button register;
    Intent intent;

    public String email="", password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        register=(Button)findViewById(R.id.email_register_button);
        register.setOnClickListener(this);

    }
    public void SignUp(View v)
    {
        email = mEmailView.getText().toString();
        password = mPasswordView.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("here", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Toast.makeText(register.this,"Register Successful!",Toast.LENGTH_SHORT).show();
                        }
                        intent=new Intent(register.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v==register)
            SignUp(v);
    }
}
