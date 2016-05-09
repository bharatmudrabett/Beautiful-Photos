package com.example.bharat.task1;

/**
 * Created by bharat on 6/5/16.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Clock extends Activity {
    private int rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotation);
        if (savedInstanceState != null) {
            rotation = savedInstanceState.getInt("ANGLE");
        }
        final ImageView imageView = (ImageView) findViewById(R.id.image);
        final Button button = (Button) findViewById(R.id.clock);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final int width = metrics.widthPixels;
        final int height = metrics.heightPixels;

        final Bitmap imageBitmap = BitmapFactory.decodeResource(
                getResources(), R.drawable.index);
        final Bitmap scaledBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, true);
        imageView.setImageBitmap(getRotatedBitmap(scaledBitmap));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rotation += 90;
                rotation %= 360;
                Bitmap bitmap = getRotatedBitmap(scaledBitmap);
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private Bitmap getRotatedBitmap(Bitmap bitmap) {
        if (rotation % 360 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(rotation, bitmap.getWidth(),
                bitmap.getHeight() );
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight() , matrix, true);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("ANGLE", rotation);
        super.onSaveInstanceState(outState);
    }
}