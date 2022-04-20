package com.example.trainbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private Button button, REGISTER;
    private EditText EditTextName, EditTextEmail, EditTextPassword2, EditTextConfirmPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        EditTextName = (EditText) findViewById(R.id.Name);
        EditTextEmail = (EditText) findViewById(R.id.Email);
        EditTextPassword2 = (EditText) findViewById(R.id.Password2);
        EditTextConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);

        Button btn=findViewById(R.id.create);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EditTextEmail.getText().toString();
                String password = EditTextConfirmPassword.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this,"REGISTRATION SUCCESFUL",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(register.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(register.this, "REGISTRATION FAILED", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                /*Intent intent = new Intent(register.this,MainActivity.class);
                startActivity(intent);*/



            }
        });
    }
}






