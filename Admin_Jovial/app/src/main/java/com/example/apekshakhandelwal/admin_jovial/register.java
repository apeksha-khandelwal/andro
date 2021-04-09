package com.example.apekshakhandelwal.admin_jovial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity implements View.OnClickListener{

    private EditText name,phone,add,adhar;
    private FirebaseAuth mAuth;
    Button register;
    Intent intent;
    DatabaseReference mDatabase;

    public String email="", password="",fname="",address="",adharn="",no="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Bundle extras = getIntent().getExtras();

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone_no);
        add = (EditText) findViewById(R.id.add);
        adhar = (EditText) findViewById(R.id.adhar);

        email=extras.getString(email);
        password=extras.getString(password);

        register=(Button)findViewById(R.id.email_register_button);
        register.setOnClickListener(this);
    }

    public void SignUp(View v) {
        if(mAuth.getCurrentUser()!=null)
        {
            fname=name.getText().toString();
            address=add.getText().toString();
            adharn=adhar.getText().toString();
            no=phone.getText().toString();

            User user=new User(email,password,fname,address,no,adharn);

            // save the user at UserNode under user UID
            mDatabase.child("UserNode").child(mAuth.getCurrentUser().getUid()).setValue(user, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if(databaseError==null)
                    {
                        Toast.makeText(register.this, "Data is saved successfully",
                                Toast.LENGTH_SHORT).show();
                        intent=new Intent(register.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        if(v==register)
            SignUp(v);
    }
}
