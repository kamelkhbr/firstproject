package com.androidavenger.firstproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidavenger.firstproject.R;
import com.androidavenger.firstproject.model.user;

public class activity2 extends AppCompatActivity {

    private EditText personPhone, personEmail;
    private EditText personDescrpt;
    private Button submit;

    public static final String DATA_TAG = "data_tag";

    // Uncrypted shared preferences
    private SharedPreferences sharedPreferences;

    //Used for shared preferences methods below
    public static final String phoneText="phone", emailText="email", desciptionText="Description";
    public static final String SHARED_PREFS="sharedPrefs";

    private String phone,email,description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);


        personPhone = findViewById(R.id.personPhone);
        personEmail = findViewById(R.id.personEmail);
        personDescrpt = findViewById(R.id.personDescrpt);

        // Try this



        submit = findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //trial
                phone = personPhone.getText().toString();
                email = personEmail.getText().toString();
                description = personDescrpt.getText().toString();

                user user1 = new user(phone, email, description);
                Intent intent = new Intent();
                intent.putExtra(DATA_TAG, user1);
                setResult(RESULT_OK, intent);
                finish();
                saveData();
            }
        });
        loadData();
        updateView();

    }

    public void saveData(){

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(phoneText,personPhone.getText().toString());
        editor.putString(emailText,personEmail.getText().toString());
        editor.putString(desciptionText,personDescrpt.getText().toString());
        editor.apply();
        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show();
        }

    public void loadData(){
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        phone = sharedPreferences.getString(phoneText,"");
        email = sharedPreferences.getString(emailText, "");
        description = sharedPreferences.getString(desciptionText, "");


        }
    public void updateView(){
        personPhone.setText(phone);
        personEmail.setText(email);
        personDescrpt.setText(description);

        }


}