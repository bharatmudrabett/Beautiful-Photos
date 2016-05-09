package com.example.bharat.task1;

import android.annotation.TargetApi;
import android.app.Activity;


import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by bharat on 18/2/16.
 */
public class Landscape extends Fragment {
View Landscape;
    Button Potrait_btn;
    Button Square_btn;
    Button next_btn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         Landscape = inflater.inflate(R.layout.landscape, container, false);

        Square_btn = (Button) Landscape.findViewById(R.id.square);
        Potrait_btn = (Button) Landscape.findViewById(R.id.potrait);

        next_btn = (Button) Landscape.findViewById(R.id.next);

        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Grids.class);
                startActivity(intent);
            }

        });

        Potrait_btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            public void onClick(View view) {
                //from activity to landscpe fragment
                Fragment newfragment = new Potrait();
                FrameLayout contentView3 = (FrameLayout) Landscape.findViewById(R.id.landscape_frame);
                getFragmentManager()
                        .beginTransaction()
                        .replace(contentView3.getId(), newfragment)
                        .commit();
            }

        });

        Square_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }

        });
return Landscape;
    }
}