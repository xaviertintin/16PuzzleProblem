package com.astar;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI16Puzzle extends JFrame {

    private JPanel panelMain;
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private JTextField txt10;
    private JTextField txt6;
    private JTextField txt7;
    private JTextField txt8;
    private JTextField txt11;
    private JTextField txt12;
    private JTextField txt9;
    private JTextField txt13;
    private JTextField txt14;
    private JTextField txt15;
    private JTextField txt16;
    private JButton btnEnter;
    private JLabel lblTitle;
    //creating new variables for input
    public int[][] c = new int [5][4];

    public GUI16Puzzle() {
        setContentPane(panelMain);
        setTitle("Proyecto Final");
        setSize(635,225);
        setVisible(true);


        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Astars a1=new Astars();
                c=FillArray();
                try {
                    a1.getState(c);
                    a1.display();
                    c=a1.TreeSearch();
                } catch (Exception ex) {
                    System.out.println("Error");
                }

                txt1.setText(Integer.toString(c[0][0]));
                txt2.setText(Integer.toString(c[0][1]));
                txt3.setText(Integer.toString(c[0][2]));
                txt4.setText(Integer.toString(c[0][3]));
                txt5.setText(Integer.toString(c[1][0]));
                txt6.setText(Integer.toString(c[1][1]));
                txt7.setText(Integer.toString(c[1][2]));
                txt8.setText(Integer.toString(c[1][3]));
                txt9.setText(Integer.toString(c[2][0]));
                txt10.setText(Integer.toString(c[2][1]));
                txt11.setText(Integer.toString(c[2][2]));
                txt12.setText(Integer.toString(c[2][3]));
                txt13.setText(Integer.toString(c[3][0]));
                txt14.setText(Integer.toString(c[3][1]));
                txt15.setText(Integer.toString(c[3][2]));
                txt16.setText(Integer.toString(c[3][3]));
            }
        });
    }
    public static void main(String[] arg) throws Exception {
        GUI16Puzzle myFrame = new GUI16Puzzle();
    }
    public int[][] FillArray(){
        int[][] c = new int [5][4];
        c[0][0]=Integer.parseInt(txt1.getText());
        c[0][1]=Integer.parseInt(txt2.getText());
        c[0][2]=Integer.parseInt(txt3.getText());
        c[0][3]=Integer.parseInt(txt4.getText());
        c[1][0]=Integer.parseInt(txt5.getText());
        c[1][1]=Integer.parseInt(txt6.getText());
        c[1][2]=Integer.parseInt(txt7.getText());
        c[1][3]=Integer.parseInt(txt8.getText());
        c[2][0]=Integer.parseInt(txt9.getText());
        c[2][1]=Integer.parseInt(txt10.getText());
        c[2][2]=Integer.parseInt(txt11.getText());
        c[2][3]=Integer.parseInt(txt12.getText());
        c[3][0]=Integer.parseInt(txt13.getText());
        c[3][1]=Integer.parseInt(txt14.getText());
        c[3][2]=Integer.parseInt(txt15.getText());
        c[3][3]=Integer.parseInt(txt16.getText());
        return c;
    }
}
