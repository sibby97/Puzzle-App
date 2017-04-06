package com.example.android.puzzle;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = (TextView) findViewById(R.id.quest1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t = (TextView) findViewById(R.id.whint1);
                t.setVisibility(View.VISIBLE);
                if(t.getVisibility() == View.VISIBLE){
                    t.setVisibility(View.INVISIBLE);
                }
            }
        });

        ImageView img = (ImageView) findViewById(R.id.image);
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
                        int touchColor = getHotspotColor (R.id.image_areas, evX, evY);
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
                        if (closeMatch (Color.parseColor("#A349A4"), touchColor, tolerance)) {
                            // Do the action associated with the RED region
                            nextImage = R.drawable.whereamilevel1;
                        } else {
                            //...
                        }
                        break;
                } // end switch
                ImageView imageView = (ImageView) findViewById(R.id.image);
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
        img.setDrawingCacheEnabled(true);
        Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);
        return hotspots.getPixel(x, y);
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
}
