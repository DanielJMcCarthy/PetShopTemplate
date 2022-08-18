package com.example.barkingmadpetstorev2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.barkingmadpetstorev2.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity{
    ActivityHomeBinding binding;
//    final Handler handler = new Handler();
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            // case structure to determine selected nav bar item
            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
//                    Intent homeIntent = new Intent(this, HomeActivity.class);
//                    startActivity(homeIntent);
                    break;
                case R.id.shop:
                    Intent shopIntent = new Intent(this, ShopActivity.class);
                    startActivity(shopIntent);
                    replaceFragment(new ShopFragment());
//                    handler.postDelayed((Runnable) this, 300);
                    break;
                case R.id.basket:
                    Intent basketIntent = new Intent(this, BasketActivity.class);
                    startActivity(basketIntent);
                    replaceFragment(new BasketFragment());
                    break;
                case R.id.checkout:
                    Intent checkoutIntent = new Intent(this, CheckoutActivity.class);
                    startActivity(checkoutIntent);
                    replaceFragment(new CheckoutFragment());
                    break;
            }

            return true;
        });


        btn_logout = findViewById(R.id.btn_logout);

        // Listener for the login button
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Explicit intent
                Intent goToLogin = new Intent(v.getContext(), MainActivity.class);
                startActivity(goToLogin);

            }

        });
        
    }


    // Method for swapping out fragments
    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottomNavigationView,fragment);
        fragmentTransaction.commit();
    }
}