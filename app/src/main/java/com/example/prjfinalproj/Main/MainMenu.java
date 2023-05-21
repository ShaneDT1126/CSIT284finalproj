package com.example.prjfinalproj.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.prjfinalproj.Tasks.Tasks;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.databinding.ActivityMainBinding;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    TextView txtManage;
    TextView txtTrack,txtCalendar,txtScan,txtSettingsIcon,txtNotfiyMe,txtViewCurrentTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);

        txtManage = findViewById(R.id.txtManage);
        txtTrack = findViewById(R.id.txtTrack);
        txtCalendar = findViewById(R.id.txtCalendar);
        txtScan = findViewById(R.id.txtScan);
        txtSettingsIcon = (TextView) findViewById(R.id.txtSettingsIcon);
        txtNotfiyMe = findViewById(R.id.txtNotifyMe);
        txtViewCurrentTasks =(TextView) findViewById(R.id.txtViewCurrentTasks);
        createNotificationChannel();

        txtManage.setOnClickListener(this);
        txtTrack.setOnClickListener(this);
        txtCalendar.setOnClickListener(this);
        txtScan.setOnClickListener(this);
        txtSettingsIcon.setOnClickListener(this);
        txtNotfiyMe.setOnClickListener(this);
        txtViewCurrentTasks.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.txtManage:
                Intent intent = new Intent(MainMenu.this,ManageSection.class);
                startActivity(intent);
                break;

            case R.id.txtTrack:
                Intent i = new Intent(MainMenu.this,TrackSection.class);
                startActivity(i);
                break;

            case R.id.txtCalendar:
                Intent i2 = new Intent(MainMenu.this,CalendarSection.class);
                startActivity(i2);
                break;

            case R.id.txtScan:
                Intent i3 = new Intent(MainMenu.this,ScanSection.class);
                startActivity(i3);
                break;
            case R.id.txtViewCurrentTasks:
                Intent i4 = new Intent(MainMenu.this,Tasks.class);
                startActivity(i4);
                break;

            case R.id.txtSettingsIcon:
                Intent i6 = new Intent(MainMenu.this,SettingsSection.class);
                startActivity(i6);
                break;
            case R.id.txtNotifyMe:
                Toast.makeText(this, "Reminder Set!", Toast.LENGTH_SHORT).show();
                Intent i7 = new Intent(MainMenu.this,Reminder.class);
                PendingIntent pi = PendingIntent.getBroadcast(MainMenu.this,0,i7,0);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick = System.currentTimeMillis();
                long tenSeconds = 1000 * 10;
                am.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSeconds, pi);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.setting_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSetting:
                Intent i = new Intent(this,SettingsSection.class);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            CharSequence name = "LemubitReminderChannel";
            String description = "Channel for Lemubit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifySheesh",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
}