package com.ercan.cihazbilgisiv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class cpu extends AppCompatActivity {
    TextView toolbar;
    String information;
    Toolbar tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);
        toolbar=findViewById(R.id.uwu);
        tool=findViewById(R.id.t);
        tool.setTitle("CPU Bilgisi");
        setSupportActionBar(tool);
        saveinfo();
        toolbar.setText(information);

    }

    public void saveinfo()
    {
        information=
        "\n\n\n"+
                "İşlemci Mimarisi : "+ Build.CPU_ABI +"\n\n"+
                "İşlemci Genel Bilgiler : "+getCPUDetails()+"\n\n";
    }

    public static String getCPUDetails(){

        ProcessBuilder processBuilder;
        StringBuilder cpuDetails = new StringBuilder();
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
        InputStream is;
        Process process ;
        byte[] bArray ;
        bArray = new byte[1024];

        try{
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            is = process.getInputStream();

            while(is.read(bArray) != -1){
                cpuDetails = new StringBuilder("\n" + cpuDetails + new String(bArray));
            }
            is.close();

        } catch(IOException ex){
            ex.printStackTrace();
        }

        return cpuDetails.toString();
    }
}

