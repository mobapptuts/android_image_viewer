package mobapptut.com.imageviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewMainActivity extends AppCompatActivity {

    ImageView mImageView;
    private static final int REQUEST_OPEN_RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_main);

        mImageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_OPEN_RESULT_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if(requestCode == REQUEST_OPEN_RESULT_CODE && resultCode == RESULT_OK) {
            Uri uri = null;
            if(resultData != null) {
                uri = resultData.getData();
            }
        }
    }
}
