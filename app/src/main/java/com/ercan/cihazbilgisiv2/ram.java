package com.ercan.cihazbilgisiv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ram extends AppCompatActivity {
    TextView memo;
    Toolbar t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram);
        t=findViewById(R.id.t);
        t.setTitle("RAM Bilgisi");
        setSupportActionBar(t);
        memo=findViewById(R.id.memo);
        memo.setText(getMemory());
    }
    public static String getMemoryName() {
        try {
            FileReader fr = new FileReader("/proc/meminfo");
            BufferedReader br = new BufferedReader(fr);
            String text = br.readLine();
            br.close();
            String[] array = text.split(":\\s+", 2);
            if (array.length >= 2) {
                return array[1];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getMemory()
    {
        ActivityManager.MemoryInfo memoryInfo=new ActivityManager.MemoryInfo();
        ActivityManager activityManager=(ActivityManager)getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Kullanılabilir RAM (Byte) : ").append(memoryInfo.availMem).append("\n\n");
        stringBuilder.append("Toplam RAM Miktarı : ").append(getMemoryName()).append("\n\n");
        return stringBuilder.toString();

    }
}

