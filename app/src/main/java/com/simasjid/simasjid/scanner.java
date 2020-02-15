package com.simasjid.simasjid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    private static final int CAMERA_PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        Toast.makeText(getApplicationContext(), "Membuka scanner...", Toast.LENGTH_SHORT).show();
        generate();
    }

    private void generate() {
        mScannerView = new ZXingScannerView(scanner.this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(scanner.this);
        mScannerView.startCamera();

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String text;
        text = result.getText();
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        mScannerView.stopCamera();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("kode_aset", text);
        startActivity(intent);
    }
}
