
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class studentspage {
    studentspage(){

        JButton sbut= new JButton();
        sbut.setText("Login");
        sbut.setBounds(290,350,100,20);

        JLabel label1= new JLabel();
        label1.setText("Username :");
        label1.setBounds(200,200,70,30);
        JLabel label2= new JLabel();
        label2.setText("Password :");
        label2.setBounds(200,250,70,30);
        JTextField user= new JTextField();
        user.setBounds(280,200,120,23);
        JTextField password= new JTextField();
        password.setBounds(280,250,120,23);
        JButton back= new JButton();
        back.setText("Back");
        back.setBounds(290,395,100,20);
        JButton sbut3= new JButton();
        sbut3.setBounds(265,420,150,30);
        sbut3.setText("Change Password");


        JPanel panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0,700,700);
        panel2.add(label1);
        panel2.add(user);
        panel2.add(label2);
        panel2.add(password);
        panel2.add(sbut);
        panel2.add(back);
        panel2.add(sbut3);




        JFrame frame2=new JFrame();
        frame2.setLayout(null);
        frame2.setSize(700,700);
        frame2.setLocationRelativeTo(null);
        frame2.add(panel2);
        frame2.setResizable(false);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==sbut){
                    String userw= user.getText();
                    String pwd=password.getText();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String str="Select * from students_list where username=? and password=?";
                        PreparedStatement pts=conn.prepareStatement(str);
                        pts.setString(1,userw);
                        pts.setString(2,pwd);
                        ResultSet rs=pts.executeQuery();
                        if(rs.next()){
                            String m=rs.getString(5);
                            frame2.dispose();
                            students_view su= new students_view(userw,pwd,m);
                        }

                    }
                    catch (Exception exception){

                    }
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    frame2.dispose();
                    first back2= new first();
                }
            }
        });
        sbut3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==sbut3){
                    frame2.dispose();
                    Change_Password f= new Change_Password(2);
                }
            }
        });
    }
}
