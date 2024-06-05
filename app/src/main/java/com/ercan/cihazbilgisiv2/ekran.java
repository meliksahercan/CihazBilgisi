package com.ercan.cihazbilgisiv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class ekran extends AppCompatActivity {
TextView t;
    TextView t1;
    TextView t2;
    Toolbar toolbar;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran);
        t=findViewById(R.id.width);
        t1=findViewById(R.id.high);
        t2=findViewById(R.id.inch);
        toolbar=findViewById(R.id.disp);
        toolbar.setTitle("Ekran Bilgisi");
        setSupportActionBar(toolbar);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth=dm.widthPixels;
        int screenHeight=dm.heightPixels;
        double x=Math.pow(screenWidth/dm.xdpi,2);
        double y=Math.pow(screenHeight/dm.xdpi,2);
        double screenInches=Math.sqrt(x+y);
        screenInches=(double)Math.round(screenInches *10)/10;
        t.setText("Ekran Genişliği (Piksel) : "+screenWidth);
        t1.setText("Ekran Yüksekliği (Piksel) : "+screenHeight);
        t2.setText("Ekran Boyutu (İnç) : "+screenInches);
    }
}
