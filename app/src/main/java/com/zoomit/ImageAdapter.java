package com.zoomit;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;


    public Integer[] mThumbIds = {
            R.drawable.gv1, R.drawable.gv2,
            R.drawable.gv3, R.drawable.gv4,
            R.drawable.gv5, R.drawable.gv6,
            R.drawable.gv7, R.drawable.gv8,
            R.drawable.gv9, R.drawable.gv1, R.drawable.gv2,
            R.drawable.gv3, R.drawable.gv4,
            R.drawable.gv5, R.drawable.gv6,
            R.drawable.gv7, R.drawable.gv8,
            R.drawable.gv9
    };

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
        return imageView;
    }

}

