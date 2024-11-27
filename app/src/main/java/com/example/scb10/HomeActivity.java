package com.example.scb10;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.scb10.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
  //  private lateinit var binding: ActivityMainBinding

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        String dataReceived = getIntent().getExtras().getString("scb10");
        binding.tvHome.setText(dataReceived);

        //setContentView(R.layout.activity_home);

    }
}