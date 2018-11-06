package demo.video.com.testvideo;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by xiongzheng on 2018/11/2.
 */

public class OpenCamera extends AppCompatActivity implements SurfaceHolder.Callback{

    SurfaceView surfaceView;
    Camera camera;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eee);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);

        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(this);


    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera = Camera.open();
            if (camera == null) {
                int cametacount = Camera.getNumberOfCameras();
                camera = Camera.open(cametacount - 1);
            }

            Camera.Parameters params = camera.getParameters();
            params.setJpegQuality(100);//照片质量
            params.setPictureSize(1024, 768);//图片分辨率
            params.setPreviewFrameRate(5);//预览帧率

            camera.setDisplayOrientation(90);
            /**
             * 设置预显示
             */
            camera.setPreviewDisplay(holder);
            camera.setPreviewCallback(new Camera.PreviewCallback() {
                @Override
                public void onPreviewFrame(byte[] data, Camera camera) {

                }
            });
            /**
             * 开启预览
             */
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
