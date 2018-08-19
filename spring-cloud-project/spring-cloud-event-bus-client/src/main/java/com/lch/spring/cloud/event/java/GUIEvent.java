package com.lch.spring.cloud.event.java;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author: lichanghong on 2018-08-18
 **/
public class GUIEvent {
    public static void main(String[] args) {
        JFrame frame =new JFrame("简单的GUI程序");
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.printf("[%s] 事件:%s\n",Thread.currentThread().getName(),e);
            }
        });
        frame.setBounds(300,300,400,300);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
               System.exit(0);
            }
        });
    }
}
