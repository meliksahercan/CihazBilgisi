package com.ercan.cihazbilgisiv2;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import org.jetbrains.annotations.NotNull;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class network extends AppCompatActivity {
Toolbar toolbar;
TextView textView;
TelephonyManager tm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        toolbar=findViewById(R.id.Network);
        textView=findViewById(R.id.tee);
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        toolbar.setTitle("Ağ Bilgisi");
        setSupportActionBar(toolbar);
        getwifi();
    }

    public void getwifi()
    {
        WifiManager wifiManager=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo=wifiManager.getConnectionInfo();
        int rssi=wifiInfo.getRssi();
        int linkspeed=wifiInfo.getLinkSpeed();
        int ip=wifiInfo.getIpAddress();
        boolean state=wifiManager.is5GHzBandSupported();
        String ssid=wifiInfo.getSSID();
        String bssid=wifiInfo.getBSSID();
        String ipAddress = Formatter.formatIpAddress(ip);
        String networkop=tm.getNetworkOperatorName();
        String info=
                "RSSI: "+rssi+
                "\n\n"+"Maksimum Bağlantı Hızı (Mbps): "+linkspeed+
                        "\n\n"+"SSID: "+ssid+
                        "\n\n"+"BSSID: "+bssid+
                "\n\n"+"IP Adresi: "+ipAddress+
                        "\n\n"+"5 GHz Desteği: "+state+



                        "\n\n"+"Ağ Operatörü: "+networkop;
                textView.setText(info);
    }
    @NotNull
    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "";
    }
}
