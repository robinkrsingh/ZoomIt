package com.zoomit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {


    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.image_grid_view);

        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                showImage(position);
            }
        });

        showImage(0);
    }

    public void showImage(int position) {
        ZoomItImageView imageView = (ZoomItImageView) findViewById(R.id.imageView);


        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inPurgeable = true;

        try {


            ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext());

            bitmap = BitmapFactory.decodeResource(getResources(), imageAdapter.mThumbIds[position]);
            imageView.setImageBitmap(bitmap);
            imageView.setMaxZoom(4f);

        } catch (Exception ex) {
            Log.e("Exception", ex.getLocalizedMessage());
        }

    }
}
