package com.yahia.moda;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JTree;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;


public class main_window {


    public static void main(String[] args) {
        Process_instance p1 = new Process_instance("p1", 0, 6, 3);
        Process_instance p2 = new Process_instance("p2", 1, 6, 1);
        Process_instance p3 = new Process_instance("p3", 2, 9, 3);
        //Process_instance p4 = new Process_instance("p4", 3, 3,4);
        //Process_instance p5 = new Process_instance("p5", 4, 2,2);
        LinkedList<Process_instance> process_list = new LinkedList<>(List.of(p1, p2, p3));
        process_list.add(p1);
        process_list.add(p2);
        process_list.add(p3);
        //process_list.add(p4);
        //process_list.add(p5);
       // System.out.println( process_list.toString());
        Scheduling_result result = new Scheduling_result();
        Process_group pg = new Process_group(process_list, new RoundRobin(3), result, true);
        System.out.println(result);
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
