import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class off_staff_student_edit {
    off_staff_student_edit(String C) {
        String ux,n,c;
        int r,m;
        JLabel labelx1= new JLabel();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();
        JTextField textField4 = new JTextField();
        JTextField textField5 = new JTextField();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            String sql="select * from students_list where username=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,C);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                ux=rs.getString(1);
                n=rs.getString(3);
                c=rs.getString(5);
                r=rs.getInt(4);
                m=rs.getInt(6);
                String w= ""+r;
                String f=""+m;
                labelx1.setText(ux);
                textField2.setText(n);
                textField3.setText(w);
                textField4.setText(c);
                textField5.setText(f);
            }
        }
        catch (Exception exception){

        }
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(450, 150);
        frame.setSize(800, 800);
        frame.setLayout(null);
        JButton but1 = new JButton();
        but1.setText("Ok");
        JButton back= new JButton("Back");
        but1.setBounds(280, 450, 150, 30);
        back.setBounds(280,500,150,30);
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();

        label1.setText("Username :");
        label2.setText("Name :");
        label3.setText("Roll No :");
        label4.setText("Class");
        label1.setBounds(200, 100, 100, 30);
        labelx1.setBounds(320, 100, 100, 30);
        label2.setBounds(200, 170, 100, 30);
        textField2.setBounds(320, 170, 100, 30);
        label3.setBounds(200, 240, 100, 30);
        textField3.setBounds(320, 240, 100, 30);
        label4.setBounds(200, 310, 100, 30);
        textField4.setBounds(320, 310, 100, 30);
        JLabel label5 = new JLabel();
        label5.setBounds(200, 380, 100, 30);
        label5.setText("Fee Balance");

        textField5.setBounds(320, 380, 100, 30);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(labelx1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.add(but1);
        frame.add(label5);
        frame.add(textField5);
        frame.add(back);

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but1) {
                    String a,b;
                    int c,d;
                    a=textField2.getText();
                    c=Integer.parseInt(textField3.getText());
                    b=textField4.getText();
                    d=Integer.parseInt(textField5.getText());

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql="update students_list set Students_name=?, Students_roll_no=? , Students_class=?, Students_Fee_Balance=? where username=?";
                        PreparedStatement ps=conn.prepareStatement(sql);
                        ps.setString(1,a);
                        ps.setInt(2,c);
                        ps.setString(3,b);
                        ps.setInt(4,d);
                        ps.setString(5,C);
                        ps.executeUpdate();
                        int m=0;
                        String sr="select * from students_list";
                        Statement st=conn.createStatement();
                        ResultSet rs= st.executeQuery(sr);
                        while (rs.next()){
                            m++;
                        }
                        off_staff_view2 p= new off_staff_view2(m);
                        frame.dispose();


                    } catch (Exception exception) {

                    }
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn1= DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                    String sql="select * from students_list";
                    Statement sts=conn1.createStatement();
                    ResultSet rts=sts.executeQuery(sql);
                    int o=0;
                    while (rts.next()){
                        o++;
                    }
                    frame.dispose();
                    off_staff_view2 m=new off_staff_view2(o);
                }
                catch (Exception exception){

                }
            }
        });
    }
}