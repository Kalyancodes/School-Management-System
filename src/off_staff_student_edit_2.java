import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class off_staff_student_edit_2 {
    off_staff_student_edit_2(int a, int b,String c) {
        JFrame frame= new JFrame();
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
        JLabel label= new JLabel();
        label.setText("Enter new value");
        JTextField textField= new JTextField();
        label.setBounds(200,250,100,30);
        textField.setBounds(350,250,100,30);
        JButton but= new JButton();
        but.setText("Enter");
        but.setBounds(250,350,100,30);
        frame.add(label);
        frame.add(textField);
        frame.add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but){
                    String f= textField.getText();
                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        if (a == 1) {
                            String sql = "update students_list set Students_name=? where Students_roll_no=? and Students_name=?";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1, f);
                            ps.setInt(2, b);
                            ps.setString(3, c);
                            System.out.println(f);
                            System.out.println(b);
                            System.out.println("waw");
                            ps.executeUpdate();
                            System.out.println("wa");
                            frame.dispose();
                        }
                        if (a == 2) {
                            String sql = "update students_list set Students_class=? where Students_roll_no=? and Students_name=?";
                            PreparedStatement ps1 = conn.prepareStatement(sql);
                            ps1.setString(1, f);
                            ps1.setInt(2, b);
                            ps1.setString(3, c);
                            System.out.println(f);
                            System.out.println(b);
                            System.out.println("waw");
                            ps1.executeUpdate();
                            System.out.println("wa");
                            frame.dispose();
                        }

                        if (a == 3) {
                            int f1= Integer.parseInt(f);
                            String sql = "update students_list set Students_Fee_Balance=? where Students_roll_no=? and Students_name=?";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setInt(1, f1);
                            ps.setInt(2, b);
                            ps.setString(3, c);
                            System.out.println(f);
                            System.out.println(b);
                            System.out.println("waw");
                            ps.executeUpdate();
                            System.out.println("wa");
                            frame.dispose();  }



                        conn.close();

                    }
                            catch (Exception exception) {

                        }
                        try {
                            int f1 = 0;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                            String sr = "select * from students_list";
                            Statement st = conn1.createStatement();
                            ResultSet rs = st.executeQuery(sr);
                            while (rs.next()) {
                                f1++;
                            }

                            off_staff_view2 p = new off_staff_view2(f1);
                        }
                         catch (Exception exception){
                        System.out.println(e);
                    }

                    }


                }


        });

    }
}
