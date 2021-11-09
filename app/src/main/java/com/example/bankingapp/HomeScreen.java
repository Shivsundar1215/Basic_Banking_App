package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
public class HomeScreen extends AppCompatActivity {
    Animation anim;
    ImageView banklogo;
    TextView banktitle;
    Button btnAllCustomers,btnAllTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        anim = AnimationUtils.loadAnimation(this,R.anim.animation);
        banklogo = findViewById(R.id.logo12);
        btnAllCustomers = findViewById(R.id.all_customers);
        btnAllTransaction = findViewById(R.id.all_transactions);
        banktitle = findViewById(R.id.bank_title);

        banklogo.setAnimation(anim);
        banklogo.setAnimation(anim);
        btnAllCustomers.setAnimation(anim);
        btnAllTransaction.setAnimation(anim);

    }
    public void showAllCustomers(View view){
        Intent intent = new Intent(this,CustomersList.class);
        startActivity(intent);

    }
    public void showAllTransactions(View view){
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}