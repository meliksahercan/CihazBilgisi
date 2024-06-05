package com.ercan.cihazbilgisiv2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class batarya extends AppCompatActivity {
Toolbar toolbar;
TextView te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batarya);
        toolbar=findViewById(R.id.batt);
        te=findViewById(R.id.te);
        toolbar.setTitle("Batarya Bilgisi");
        setSupportActionBar(toolbar);
        loadbattery();

    }
    public void loadbattery()
    {
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(batteryInfoReceiver,intentFilter);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateBatteryData(Intent intent)
    {
        boolean present=intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT,false);
        if(present) {
            StringBuffer battayinfo = new StringBuffer();
            int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
            battayinfo.append("Batarya Sağlığı : ").append(health).append("\n\n");

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            if (level != -1 && scale != -1) {
                int batterypact = (int) ((level / (float) scale) * 100f);
                battayinfo.append("Pil Yüzdesi : ").append(batterypact).append("\n\n");
            }
            int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
            battayinfo.append("Adaptöre Takılı Olma Durumu : ").append(plugged).append("\n\n");

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            battayinfo.append("Şarj Olma Durumu : ").append(status).append("\n\n");

            if (intent.getExtras() != null) {
                String technology = intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
                battayinfo.append("Teknoloji : ").append(technology).append("\n\n");
            }

            int temprature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
            if (temprature > 0) {
                battayinfo.append("Sıcaklık : ").append((float) temprature / 10f).append(" Derece\n\n");
            }
            int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
            battayinfo.append("Voltage : ").append(voltage).append("mV\n\n");

            long capacity = getBattaryCapacity();
            battayinfo.append("Capacity : ").append(capacity).append("mAh\n\n");
            te.setText(battayinfo.toString());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private long getBattaryCapacity()
    {
        if(Build.VERSION.SDK_INT>-Build.VERSION_CODES.LOLLIPOP)
        {
        BatteryManager mBatteryManager=(BatteryManager)getSystemService(Context.BATTERY_SERVICE);
        Long chargeCounter=mBatteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
        Long capacity=mBatteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        if(chargeCounter !=null && capacity !=null)
            {
                long value=(long)((float)chargeCounter/(float)capacity*100f);
                return value;
            }
        }
        return 0;
    }
    private final BroadcastReceiver batteryInfoReceiver=new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onReceive(Context context, Intent intent) {
            updateBatteryData(intent);
        }
    };
}
