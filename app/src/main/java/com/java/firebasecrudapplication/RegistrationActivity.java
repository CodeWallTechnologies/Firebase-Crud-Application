package com.java.firebasecrudapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText userNameEdt,pwdEdt,cnfPwdEdt;
    private Button registerBtn;
    private ProgressBar loadingPB;
    private TextView loginTV;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        userNameEdt = findViewById(R.id.idEdtUserName);
        pwdEdt = findViewById(R.id.idEdtPwd);
        cnfPwdEdt = findViewById(R.id.idEdtCnfPwd);
        registerBtn = findViewById(R.id.idBtnRegister);
        loadingPB = findViewById(R.id.idPBLoading);
        mAuth = FirebaseAuth.getInstance();
        loginTV = findViewById(R.id.idTVLogin);

        loginTV.setOnClickListener(v->{
            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
        });


        registerBtn.setOnClickListener(v->{
            loadingPB.setVisibility(View.VISIBLE);
            String userName = userNameEdt.getText().toString();
            String pwd = pwdEdt.getText().toString();
            String cnfPwd = cnfPwdEdt.getText().toString();
            if(!pwd.equals(cnfPwd)){
                Toast.makeText(this, "Please Check Both password", Toast.LENGTH_SHORT).show();
            }else if(userName.isEmpty() && pwd.isEmpty() && TextUtils.isEmpty(cnfPwd)){
                Toast.makeText(this, "Please Add your credentials...", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.createUserWithEmailAndPassword(userName,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            loadingPB.setVisibility(View.GONE);
                            Toast.makeText(RegistrationActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                            finish();
                        }else{
                            loadingPB.setVisibility(View.GONE);
                            Toast.makeText(RegistrationActivity.this, "Fail to user Register ...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}