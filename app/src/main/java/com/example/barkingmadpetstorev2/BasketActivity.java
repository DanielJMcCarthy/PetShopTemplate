package com.example.barkingmadpetstorev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.barkingmadpetstorev2.databinding.ActivityBasketBinding;

public class BasketActivity extends AppCompatActivity {

    ActivityBasketBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            // case structure to determine selected nav bar item
            switch (item.getItemId()) {

                case R.id.home:
                    // Explicit intent
                    Intent homeIntent = new Intent(this, HomeActivity.class);
                    startActivity(homeIntent);
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.shop:
                    Intent shopIntent = new Intent(this, ShopActivity.class);
                    startActivity(shopIntent);
                    replaceFragment(new ShopFragment());
                    break;
                case R.id.basket:
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

// Listview attempt
//        ListView lvItems = findViewById(R.id.lv_items);
//        SimpleCursorAdapter simpleCursorAdapter = DataBaseController.populateListViewFromDB();
//        lvItems.setAdapter(simpleCursorAdapter);





    }


        // Method for swapping out fragments
        private void replaceFragment (Fragment fragment){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.bottomNavigationView, fragment);
            fragmentTransaction.commit();
    }
}
