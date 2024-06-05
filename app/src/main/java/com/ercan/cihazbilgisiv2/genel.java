package com.ercan.cihazbilgisiv2;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class genel extends AppCompatActivity {
    TextView inf;
    String information;
    Toolbar tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genel);
        inf=findViewById(R.id.inf);
        tool=findViewById(R.id.too);
        tool.setTitle("Genel Bilgi");
        setSupportActionBar(tool);
        saveinfo();
        inf.setText(information);


    }
    public void saveinfo()
    {
        information="Marka : "+ Build.BRAND +"\n\n"+
                "Model : "+ Build.MODEL +"\n\n"+
                "Ürün Kodu : "+ Build.PRODUCT +"\n\n"+
                "Donanım Kodu : "+ Build.HARDWARE +"\n\n"+
                "Cihaz Kodu : "+ Build.DEVICE +"\n\n"+
                "Üretici : "+ Build.MANUFACTURER +"\n\n"+
                "Seri Numarası : "+ Build.SERIAL +"\n\n"+
                "Android Buildini Yapanın Kullanıcı Adı : "+ Build.USER +"\n\n"+
                "Seri Numarası : "+ Build.TIME +"\n\n"+
                "Android Yapı Parmak İzi : "+ Build.FINGERPRINT +"\n\n"+
                "Bootloader Sürüm Numarası : "+ Build.BOOTLOADER +"\n\n";
    }
    }

