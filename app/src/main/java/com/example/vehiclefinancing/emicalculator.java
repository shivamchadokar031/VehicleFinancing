package com.example.vehiclefinancing;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehiclefinancing.R;


public class emicalculator extends Fragment {
    EditText e1, e2 ,e3;
    TextView emi;

    Button button;
    int a,b,c,d,e;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_emicalculator, container, false);

        button = view.findViewById(R.id.button);
        e1=view.findViewById(R.id.amount);
        e2=view.findViewById(R.id.intrest);
        e3=view.findViewById(R.id.tenure);
        emi=view.findViewById(R.id.emi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(e1.getText().toString());
                b = Integer.parseInt(e2.getText().toString());
                c = Integer.parseInt(e3.getText().toString());
                d=a*b*(1+b)^c;
                e=(1+b)^(c-1);
                int emi1=d/e;
                emi.setText(emi1);



            }
        });
        return view;
    }




}