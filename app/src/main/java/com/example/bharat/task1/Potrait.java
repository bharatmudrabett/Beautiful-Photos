package com.example.bharat.task1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by bharat on 18/2/16.
 */
public class Potrait extends Fragment {
View potrait;
    Button Square_btn;
    Button Landscape_btn;
Button next_btn;

    /**
     * Called when the activity is first created.
     */
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
         potrait = inflater.inflate(R.layout.potrait, container, false);
        Square_btn = (Button)potrait.findViewById(R.id.square);

        Landscape_btn = (Button) potrait.findViewById(R.id.landscape);

        next_btn = (Button) potrait.findViewById(R.id.next);

        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Grids.class);
                startActivity(intent);
            }

        });

        Square_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }

        });

        Landscape_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment newfragment1 = new Landscape();
                FrameLayout contentView2 =(FrameLayout) potrait.findViewById(R.id.potrait_frame);
                getFragmentManager().beginTransaction().replace(contentView2.getId(), newfragment1).commit();
            }

        });
return potrait;
    }
}