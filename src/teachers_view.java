import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class teachers_view {
    teachers_view(String a, int w) {
        String c = a;
        int i = 0;
        int j=0;
        int f = w;
        Object[][] data1 = new Object[f][4];
        Object[][] data2= new Object[5][5];
        JFrame fram = new JFrame();
        fram.setVisible(true);
        fram.setResizable(false);
        fram.setLayout(null);
        fram.setSize(1000, 1000);
        fram.setLocationRelativeTo(null);
        fram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            System.out.println("connected successfully");
            String str = "select * from students_list where Students_class=?";
            PreparedStatement pts=conn.prepareStatement(str);
            pts.setString(1,c);
            System.out.println("successfully updated");
            ResultSet rs;
            rs = pts.executeQuery();
            while (rs.next()) {
                data1[i][0] = rs.getString(3);
                data1[i][1] = rs.getInt(4);
                data1[i][2]=rs.getString(5);
                data1[i][3]=rs.getInt(6);

                i = i + 1;
            }

          /*  Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@."); */
          System.out.println("again");
            String st="select * from ";
            String ac="class";
            String ad="timetable";
            String af= ac+c+ad;
            String am=st+af;
             Statement psa=conn.createStatement();
            ResultSet rs1=psa.executeQuery(am);
            while (rs1.next()){
                data2[j][0]=rs1.getString(1);
                data2[j][1]=rs1.getString(2);
                data2[j][2]=rs1.getString(3);
                data2[j][3]=rs1.getString(4);
                data2[j][4]=rs1.getString(5);
                j++;
            }
          System.out.println(af);
            conn.close();


        } catch (Exception e) {
            System.out.println(e);

        }
        String[] head= {"Students name", "Students roll no", "Students Class", "Fees to be paid"};
        JTable table= new JTable(data1,head);
        JScrollPane scrollPane= new JScrollPane(table);
        table.setPreferredSize(new Dimension(300,300));
        table.setRowHeight(59);
        scrollPane.createVerticalScrollBar();
        scrollPane.createVerticalScrollBar();
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBounds(50,100,800,300);
        fram.add(scrollPane);
        String[] head2={ "Mon", "Tue", "Wed", "Thurs"," Fri"};
        JTable table1= new JTable(data2, head2);
        table1.setPreferredSize(new Dimension(300,300));
        table1.setRowHeight(59);
        JScrollPane scrollPane1= new JScrollPane(table1);
        scrollPane1.createHorizontalScrollBar();
        scrollPane1.createVerticalScrollBar();
        scrollPane1.setLayout(new ScrollPaneLayout());
        scrollPane1.setBounds(50,450,800,300);
         fram.add(scrollPane1);
         JButton but= new JButton();
         but.setBounds(400,850,80,40);
         but.setText("Back");
         fram.add(but);
         but.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==but){
                     fram.dispose();
                     teachers_login teac= new teachers_login();
                 }
             }
         });


    }
    }
