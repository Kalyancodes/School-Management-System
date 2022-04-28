import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addteacher {
    addteacher() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setLocation(450, 100);
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Username :");
        JTextField textField1 = new JTextField();
        JLabel label2 = new JLabel("Name :");
        JTextField textField2 = new JTextField();
        JLabel label3 = new JLabel("Teachers Class :");
        JTextField textField3 = new JTextField();
        JLabel label4 = new JLabel("No of Students :");
        JTextField textField4 = new JTextField();
        label1.setBounds(200, 100, 120, 30);
        textField1.setBounds(350, 100, 120, 30);
        label2.setBounds(200, 150, 120, 30);
        textField2.setBounds(350, 150, 120, 30);
        label3.setBounds(200, 200, 120, 30);
        textField3.setBounds(350, 200, 120, 30);
        label4.setBounds(200, 250, 120, 30);
        textField4.setBounds(350, 250, 120, 30);
        JButton but = new JButton("Enter");
        JButton bac = new JButton("Back");
        but.setBounds(260, 300, 100, 30);
        bac.setBounds(260, 350, 100, 30);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.add(but);
        frame.add(bac);


        but.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but) {

                    String a, b, c, d;
                    a = textField1.getText();
                    b = textField2.getText();
                    c = textField3.getText();
                    d = textField4.getText();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql = "insert into teachers (username, password, teachers_name, teachers_class, no_of_students) values(?,?,?,?,?)";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, a);
                        ps.setString(2, a);
                        ps.setString(3, b);
                        ps.setString(4, c);
                        ps.setString(5, d);
                        ps.executeUpdate();
                        System.out.println("wad");
                        int l = 0;
                        String sql2 = "select * from teachers";
                        Statement st = conn.createStatement();
                        ResultSet rs;
                        rs = st.executeQuery(sql2);
                        while (rs.next()) {
                            l++;
                        }
                        frame.dispose();
                        office_staff_view1 m = new office_staff_view1(l);
                    } catch (Exception exception) {

                    }
                }
            }
        });
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == bac) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        int l = 0;
                        String sql2 = "select * from teachers";
                        Statement st = conn1.createStatement();
                        ResultSet rs;
                        rs = st.executeQuery(sql2);
                        while (rs.next()) {
                            l++;
                        }
                        frame.dispose();
                        office_staff_view1 m = new office_staff_view1(l);

                    } catch (Exception exception) {

                    }
                }
            }

        });
    }
}

