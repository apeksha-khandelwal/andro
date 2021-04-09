package com.example.apekshakhandelwal.admin_jovial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmailPasswordActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText mEmailView;
    private EditText mPasswordView;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;


    public String email="", password="";
    FirebaseUser user;
    Button signin,register;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_password);

        signin=(Button)findViewById(R.id.email_sign_in_button);
        register=(Button)findViewById(R.id.email_register_button);

        signin.setOnClickListener(this);
        register.setOnClickListener(this);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null)
        {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            String uid = user.getUid();
        }
            mEmailView = (EditText) findViewById(R.id.email);
            mPasswordView = (EditText) findViewById(R.id.password);



       mAuth = FirebaseAuth.getInstance();
       mAuthListener = new FirebaseAuth.AuthStateListener() {
           @Override
           public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               FirebaseUser user = firebaseAuth.getCurrentUser();
               if (user != null) {
                   // User is signed in
                   Log.d("here", "onAuthStateChanged:signed_in:" + user.getUid());
               } else {
                   // User is signed out
                   Log.d("here", "onAuthStateChanged:signed_out");
               }
               // ...
           }
       };

   }


    static void here() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAuth.removeAuthStateListener(mAuthListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void signin(View v) {
        email = mEmailView.getText().toString();
        password = mPasswordView.getText().toString();

        if (!validateForm()) {
            return;
        }
        showProgressDialog();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        hideProgressDialog();
                        Log.d("here", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(EmailPasswordActivity.this, "Authentication Failed! /n Wrong Credentials",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            intent = new Intent(EmailPasswordActivity.this, MainActivity.class);
                            startActivity(intent);
                            here();
                        }
                    }
                });
    }
    ProgressDialog mProgressDialog;

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(mEmailView.getText().toString())) {
            mEmailView.setError("Required");
            result = false;
        } else {
            mEmailView.setError(null);
        }
        if (TextUtils.isEmpty(mPasswordView.getText().toString())) {
            mPasswordView.setError("Required");
            result = false;
        } else {
            mPasswordView.setError(null);
        }
        return result;
    }

    public void showProgressDialog() {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }
        mProgressDialog.show();
    }
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    public void register(View v)
    {
        if (!validateForm()) {
            return;
        }
        showProgressDialog();
        email = mEmailView.getText().toString();
        password = mPasswordView.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("here", "createUserWithEmail:onComplete:" + task.isSuccessful());
                        hideProgressDialog();
                        if (!task.isSuccessful()) {
                            Toast.makeText(EmailPasswordActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                        }
                        intent=new Intent(EmailPasswordActivity.this,register.class);
                        intent.putExtra(email,email);
                        intent.putExtra(password,password);
                        startActivity(intent);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v==signin)
            signin(v);
        else if(v==register)
            register(v);
    }
}