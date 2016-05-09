package com.example.bharat.task1;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    Button Potrait_btn;
    Button Landscape_btn;
    Button Square_btn;
    Button next_btn;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Potrait_btn=(Button)findViewById(R.id.potrait);
        Square_btn=(Button)findViewById(R.id.square);
        Landscape_btn=(Button)findViewById(R.id.landscape);

        Potrait_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment newfragment = new Potrait();
                FrameLayout contentView3 = (FrameLayout)findViewById(R.id.main_frame);
                getFragmentManager()
                        .beginTransaction()
                        .replace(contentView3.getId(), newfragment)
                        .commit();
//


            }

        });

        next_btn =(Button)findViewById(R.id.next);

        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Grids.class);
                startActivity(intent);
            }

        });


        Landscape_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment newfragment = new Landscape();
                FrameLayout contentView3 = (FrameLayout)findViewById(R.id.main_frame);
                getFragmentManager()
                        .beginTransaction()
                        .replace(contentView3.getId(), newfragment)
                        .commit();
//

            }

        });

    }


}
