package com.example.barkingmadpetstorev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
//import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.barkingmadpetstorev2.databinding.ActivityHomeBinding;
import com.example.barkingmadpetstorev2.databinding.ActivityShopBinding;

public class ShopActivity extends AppCompatActivity {
    ActivityShopBinding binding;
//    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            // case structure to determine selected nav bar item
            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
//                    handler.postDelayed((Runnable) this, 300);
                    // Explicit intent
                    Intent homeIntent = new Intent(this, HomeActivity.class);
                    startActivity(homeIntent);
                    break;
                case R.id.shop:
                    replaceFragment(new ShopFragment());
//                    Intent shopIntent = new Intent(this, ShopActivity.class);
//                    startActivity(shopIntent);
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

    }

    // Method for swapping out fragments
    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottomNavigationView,fragment);
        fragmentTransaction.commit();
    }
}