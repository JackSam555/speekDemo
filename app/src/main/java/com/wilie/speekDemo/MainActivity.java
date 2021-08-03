package com.wilie.speekDemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.wilie.speak.SpeakManage;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpeakManage tts = SpeakManage.getInstance(this);
        tts.setLanguage(Locale.CHINA);
        tts.setPitch(1.2f);
        tts.setSpeechRate(0.4f);
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    tts.speak("哈哈哈，我的demo测试成功了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}