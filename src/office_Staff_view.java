import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class office_Staff_view {
    office_Staff_view(){
        JFrame fr= new JFrame();
        JButton Teachers= new JButton();
        Teachers.setFocusable(false);
        JButton Students= new JButton();
        Students.setFocusable(false);
        JButton Time= new JButton();
        Time.setFocusable(false);
        JButton bac= new JButton("Back");
        Teachers.setText("Teachers List");
        Teachers.setBounds(275,100,150,40);
        Students.setText("Students List");
        Students.setBounds(275,200,150,40);
        Time.setText("Time Table");
        Time.setBounds(275,300,150,40);
        bac.setBounds(275,400,150,40);
        fr.setSize(700,600);
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.add(Teachers);
        fr.add(Students);
        fr.add(Time);
        fr.add(bac);

        Students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Students){
                int f=0;
                try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sr="select * from students_list";
                        Statement st=conn.createStatement();
                        ResultSet rs= st.executeQuery(sr);
                        while (rs.next()){
                           f++;
                        }
                    }
                    catch (Exception exception){
                        System.out.println(e);
                    }
                    fr.dispose();
                off_staff_view2 p= new off_staff_view2(f);
            }
            }
        });
        Teachers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Teachers){
                    int f=0;
                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sr="select * from teachers";
                        Statement st=conn.createStatement();
                        ResultSet rs= st.executeQuery(sr);
                        while (rs.next()){
                            f++;
                        }
                    }
                    catch (Exception exception){
                        System.out.println(e);
                    }
                    fr.dispose();
                    office_staff_view1 a= new office_staff_view1(f);

                }

            }
        });
        Time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==Time){
                     fr.dispose();
                     Timetable t= new Timetable();
                 }
            }
        });
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bac){
                    fr.dispose();
                    officestaffpage m= new officestaffpage();
                }
            }
        });

    }
}
