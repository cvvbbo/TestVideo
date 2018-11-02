package demo.video.com.testvideo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //如果授予多个权限？？
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.CAMERA},100);
            }
        }
    }


    public void haha1(View view){
        startActivity(new Intent(this,First.class));

    }

    public void haha2(View view){
        startActivity(new Intent(this,Second.class));
    }

    public void haha3(View view){
        startActivity(new Intent(this,Third.class));
    }

    public void haha4(View view){
        startActivity(new Intent(this,Four.class));
    }
}
