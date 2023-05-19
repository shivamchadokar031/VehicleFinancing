package com.example.vehiclefinancing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class service extends AppCompatActivity {
    ImageView i, img1, img2, img31, img4,img5, img345;
    TextView t, t1;
    FloatingActionButton emi;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
        i=(ImageView) findViewById(R.id.img3);
        img1=(ImageView) findViewById(R.id.home);
        img2=(ImageView) findViewById(R.id.help);
        img31=(ImageView) findViewById(R.id.cars);
        img4=(ImageView) findViewById(R.id.menu);
        img5=(ImageView) findViewById(R.id.arrow);
        img345=(ImageView) findViewById(R.id.car345);
        t=(TextView) findViewById(R.id.choose);
        emi=findViewById(R.id.add_fab);
        FragmentManager fragmentManager=getSupportFragmentManager();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        img31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(service.this, carsmore.class);
                startActivity(intent);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(service.this, sell.class);
                startActivity(intent);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(service.this, service.class);
                startActivity(intent);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(service.this,City_Names.class);
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(service.this,City_Names.class);
                startActivity(intent);
            }
        });
        String newText = getIntent().getStringExtra("new_text");
        if (newText != null) {
            t.setText(newText);
        }

        img345.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(service.this, carsmore.class);
                startActivity(intent);
            }
        });
        emi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.whole,emicalculator.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });






    }
}
