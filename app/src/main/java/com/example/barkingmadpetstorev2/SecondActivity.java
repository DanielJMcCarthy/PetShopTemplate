package com.example.barkingmadpetstorev2;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.barkingmadpetstorev2.databinding.ActivityMainBinding;


public class SecondActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        
        
        
        
    }
}