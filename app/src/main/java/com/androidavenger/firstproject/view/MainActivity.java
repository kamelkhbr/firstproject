package com.androidavenger.firstproject.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidavenger.firstproject.R;
import com.androidavenger.firstproject.model.user;

import static com.androidavenger.firstproject.util.constants.PHN_KEY;
import static com.androidavenger.firstproject.util.constants.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private Button profile;
    private TextView PhNum , email;
    private TextView description;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile);
        PhNum = findViewById(R.id.PhNum);
        email = findViewById(R.id.email);
        description = findViewById(R.id.description);



        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity2.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE) {

                user appUser = (user) data.getSerializableExtra(activity2.DATA_TAG);
                Object updateInfo;
                updateInfo(appUser);
            }
        }

        private void updateInfo(user appUser) {

            PhNum.setText(appUser.getPhone());
            email.setText(appUser.getEmail());
            description.setText(appUser.getDescription());

        }
    }