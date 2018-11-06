package demo.video.com.testvideo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by xiongzheng on 2018/11/1.
 */

public class Four extends AppCompatActivity {


    /***
     *
     *        安卓中的面板选择
     *
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ddd);

    }

    public void haha(View view){
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        Intent i2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        Intent i3 = new Intent(Intent.ACTION_PICK);
        i3.setType(ContactsContract.Contacts.CONTENT_TYPE);

        Intent i4 = new Intent(Intent.ACTION_GET_CONTENT);
        i4.setType("video/*");

        Intent i5 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        //设置视频录制的最长时间
        i5.putExtra(MediaStore.EXTRA_DURATION_LIMIT,30);
        //设置视频录制的画质
        i5.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0.5);

        Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
        chooserIntent.putExtra(Intent.EXTRA_INTENT, i);
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{i2,i3,i4,i5});
        startActivity(chooserIntent);

    }
}
