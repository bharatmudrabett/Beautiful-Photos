package com.example.bharat.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by bharat on 25/4/16.
 */
public class Two extends Activity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        Button nxt=(Button)findViewById(R.id.nxt);
        nxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Two.this, Flip.class);
                startActivity(intent);
            }

        });
    }
}