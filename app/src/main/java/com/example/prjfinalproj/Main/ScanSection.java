package com.example.prjfinalproj.Main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;




import com.example.prjfinalproj.R;
import com.example.prjfinalproj.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScanSection extends AppCompatActivity implements View.OnClickListener {

    ImageView imgImage;
    Button btnCaptureImg,btnUploadImg;
    Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_scan_section);

        imgImage = (ImageView)findViewById(R.id.imgImage);
        btnCaptureImg = (Button)findViewById(R.id.btnCaptureImg);
        btnUploadImg = findViewById(R.id.btnUploadImg);

        btnCaptureImg.setOnClickListener(this);
        btnUploadImg.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        bitmap =(Bitmap) data.getExtras().get("data");
        imgImage.setImageBitmap(bitmap);


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}