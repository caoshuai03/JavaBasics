package com.sina.crm.syn;

import com.sina.crm.house.utils.Utility;

/**
 * @author caoshuai
 * @version 1.0
 */
public class Synchronized_ {
    public static void main(String[] args) {
        Pint pint = new Pint();
        Control control = new Control(pint);
        new Thread(pint).start();
        new Thread(control).start();
        int[] i={1,2};



    }
}

class Pint implements Runnable {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            int i = (int) (Math.random() * 101);
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Control implements Runnable {
    private Pint pint;

    public Control(Pint pint) {
        this.pint = pint;
    }

    @Override
    public void run() {
        while (true) {
            char key = Utility.readChar();
            if (key == 'Q') {
                //停止线程pint
                this.pint.setLoop(false);
                return;
            }

        }
    }
}
