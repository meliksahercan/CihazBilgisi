package com.ercan.cihazbilgisiv2;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import static android.os.Build.getRadioVersion;


public class yazilim extends AppCompatActivity {
    TextView inf;
    String information;
    Toolbar tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genel);
        inf=findViewById(R.id.inf);
        tool=findViewById(R.id.too);
        tool.setTitle("Yazılım Bilgileri");
        setSupportActionBar(tool);
        saveinfo();
        inf.setText(information);


    }
    public void saveinfo()
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            information =
                    "Android Sürümü : "+ Build.VERSION.RELEASE+"\n\n"+
                    "Android Sürümü ID : "+ Build.ID +"\n\n"+
                    "Android SDK Versiyonu : "+ Build.VERSION.SDK_INT+"\n\n"+
                    "Android Sürümü Kod Adı : "+ Build.VERSION.CODENAME +"\n\n"+
                    "Kullanıcı Arayüzü Versiyonu : "+ Build.VERSION.INCREMENTAL+"\n\n"+
                    "Güvenlik Yaması Versiyonu : "+ Build.VERSION.SECURITY_PATCH+"\n\n"+
                    "Ana Bant Versiyonu : "+ getRadioVersion()+"\n\n"+
                    "Dahili Ana Bilgisayar Adı : "+ Build.HOST +"\n\n";

        }

    }

}
