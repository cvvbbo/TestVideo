package demo.video.com.testvideo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by xiongzheng on 2018/10/31.
 */

public class First  extends AppCompatActivity{

    /***
     *
     * 使用系统自带的摄像头来录像
     * @param savedInstanceState
     *
     * https://blog.csdn.net/woshizisezise/article/details/51878566
     *
     *
     */

    VideoView videoView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);
        videoView = (VideoView) findViewById(R.id.video);

    }

    public void haha(View view){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        //设置视频录制的最长时间
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,30);
        //设置视频录制的画质
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0.5);
        startActivityForResult (intent, 300);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try{
            if (resultCode == Activity.RESULT_OK && requestCode == 300){
                Uri uri = data.getData();
                Log.e("videoview", "onActivityResult: " + uri.toString());
                //但是进度条的位置不能控制
                MediaController mediaController = new MediaController(this);
                //mediaController.setVisibility(View.GONE);
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.start();
                videoView.requestFocus();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
