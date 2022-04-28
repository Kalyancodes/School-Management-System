import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Timetable {
       Timetable() {
           JFrame frame = new JFrame();
           frame.setSize(800, 900);
           frame.setVisible(true);
           frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           frame.setLayout(null);
           frame.setLocationRelativeTo(null);
           JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
           JPanel paneli = new JPanel(null);
           Object[][] data1 = new Object[5][5];
           Object[][] data2 = new Object[5][5];
           Object[][] data3 = new Object[5][5];
           Object[][] data4 = new Object[5][5];
           Object[][] data5 = new Object[5][5];
           String[] head = {"Mon", "Tue", "Wed", "Thurs", "Fri"};
           System.out.println("wow");


           paneli.setPreferredSize(new Dimension(675, 2000));

           panel1.add(paneli);
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
               String sql1 = "select * from class1timetable";
               Statement st1 = conn.createStatement();
               ResultSet rs1;
               rs1 = st1.executeQuery(sql1);
               int a1 = 0;
               while (rs1.next()) {
                   data1[a1][0] = rs1.getString(1);
                   data1[a1][1] = rs1.getString(2);
                   data1[a1][2] = rs1.getString(3);
                   data1[a1][3] = rs1.getString(4);
                   data1[a1][4] = rs1.getString(5);
                   a1++;
               }
               conn.close();
               Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
               String sql2 = "select * from class2timetable";
               Statement st2 = conn1.createStatement();
               ResultSet rs2;
               int a2 = 0;
               rs2 = st2.executeQuery(sql2);
               while (rs2.next()) {
                   data2[a2][0] = rs2.getString(1);
                   data2[a2][1] = rs2.getString(2);
                   data2[a2][2] = rs2.getString(3);
                   data2[a2][3] = rs2.getString(4);
                   data2[a2][4] = rs2.getString(5);
                   a2++;
               }
               conn1.close();

               Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
               String sql3 = "select * from class3timetable";
               int a3 = 0;
               Statement st3 = conn2.createStatement();
               ResultSet rs3;
               rs3 = st3.executeQuery(sql3);
               while (rs3.next()) {
                   data3[a3][0] = rs3.getString(1);
                   data3[a3][1] = rs3.getString(2);
                   data3[a3][2] = rs3.getString(3);
                   data3[a3][3] = rs3.getString(4);
                   data3[a3][4] = rs3.getString(5);
                   a3++;
               }
               conn2.close();

               Connection conn3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
               String sql4 = "select * from class4timetable";
               Statement st4 = conn3.createStatement();
               ResultSet rs4;
               int a4 = 0;
               rs4 = st4.executeQuery(sql4);
               while (rs4.next()) {
                   data4[a4][0] = rs4.getString(1);
                   data4[a4][1] = rs4.getString(2);
                   data4[a4][2] = rs4.getString(3);
                   data4[a4][3] = rs4.getString(4);
                   data4[a4][4] = rs4.getString(5);
                   a4++;
               }
               conn3.close();
               Connection conn4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
               String sql5 = "select * from class5timetable";
               Statement st5 = conn4.createStatement();
               ResultSet rs5;
               int a5 = 0;
               rs5 = st5.executeQuery(sql5);
               while (rs5.next()) {
                   data5[a5][0] = rs5.getString(1);
                   data5[a5][1] = rs5.getString(2);
                   data5[a5][2] = rs5.getString(3);
                   data5[a5][3] = rs5.getString(4);
                   data5[a5][4] = rs5.getString(5);
                   a5++;
               }
               System.out.println("wow");

               conn4.close();

           } catch (Exception exception) {

           }
           JTable table1 = new JTable(data1, head);
           JTable table2 = new JTable(data2, head);
           JTable table3 = new JTable(data3, head);
           JTable table4 = new JTable(data4, head);
           JTable table5 = new JTable(data5, head);
           JScrollPane scrollPane1 = new JScrollPane(table1);
           scrollPane1.setLayout(new ScrollPaneLayout());
           JScrollPane scrollPane2 = new JScrollPane(table2);
           scrollPane2.setLayout(new ScrollPaneLayout());
           JScrollPane scrollPane3 = new JScrollPane(table3);
           scrollPane3.setLayout(new ScrollPaneLayout());
           JScrollPane scrollPane4 = new JScrollPane(table4);
           scrollPane4.setLayout(new ScrollPaneLayout());
           JScrollPane scrollPane5 = new JScrollPane(table5);
           scrollPane5.setLayout(new ScrollPaneLayout());
           table1.setRowHeight(40);
           table2.setRowHeight(40);
           table3.setRowHeight(40);
           table4.setRowHeight(40);
           table5.setRowHeight(40);
           JLabel label1 = new JLabel("Class 1 Timetable");
           JLabel label2 = new JLabel("Class 2 Timetable");
           JLabel label3 = new JLabel("Class 3 Timetable");
           JLabel label4 = new JLabel("Class 4 Timetable");
           JLabel label5 = new JLabel("Class 5 Timetable");
           scrollPane1.setBounds(0, 100, 680, 250);
           label1.setBounds(330, 30, 200, 50);
           label2.setBounds(330, 430, 200, 50);
           label3.setBounds(330, 830, 200, 50);
           label4.setBounds(330, 1230, 200, 50);
           label5.setBounds(330, 1630, 200, 50);
           scrollPane2.setBounds(0, 500, 680, 250);
           scrollPane3.setBounds(0, 900, 680, 250);
           scrollPane4.setBounds(0, 1300, 680, 250);
           scrollPane5.setBounds(0, 1700, 680, 250);
           paneli.add(scrollPane1);
           paneli.add(scrollPane2);
           paneli.add(scrollPane3);
           paneli.add(scrollPane4);
           paneli.add(scrollPane5);
           paneli.add(label1);
           paneli.add(label2);
           paneli.add(label3);
           paneli.add(label4);
           paneli.add(label5);
           JScrollPane scrollPane = new JScrollPane(panel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
           scrollPane.setLayout(new ScrollPaneLayout());
           scrollPane.setBounds(50, 50, 700, 700);
           frame.add(scrollPane);
           JButton but = new JButton("Back");
           but.setBounds(350, 800, 100, 30);
           frame.add(but);
           but.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   frame.dispose();
                   office_Staff_view t= new office_Staff_view();
               }
           });

       }
}

