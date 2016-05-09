package com.example.bharat.task1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Anti extends Activity {
    private int rotation;
private Button clock,anticlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotation);
        if (savedInstanceState != null) {
            rotation = savedInstanceState.getInt("ANGLE");
        }
        final ImageView imageView = (ImageView) findViewById(R.id.imgView);
      anticlock= (Button) findViewById(R.id.anti);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        final Bitmap imageBitmap = BitmapFactory.decodeResource(
                getResources(), R.drawable.index);
        final Bitmap scaledBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, true);
        imageView.setImageBitmap(getRotatedBitmap(scaledBitmap));

        anticlock.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                rotation -= 90;
                rotation %= 360;
                Bitmap bitmap = getRotatedBitmap(scaledBitmap);
                imageView.setImageBitmap(bitmap);
            }
        });
        clock= (Button) findViewById(R.id.clock);
        clock.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                rotation += 90;
                rotation %= 360;
                Bitmap bitmap = getRotatedBitmap(scaledBitmap);
                imageView.setImageBitmap(bitmap);
            }
        });
        Button nxt=(Button)findViewById(R.id.nxt);
        nxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Anti.this, Brightness.class);
                startActivity(intent);
            }

        });

    }

    private Bitmap getRotatedBitmap(Bitmap bitmap) {
        if (rotation % 360 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(rotation, bitmap.getWidth(),
                bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight() , matrix, true);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("ANGLE", rotation);
        super.onSaveInstanceState(outState);
    }

}
