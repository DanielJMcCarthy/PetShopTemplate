package com.example.barkingmadpetstorev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_email, et_password, et_name;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);

        btn_login = findViewById(R.id.btn_login);


        // Listener for the login button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // split declaration and assignment
                UserModel userModel;
                try {
                    userModel = new UserModel(et_email.getText().toString(), et_password.getText().toString(), et_name.getText().toString());
                    Toast.makeText(MainActivity.this, "Welcome " + userModel.getUsername() + "!", Toast.LENGTH_SHORT).show();

//                    Toast.makeText(MainActivity.this, userModel.toString(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception userNotCreated){
                    Toast.makeText(MainActivity.this, "Error saving user", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel("email_error", "password_error", "name_error" );
                }





                //String validations
                // IDEAS todo
                // maybe a do while loop or something here to stop blank data being added to the db
                // or boolean 'Validations' if true - block userModel creation
                // todo if yser in db, do not add user model, but continue with login

                if(et_email.length() == 0) {
                    try {
                        Toast.makeText(MainActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Could not validate email", Toast.LENGTH_SHORT).show();
                    }
                }

                if(et_password.length() < 6) {
                    try {
                        Toast.makeText(MainActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Could not validate password", Toast.LENGTH_SHORT).show();
                    }
                }

                if(et_name.length() == 0) {
                    try {
                        Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Could not validate user", Toast.LENGTH_SHORT).show();
                    }
                }


                // Print out data
//                Toast.makeText(MainActivity.this, et_email.getText().toString() + et_password.getText().toString() + et_name.getText().toString(), Toast.LENGTH_SHORT).show();



                // Connect this data to the db
                DataBaseController dataBaseController = new DataBaseController(MainActivity.this);

                // On successful data creation, addUser method from userModel
                boolean onSuccess = dataBaseController.addUser(userModel);
//                Toast.makeText(MainActivity.this, "Welcome" + userModel.getUsername() + "!" + "onSuccess= " + onSuccess, Toast.LENGTH_SHORT).show();
            }
        });


    }
}