package com.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame{

    Image plane = GameUtil.getImage("image/plane.png");
    Image bg = GameUtil.getImage("image/bg.png");

    static int count = 0;

    static int planeX = 100;

    @Override
    public void paint(Graphics g){
        System.out.println("count=" + count++);
        Color c = g.getColor();
//        g.setColor(Color.RED);
        /*g.setColor(new Color(0,255,255));
        g.drawLine(100, 100, 300, 300);
        g.drawRect(100, 100, 300, 200);
        g.drawOval(100, 100, 300, 200);
        g.drawString("xinfengchen", 300, 200);*/

        g.drawImage(bg, 0, 0, 500, 500, null);
        g.drawImage(plane, planeX, 100, 22, 23, null);
        planeX += 1;

        g.setColor(c);
    }

    public void launchFrame(){
        this.setTitle("plane war");

        setVisible(true);               // the window is visible

        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);      // the size of window

        setLocation(400, 400);      // the location of window

        // add the action of closing window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                System.exit(0);     // exit program normally
            }
        });

        new PaintTread().start();
    }

    class PaintTread extends Thread{
        @Override
        public void run(){
            while(true){
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        MyGameFrame gameFrame = new MyGameFrame();
        gameFrame.launchFrame();
    }
}
