import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class removeteacher {
    removeteacher(){
        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setLayout(null);
        frame.setLocation(450,150);
        JLabel label1=new JLabel("Username :");
        JLabel label2= new JLabel("Name :");
        JTextField textField1= new JTextField();
        JTextField textField2= new JTextField();
        label1.setBounds(300,100,100,30);
        textField1.setBounds(450,100,100,30);
        label2.setBounds(300,150,100,30);
        textField2.setBounds(450,150,100,30);
        JButton but= new JButton("Enter");
        but.setBounds(350,250,100,30);
        frame.add(label1);
        frame.add(label2);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but){
                    String a,b;
                    a=textField1.getText();
                    b=textField2.getText();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql="delete from teachers where username=? and teachers_name=?";
                        PreparedStatement ps=conn.prepareStatement(sql);
                        ps.setString(1,a);
                        ps.setString(2,b);
                        ps.executeUpdate();
                        String sql2="select * from teachers";
                        int f=0;
                        Statement st= conn.createStatement();
                        ResultSet rs=st.executeQuery(sql2);
                        while (rs.next()){
                            f++;
                        }
                        frame.dispose();
                        office_staff_view1 al= new office_staff_view1(f);

                    }
                    catch (Exception exception){

                    }
                }
            }
        });
    }
}
