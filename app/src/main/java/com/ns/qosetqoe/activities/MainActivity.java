package com.ns.qosetqoe.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ns.qosetqoe.R;
import com.ns.qosetqoe.models.ItemClass;

import java.util.ArrayList;
import java.util.List;

import static com.ns.qosetqoe.utils.UtilsClass.isValidEmail;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSION_LOCATION = 52486;
    private static final String TAG = "MainActivity";
    private List<ItemClass> itemsList = new ArrayList<>();

    private FrameLayout loader;
    private TextInputEditText editTextEmail ;
    private TextInputEditText editTextPswd;
    private MaterialButton loginBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        loader= findViewById(R.id.main_loader);
        editTextEmail= findViewById(R.id.main_email);
        editTextPswd= findViewById(R.id.main_password);
        loginBtn= findViewById(R.id.main_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        checkGpsPermission();

    }

    private void loginUser() {
        String email = editTextEmail.getText().toString();
        String password = editTextPswd.getText().toString();

        if(!isValidEmail(email)) {
            editTextEmail.setError("Invalid Email Address !");
            return;
        } else {
            editTextEmail.setError("");
        }

        if(password.length() < 6) {
            editTextPswd.setError("Password should be more then 6 characters !");
            return;
        } else {
            editTextPswd.setError("");
        }

        loader.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        loader.setVisibility(View.GONE);
        if(user != null) {
            if (user.getEmail().contains("orange.tn")) {
                startActivity(new Intent(this, SubscActivity.class));
            } else {
                startActivity(new Intent(this, TechActivity.class));
            }
        }
    }

    private void checkGpsPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSION_LOCATION);
        } else {
            permissionGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        if (requestCode == MY_PERMISSION_LOCATION
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            permissionGranted();
        } else {
            Toast.makeText(this, "Please activate your GPS ", Toast.LENGTH_LONG)
            .show();

            finishAffinity();
        }
    }

    private void permissionGranted() {
        loader.setVisibility(View.GONE);
    }

}
