package com.example.canvas2;


import android.content.*;
import android.graphics.*;
import android.util.Log;
import android.view.View;
public class Lienzo extends View{
    Paint p;
    Path r;
    int x, y, x0, y0;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c){
        super.onDraw(c); // Canvas pinta atributos
        p = new Paint(); // Paint asigna atributos
        r = new Path();
        x = c.getWidth(); x0=x/2; // También: getMeasuredWidth(), o getRight(), x=480
        y = c.getHeight(); y0=y/2; // También: getMeasuredHeight(), o getBottom(), y=762
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.BLACK); // Texto negro
        p.setTextSize(40);
        c.drawText("0,0", x0 + 5, y0 + 20, p);
        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x0, 0, x0, y, p);
        c.drawLine(0, y0, x, y0, p);
        p.setColor(Color.BLUE); c.drawText("senA", 20, 40, p);
        p.setColor(Color.RED); c.drawText("cosA", 20, 70, p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);
        p.setAntiAlias(true);
        r = new Path();
        x = getMeasuredWidth();
        r.moveTo(0, 0);
        p.setColor(Color.BLUE);
        float top = 0, bottom = 0;
        float cont = 0;
        for(int i=1; i<x; i++) {
            cont=3*(float) Math.sin(i / 100f) * (-150f);
            r.lineTo(i, cont);
            if(cont > top) top = cont;
            if(cont < bottom) bottom = cont;
        }
        //puntos en x y mAGNITUD
        r.offset(-10, y0); c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.BLUE);
        for (float i=1; i < x; i++){
            float y = 3*(float) Math.sin(i / 100f) * (-150f);
            if(y < 4 && y > -4) c.drawCircle( i-10,y0,7,p);
            r.lineTo( i, top);
        }
        c.drawText("Y:"+top,(x/2)-100, (y0)-top ,p);
        //magnitud positiva
        r.offset(-10, y0); c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.BLUE);
        for (float i=1; i < x; i++) r.lineTo( i, bottom);

        c.drawText("Y:"+bottom,(x/2)-100, (y0)-bottom ,p);

        //-------------COSENO---------------
        r.offset(-10, y0); c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.RED);
        top = 0; bottom = 0; cont = 0;
        for(int i=1; i<x; i++){
            cont= 2*(float) Math.cos(i / 120f) * (-100f);
            r.lineTo(i, cont);
            if(cont > top) top = cont;
            if(cont < bottom) bottom = cont;
        }
        //puntos en x y mAGNITUD
        r.offset(-10, y0); c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.RED);
        for (float i=1; i < x; i++){
            float y = 2*(float) Math.cos(i / 120f) * (-100f);
            if(y < 4 && y > -4) c.drawCircle( i-10,y0,7,p);
            r.lineTo( i, top);
        }
        c.drawText("Y:"+top,(x/2)-100, (y0)-top ,p);
        //magnitud positiva
        r.offset(-10, y0); c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.RED);
        for (float i=1; i < x; i++) r.lineTo( i, bottom);
        c.drawText("Y:"+bottom,(x/2)-100, (y0)-bottom ,p);
        r.offset(-10, y0);
        c.drawPath(r, p);
    }
}