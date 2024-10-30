package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText n;
    EditText em;
    TextView n1;
    TextView n2;
    // Creating a Cookie
    SharedPreferences sharepreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.name);
        em = findViewById(R.id.email);
        n1 = findViewById(R.id.viewName);
        n2 = findViewById(R.id.viewEmail);
        // Identifying the cookie
        sharepreferences=getSharedPreferences("gust", Context.MODE_PRIVATE);
    }
    public void save(View v){
        // Moving everything to the cookie
        String name = n.getText().toString();
        String email = em.getText().toString();
        // Creating Editor to contain all the cookies
        SharedPreferences.Editor editor =sharepreferences.edit();
        // Placing the Cookies into the editor
        editor.putString("namecookie",name);
        editor.putString("emailcookie", email);
        editor.commit();

        // Grabbing the info from the Storage and into the Text View
        n1.setText(sharepreferences.getString("namecookie",""));
        n2.setText(sharepreferences.getString("emailcookie",""));
    }
}