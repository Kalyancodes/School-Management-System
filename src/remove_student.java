import com.mysql.cj.jdbc.Driver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class remove_student {
    remove_student(){
        JFrame frame= new JFrame();
        frame.setLayout(null);
        frame.setLocation(450,150);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JButton but= new JButton();
        but.setText("Remove Student");
        but.setBounds(350,300,200,30);
        JLabel label1= new JLabel("Username :");
        JLabel label2= new JLabel("Name :");
        JTextField textField1= new JTextField();
        JTextField textField2= new JTextField();
        label1.setBounds(300,100,100,30);
        textField1.setBounds(420,100,100,30);
        label2.setBounds(300,150,100,30);
        textField2.setBounds(420,150,100,30);
        frame.add(label1);
        frame.add(label2);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                a = textField1.getText();
                b = textField2.getText();
                int f=0;

                try {
                      Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                    String sql= "delete from students_list where username=? and Students_name=?";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.setString(1,a);
                    ps.setString(2,b);
                    ps.executeUpdate();

                    String sr = "select * from students_list";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sr);
                    while (rs.next()) {
                        f++;
                    }
                    conn.close();
                    off_staff_view2 p= new off_staff_view2(f);
                    frame.dispose();
                } catch (Exception exception) {

                }
            }

        });

    }
}
