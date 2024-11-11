package com.example.pojectku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.auth.FirebaseAuth;


import java.util.Objects;


public class LupaPassword extends AppCompatActivity {

    private EditText edtemail;
    private Button btnKirim;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        // Inisialisasi komponen
        edtemail = findViewById(R.id.edt_email);
        btnKirim = findViewById(R.id.btn_kirim);
        mAuth = FirebaseAuth.getInstance();

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString().trim();
                if (email.isEmpty()) {
                    edtemail.setError("Email harus ada");
                    edtemail.requestFocus();
                } else {
                    resetPassword(email);
                }
            }
        });

    }

    private void resetPassword(String email) {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(LupaPassword.this, "Email untuk reset password sudah dikirim", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LupaPassword.this, "Gagal mengirim reset email" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}