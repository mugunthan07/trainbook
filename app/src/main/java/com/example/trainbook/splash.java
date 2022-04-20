package com.example.trainbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);

        ImageView logo = findViewById(R.id.logo);
        logo.setBackgroundDrawable(new BitmapDrawable(bg));

        //Creating the Canvas Object
        Canvas canvas = new Canvas(bg);

        //Creating the Paint Object and set its color & TextSize
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        Paint paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        paint2.setStrokeWidth(40);


        canvas.drawRect(100, 150, 600, 700, paint);
        canvas.drawCircle(250, 600, 30, paint1);
        canvas.drawCircle(480, 600, 30, paint1);
        canvas.drawRect(200, 300, 500, 500, paint1);
        canvas.drawRect(250, 200, 450, 250, paint1);
        canvas.drawLine(200, 690, 100, 900, paint2);
        canvas.drawLine(500, 690, 600, 900, paint2);
        canvas.drawLine(160, 750, 540, 750, paint2);
        canvas.drawLine(130, 850, 570, 850, paint2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {

                    Intent intent = new Intent(splash.this, home.class);
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(splash.this,MainActivity.class));
                    finish();
                }

            }

        },2000);



    }
}