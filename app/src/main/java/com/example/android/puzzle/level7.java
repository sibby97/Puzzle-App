package com.example.android.puzzle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class level7 extends AppCompatActivity {

    Point p;
    int comtim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level7);
        ImageView img = (ImageView) findViewById(R.id.image1);
        TextView textView = (TextView) findViewById(R.id.quest1);
        final Chronometer chrono = (Chronometer) findViewById(R.id.chronometer);
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t = (TextView) findViewById(R.id.whint1);
                if (t.getVisibility() == View.VISIBLE) {
                    t.setVisibility(View.INVISIBLE);
                } else {
                    t.setVisibility(View.VISIBLE);
                }
            }
        });

        TextView t = (TextView) findViewById(R.id.whint1);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open popup window
                if (p != null)
                    showPopup(level7.this, p);
            }
        });

        img.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch (View v, MotionEvent ev) {
                final int action = ev.getAction();
                // (1)
                final int evX = (int) ev.getX();
                final int evY = (int) ev.getY();
                int nextImage =0;
                switch (action) {
                    case MotionEvent.ACTION_DOWN :
                        int currentResource  = v.getId();
                        if (currentResource == R.drawable.whereami) {
                            nextImage = R.drawable.whereamihotspot;
                        }
                        break;
                    case MotionEvent.ACTION_UP :
                        // On the UP, we do the click action.
                        // The hidden image (image_areas) has three different hotspots on it.
                        // The colors are red, blue, and yellow.
                        // Use image_areas to determine which region the user touched.
                        // (2)
                        int touchColor = getHotspotColor (R.id.image_areas1, evX, evY);
                        // Compare the touchColor to the expected values.
                        // Switch to a different image, depending on what color was touched.
                        // Note that we use a Color Tool object to test whether the
                        // observed color is close enough to the real color to
                        // count as a match. We do this because colors on the screen do
                        // not match the map exactly because of scaling and
                        // varying pixel density
                        int tolerance = 25;
                        nextImage = R.drawable.whereami;
                        // (3)
                        if (closeMatch (Color.parseColor("#B5E61D"), touchColor, tolerance)) {
                            // Do the action associated with the RED region
                            nextImage = R.drawable.whereamilevel7;
                            chrono.stop();
                            showPopup1(level7.this,p,chrono);
                        } else {
                            //...
                        }
                        break;
                } // end switch
                ImageView imageView = (ImageView) findViewById(R.id.image1);
                if (nextImage > 0) {
                    imageView.setImageResource (nextImage);
                    imageView.setTag (nextImage);
                }
                return true;
            }
        });
    }

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        Bitmap original = ((BitmapDrawable) img.getDrawable()).getBitmap();
        Matrix matrix = new Matrix();
        matrix.setRotate(0);
        matrix.postScale(1, 1);
        Bitmap result = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
        /*img.setDrawingCacheEnabled(true);
        Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache(true));
        img.setDrawingCacheEnabled(false);*/
        return result.getPixel(x, y);
    }
    public boolean closeMatch (int color1, int color2, int tolerance) {
        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance )
            return false;
        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance )
            return false;
        if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerance )
            return false;
        return true;
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        int[] location = new int[2];
        TextView textView = (TextView) findViewById(R.id.whint1);
        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        textView.getLocationOnScreen(location);

        //Initialize the Point with x, and y positions
        p = new Point();
        p.x = location[0];
        p.y = location[1];
    }

    // The method that displays the popup.
    private void showPopup(final Activity context, Point p) {
        int popupWidth = 1220;
        int popupHeight = 750;

        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popuptwo);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup7, viewGroup);
        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = 100;
        int OFFSET_Y = 100;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);

        // Getting a reference to Close button, and close the popup when clicked.

    }
    private void showPopup1(final Activity context, Point p, Chronometer chrono) {
        int popupWidth = 1220;
        int popupHeight = 750;

        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.complete, viewGroup);
        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        TextView tv = (TextView)layout.findViewById(R.id.comtime);
        long time = (SystemClock.elapsedRealtime()-chrono.getBase())/1000;
        tv.setText("Time: "+time+"seconds");
        comtim = (int)time;
        Globals g = Globals.getInstance();
        if((g.gettime(6)>comtim)||(g.gettime(6)==0)) {
            g.settime(comtim, 6);
        }
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = 100;
        int OFFSET_Y = 100;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);

        // Getting a reference to Close button, and close the popup when clicked.

    }
}
