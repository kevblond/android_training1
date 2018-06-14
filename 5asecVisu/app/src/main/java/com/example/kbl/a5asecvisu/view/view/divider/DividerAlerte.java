package com.example.kbl.a5asecvisu.view.view.divider;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerAlerte extends RecyclerView.ItemDecoration {
    private final Paint paint;
    private final int alpha;
    private boolean showFirstDivider;
    private boolean showLastDivider;

    public DividerAlerte(@ColorInt int color, float width) {
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(width);
        alpha = paint.getAlpha();
        this.showFirstDivider = false;
        this.showLastDivider = true;
    }

    public DividerAlerte(@ColorInt int color, float width, boolean showFirstDivider, boolean showLastDivider) {
        this(color,width);
        this.showFirstDivider = showFirstDivider;
        this.showLastDivider = showLastDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

        // we retrieve the position in the list
        final int position = params.getViewAdapterPosition();

        if(position == 0 && !showFirstDivider){
            return;
        }
        // add space for the separator to the bottom of every view but the last one
        outRect.set(0, (int) paint.getStrokeWidth(), 0, 0); // left, top, right, bottom
        if(showLastDivider && position==(state.getItemCount()-1)){
            outRect.set(0,0,0,(int)paint.getStrokeWidth());
        }
    }
    
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        // a line will draw half its size to top and bottom,
        // hence the offset to place it correctly
        final int offset = (int) (paint.getStrokeWidth() / 2);

        // this will iterate over every visible view
        for (int i = showFirstDivider? 0 : 1; i < parent.getChildCount(); i++) {
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

            // get the position
            final int position = params.getViewAdapterPosition();

            // and finally draw the separator
            if (position < state.getItemCount()) {
                // apply alpha to support animations
                paint.setAlpha((int) (view.getAlpha() * alpha));

                float positionY = view.getBottom() + offset + view.getTranslationY();
                // do the drawing
                c.drawLine(view.getLeft(),
                        positionY,
                        view.getRight(),
                        positionY,
                        paint);
                positionY = view.getTop() - offset + view.getTranslationY();
                c.drawLine(view.getLeft(),positionY,view.getRight(),positionY,paint);
            }
        }
    }
}
