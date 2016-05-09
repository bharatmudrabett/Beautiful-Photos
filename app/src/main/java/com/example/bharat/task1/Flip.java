package com.example.bharat.task1;

/**
 * Created by bharat on 6/5/16.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.os.Bundle;

public class Flip extends Activity {

    Button buttonFlip;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flip);

       image = (ImageView)findViewById(R.id.image);


        buttonFlip = (Button)findViewById(R.id.buttonflip);

        buttonFlip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                flipIt(image);
            }
        });

        Button nxt=(Button)findViewById(R.id.nxt);
        nxt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Flip.this, Anti.class);
                startActivity(intent);
            }

        });
    }

    private void flipIt(final View viewToFlip) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(image, "rotationX", 0f, 180f);

        flip.start();

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }



}