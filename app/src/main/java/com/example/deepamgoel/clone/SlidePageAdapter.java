package com.example.deepamgoel.clone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class SlidePageAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private int[] imageImageView = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    private String[] subHeadingTextView;
    private String[] contentTextView;
    private String[] readMoreTextView;

    SlidePageAdapter(Context context) {
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        subHeadingTextView = context.getResources().getStringArray(R.array.subHeading);
        contentTextView = context.getResources().getStringArray(R.array.content);
        readMoreTextView = context.getResources().getStringArray(R.array.readMore);
    }

    @Override
    public int getCount() {
        return imageImageView.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.card_layout, container, false);

        RoundedImageView image = view.findViewById(R.id.image);
        RoundedImageView readMoreImage = view.findViewById(R.id.read_more_image);
        TextView heading = view.findViewById(R.id.subheading);
        TextView content = view.findViewById(R.id.content);
        TextView readMore = view.findViewById(R.id.read_more);

        image.setImageResource(imageImageView[position]);
        readMoreImage.setImageResource(imageImageView[position]);
        heading.setText(subHeadingTextView[position]);
        content.setText(contentTextView[position]);
        readMore.setText(readMoreTextView[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((FrameLayout) object);
    }
}
