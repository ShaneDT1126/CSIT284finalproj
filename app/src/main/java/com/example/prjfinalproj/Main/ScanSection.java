package com.example.prjfinalproj.Main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.prjfinalproj.R;
import com.example.prjfinalproj.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScanSection extends AppCompatActivity  {

    ImageView imgImage;
    Button btnCaptureImg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_scan_section);

        imgImage = (ImageView)findViewById(R.id.imgImage);
        btnCaptureImg = (Button)findViewById(R.id.btnCaptureImg);

        btnCaptureImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openCamera();

            }

        });





    }



    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "new image");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Taken by Camera");
        Uri img_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cam_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cam_intent.putExtra(MediaStore.EXTRA_OUTPUT, img_uri);
        startActivity(cam_intent);

    }


}