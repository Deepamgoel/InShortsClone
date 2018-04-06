package com.example.deepamgoel.clone;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SlidePageAdapter extends PagerAdapter {

    private Context context;
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

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.card_layout, container, false);

        final ImageView image = view.findViewById(R.id.image);
        final ImageView readMoreImage = view.findViewById(R.id.read_more_image);
        final TextView heading = view.findViewById(R.id.subheading);
        final TextView content = view.findViewById(R.id.content);
        final TextView readMore = view.findViewById(R.id.read_more);

        final RelativeLayout footer1 = view.findViewById(R.id.footer1);
        final RelativeLayout footer2 = view.findViewById(R.id.footer2);
        final RelativeLayout header = view.findViewById(R.id.header);

        final ImageView like = view.findViewById(R.id.like);
        final TextView like_count = view.findViewById(R.id.like_count);
//        final ImageView share = view.findViewById(R.id.share);
        final ImageView bookmark = view.findViewById(R.id.bookmark);

        image.setImageResource(imageImageView[position]);

        Drawable drawable = view.getResources().getDrawable(imageImageView[position]);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Bitmap blurredBitmap = BlurBuilder.blur(context, bitmap);
        readMoreImage.setImageBitmap(blurredBitmap);
        readMoreImage.setColorFilter(0x76AAAAAA, PorterDuff.Mode.MULTIPLY);

        heading.setText(subHeadingTextView[position]);
        content.setText(contentTextView[position]);
        readMore.setText(readMoreTextView[position]);

        container.addView(view);

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (footer1.getVisibility() == View.INVISIBLE) {
                    footer1.setVisibility(View.VISIBLE);
                    footer2.setVisibility(View.INVISIBLE);
                    header.setVisibility(View.VISIBLE);
                } else {
                    footer1.setVisibility(View.INVISIBLE);
                    footer2.setVisibility(View.VISIBLE);
                    header.setVisibility(View.INVISIBLE);
                }

            }
        });


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (footer1.getVisibility() == View.INVISIBLE) {
                    footer1.setVisibility(View.VISIBLE);
                    footer2.setVisibility(View.INVISIBLE);
                    header.setVisibility(View.VISIBLE);
                } else {
                    footer1.setVisibility(View.INVISIBLE);
                    footer2.setVisibility(View.VISIBLE);
                    header.setVisibility(View.INVISIBLE);
                }

            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tag = String.valueOf(like.getTag());

                if (tag.equals("like_outline")) {
                    like.setImageResource(R.drawable.thumb_up);
                    like_count.setText("1");
                    like.setTag("like");
                } else if (tag.equals("like")) {
                    like.setImageResource(R.drawable.thumb_up_outline);
                    like_count.setText("");
                    like.setTag("like_outline");
                }
            }
        });


        heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (heading.getCurrentTextColor() == view.getResources().getColor(R.color.subHeadingColor)) {
                    bookmark.setImageResource(R.drawable.bookmark);
                    Toast.makeText(context, "News Bookmarked", Toast.LENGTH_SHORT).show();
                    heading.setTextColor(view.getResources().getColor(R.color.bookmarkText));
                    bookmark.setTag("bookmark");
                } else {
                    bookmark.setImageResource(R.drawable.bookmark_outline);
                    Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                    heading.setTextColor(view.getResources().getColor(R.color.subHeadingColor));
                    bookmark.setTag("bookmark_outline");
                }
            }
        });

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tag = String.valueOf(bookmark.getTag());

                if (tag.equals("bookmark_outline")) {
                    bookmark.setImageResource(R.drawable.bookmark);
                    Toast.makeText(context, "News Bookmarked", Toast.LENGTH_SHORT).show();
                    heading.setTextColor(view.getResources().getColor(R.color.bookmarkText));
                    bookmark.setTag("bookmark");
                } else if (tag.equals("bookmark")) {
                    bookmark.setImageResource(R.drawable.bookmark_outline);
                    Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                    heading.setTextColor(view.getResources().getColor(R.color.subHeadingColor));
                    bookmark.setTag("bookmark_outline");
                }
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((FrameLayout) object);
    }
}
