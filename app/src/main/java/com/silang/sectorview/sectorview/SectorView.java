package com.silang.sectorview.sectorview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 12457 on 2017/9/4.
 */

public class SectorView extends View {

    private Context context;

    public SectorView(Context context) {
        this(context, null, 0);
    }

    public SectorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setAntiAlias(true);
        Shader shader = new LinearGradient(0, 0, getWidth(), 0, new int[]{ContextCompat.getColor(context, R.color.colorStatusBarStart),
                ContextCompat.getColor(context, R.color.colorStatusBarEnd)}, null, Shader.TileMode.CLAMP);


        p.setShader(shader);

        int x = getHeight()/2;
        float r = (float) CalculationTool.div(
                (x*x + CalculationTool.div(getWidth() * getWidth(), 4))
                ,
                2 * x
        );



        canvas.drawCircle(getWidth() / 2, getHeight()-r, r, p);
    }
}
