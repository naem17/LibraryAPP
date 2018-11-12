package com.example.admin1.libraryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashActivity extends Activity {

    private final int DURATION_SPLASH = 3000;
    private GifImageView mGifImageView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);

        mGifImageView = (GifImageView)findViewById(R.id.gifImageView);
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(mProgressBar.VISIBLE);


            //set GifImageView resources
            try {
                InputStream inputStream = getAssets().open("logoFinal.gif");
                byte[] bytes = IOUtils.toByteArray(inputStream);
                mGifImageView.setBytes(bytes);
                mGifImageView.startAnimation();
            }catch (IOException ex) {

            }

            //esperar 3 segundos (duration splash) y comenzar el main activity

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LibraryActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURATION_SPLASH);
    }
}
