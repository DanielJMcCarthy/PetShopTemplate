package com.example.barkingmadpetstorev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.barkingmadpetstorev2.databinding.ActivityCheckoutBinding;

import java.util.Random;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    Button btn_pay;
    TextView tv_order_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
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
                    Intent basketIntent = new Intent(this, BasketActivity.class);
                    startActivity(basketIntent);
                    replaceFragment(new BasketFragment());
                    break;
                case R.id.checkout:
                    replaceFragment(new CheckoutFragment());
                    break;
            }

            return true;
        });



        btn_pay = findViewById(R.id.btn_pay);
        tv_order_number = findViewById(R.id.tv_order_number);
        Random rand = new Random();


        // Listener for the pay button
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv_order_number = (TextView)findViewById(R.id.tv_order_number);

                // There's for sure a better way to do this
                int basenum = 1000000;
                int randnum_modifier =  rand.nextInt(8999999);
                int order_num_int = basenum + randnum_modifier;
                String order_num_text = String.valueOf(order_num_int);

                tv_order_number.setText("Order Number: " + order_num_text);

            }

        });

    }




    // Method for swapping out fragments
    private void replaceFragment (Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottomNavigationView, fragment);
        fragmentTransaction.commit();
    }
}