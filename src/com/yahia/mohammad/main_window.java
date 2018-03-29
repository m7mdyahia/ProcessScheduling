package com.yahia.mohammad;

import com.yahia.mohammad.algorithms.RoundRobin;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;


public class main_window {


    public static void main(String[] args) {
        ProcessInstance p1 = new ProcessInstance("p1", 0, 6, 3);
        ProcessInstance p2 = new ProcessInstance("p2", 1, 6, 1);
        ProcessInstance p3 = new ProcessInstance("p3", 2, 9, 3);
        ProcessInstance p4 = new ProcessInstance("p4", 3, 3, 4);
        ProcessInstance p5 = new ProcessInstance("p5", 4, 2, 2);
        ProcessGroup pg = new ProcessGroup(
                new LinkedList<>(List.of(p1, p2, p3, p4, p5)),
                new RoundRobin(3),
                true);
        System.out.println(pg.getResult());
    }

    private JFrame frmProcessSchedulingSimulator;
    private JPanel panel;

    /**
     * Launch the application.
     *
     * @wbp.parser.entryPoint
     */
    public static void main2(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main_window window = new main_window();
                    window.frmProcessSchedulingSimulator.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public main_window() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmProcessSchedulingSimulator = new JFrame();
        frmProcessSchedulingSimulator.setIconImage(Toolkit.getDefaultToolkit().getImage(main_window.class.getResource("/resources/kcm-processor-icon.png")));
        frmProcessSchedulingSimulator.setTitle("Process Scheduling Simulator");
        frmProcessSchedulingSimulator.setBounds(100, 100, 626, 423);
        frmProcessSchedulingSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gui = new JPanel();
        frmProcessSchedulingSimulator.getContentPane().add(panel, BorderLayout.CENTER);
    }

}
