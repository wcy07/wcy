 package com.example.weatherapp;

 import androidx.appcompat.app.AppCompatActivity;

 import android.content.Intent;
 import android.content.SharedPreferences;
 import android.os.Bundle;
 import android.preference.PreferenceManager;

 import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {//事件监听

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);//参考LitePal项目主页用法
        setContentView(R.layout.activity_main);

       SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather",null)!=null){
            Intent intent= new Intent (this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }

}
}
