package com.example.hp1.dog;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp1 on 27/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<Bitmap> {
    private int resource;
    public CustomAdapter(Context context, int resource, List<Bitmap> images) {
        super(context, resource, images);
        this.resource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater imageInflater = LayoutInflater.from(getContext());
        View cuView = imageInflater.inflate(resource, parent, false);

        Bitmap image = getItem(position);
        ImageView imageView = (ImageView) cuView.findViewById(R.id.dogImage);
        imageView.setImageBitmap(image);

        return cuView;
    }
}
