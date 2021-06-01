package com.day;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class pay {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pay window = new pay();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public pay() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.RED);
        frame.setBackground(Color.WHITE);
        frame.setBounds(60, 60, 634, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 56, 620, 627);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("\uCDE8\uC18C");
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setBounds(119, 508, 146, 94);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\uC2B9\uC778\uC694\uCCAD");
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBackground(Color.RED);
        btnNewButton_1.setBounds(372, 508, 146, 94);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("\uB2E4\uC74C \uADF8\uB9BC\uACFC \uAC19\uC774 \uACB0\uC81C\uD55C \uC2E0\uC6A9/\uCCB4\uD06C \uCE74\uB4DC\uB974 \uB123\uC5B4\uC8FC\uC138\uC694.");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(12, 10, 596, 68);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(69, 331, 498, 42);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("\uCD1D\uACB0\uC81C\uAE08\uC561:");
        lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_3.setBounds(12, 0, 125, 42);
        panel_1.add(lblNewLabel_3);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(Color.WHITE);
        panel_1_1.setBounds(69, 379, 498, 42);
        panel.add(panel_1_1);
        panel_1_1.setLayout(null);

        JLabel lblNewLabel_3_1 = new JLabel("\uD560\uBD80\uAC1C\uC6D4:");
        lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_3_1.setBounds(12, 0, 98, 42);
        panel_1_1.add(lblNewLabel_3_1);

        JPanel panel_1_2 = new JPanel();
        panel_1_2.setBounds(69, 431, 498, 42);
        panel.add(panel_1_2);
        panel_1_2.setLayout(null);

        JLabel lblNewLabel_3_2 = new JLabel("\uCE74\uB4DC\uBC88\uD638:");
        lblNewLabel_3_2.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_3_2.setBounds(12, 0, 94, 42);
        panel_1_2.add(lblNewLabel_3_2);

//      JPanel panel_2 = new JPanel();
//      panel_2.setBounds(146, 57, 347, 258);
//      panel.add(panel_2);
//      panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("\uCE74\uB4DC\uACB0\uC81C");
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(187, 0, 269, 57);
        frame.getContentPane().add(lblNewLabel_2);

        ImageIcon image1;
        image1 = new ImageIcon("./IMAGE/PAY.png");
        Image img = image1.getImage();
        Image changImg = img.getScaledInstance(347, 258, Image.SCALE_SMOOTH);
        ImageIcon changIcon = new ImageIcon(changImg);
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(230, 230, 250));
        panel_2.setBounds(146, 57, 347, 258);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);
        JLabel label_Logo = new JLabel(changIcon);
        label_Logo.setBounds(146, 57, 347, 258);
        panel.add(label_Logo);
        label_Logo.setVerticalTextPosition(JLabel.CENTER);
        label_Logo.setHorizontalTextPosition(JLabel.RIGHT);
        label_Logo.setVisible(true);
    }
}