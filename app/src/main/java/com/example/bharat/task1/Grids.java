package com.example.bharat.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by bharat on 20/2/16.
 */
public class Grids extends Activity {

    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grids);
        Button nxt = (Button) findViewById(R.id.next);

        final RadioButton rb1 = (RadioButton) findViewById(R.id.ib1);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.ib2);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.ib3);
        nxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (rb1.isChecked()) {
                    Intent intent = new Intent(Grids.this, Flip.class);
                    startActivity(intent);
                } else {
                    if (rb2.isChecked()) {
                        Intent intent = new Intent(Grids.this, Flip.class);
                        startActivity(intent);
                    } else {
                        if (rb3.isChecked()) {
                            Intent intent = new Intent(Grids.this, Flip.class);
                            startActivity(intent);
                        }
                    }

                }

            }
        });

    }
}