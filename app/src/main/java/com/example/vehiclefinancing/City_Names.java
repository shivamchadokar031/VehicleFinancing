package com.example.vehiclefinancing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class City_Names extends AppCompatActivity implements View.OnClickListener{
    ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12, im13, im14;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_names);

        im1=(ImageView) findViewById(R.id.img1);
        im1.setOnClickListener(this);
        im2=(ImageView) findViewById(R.id.img2);
        im2.setOnClickListener(this);
        im3=(ImageView) findViewById(R.id.img3);
        im3.setOnClickListener(this);
        im4=(ImageView) findViewById(R.id.img4);
        im4.setOnClickListener(this);
        im5=(ImageView) findViewById(R.id.img5);
        im5.setOnClickListener(this);
        im6=(ImageView) findViewById(R.id.img6);
        im6.setOnClickListener(this);
        im7=(ImageView) findViewById(R.id.img7);
        im7.setOnClickListener(this);
        im8=(ImageView) findViewById(R.id.img8);
        im8.setOnClickListener(this);
        im9=(ImageView) findViewById(R.id.img9);
        im9.setOnClickListener(this);
        im10=(ImageView) findViewById(R.id.img10);
        im10.setOnClickListener(this);
        im11=(ImageView) findViewById(R.id.img11);
        im11.setOnClickListener(this);
        im12=(ImageView) findViewById(R.id.img12);
        im12.setOnClickListener(this);
        im13=(ImageView) findViewById(R.id.img13);
        im13.setOnClickListener(this);
        im14=(ImageView) findViewById(R.id.img14);
        im14.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img1:
                Intent intent = new Intent(City_Names.this, service.class);
                intent.putExtra("new_text", "New Delhi");
                startActivity(intent);
                break;
            case R.id.img2:
                Intent intent1 = new Intent(City_Names.this, service.class);
                intent1.putExtra("new_text", "Indore");
                startActivity(intent1);
                break;
            case R.id.img3:
                Intent intent2 = new Intent(City_Names.this, service.class);
                intent2.putExtra("new_text", "Ahemdabad");
                startActivity(intent2);
                break;
            case R.id.img4:
                Intent intent3 = new Intent(City_Names.this, service.class);
                intent3.putExtra("new_text", "Jaipur");
                startActivity(intent3);
                break;
            case R.id.img5:
                Intent intent4 = new Intent(City_Names.this, service.class);
                intent4.putExtra("new_text", "Chennai");
                startActivity(intent4);
                break;
            case R.id.img6:
                Intent intent5 = new Intent(City_Names.this, service.class);
                intent5.putExtra("new_text", "Kochi");
                startActivity(intent5);
                break;
            case R.id.img7:
                Intent intent6 = new Intent(City_Names.this, service.class);
                intent6.putExtra("new_text", "Gurgaon");
                startActivity(intent6);
                break;
            case R.id.img8:
                Intent intent7 = new Intent(City_Names.this, service.class);
                intent7.putExtra("new_text", "Mumbai");
                startActivity(intent7);
                break;
            case R.id.img9:
                Intent intent8 = new Intent(City_Names.this, service.class);
                intent8.putExtra("new_text", "Noida");
                startActivity(intent8);
                break;
            case R.id.img10:
                Intent intent9 = new Intent(City_Names.this, service.class);
                intent9.putExtra("new_text", "Pune");
                startActivity(intent9);
                break;
            case R.id.img11:
                Intent intent10 = new Intent(City_Names.this, service.class);
                intent10.putExtra("new_text", "Kolkata");
                startActivity(intent10);
                break;
            case R.id.img12:
                Intent intent11 = new Intent(City_Names.this, service.class);
                intent11.putExtra("new_text", "Lucknow");
                startActivity(intent11);
                break;
            case R.id.img13:
                Intent intent12 = new Intent(City_Names.this, service.class);
                intent12.putExtra("new_text", "Hyderabad");
                startActivity(intent12);
                break;
            case R.id.img14:
                Intent intent13 = new Intent(City_Names.this, service.class);
                intent13.putExtra("new_text", "Bangalore");
                startActivity(intent13);
                break;

            default:
                break;
        }

    }
}