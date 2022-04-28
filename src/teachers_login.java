import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class teachers_login {
        teachers_login(){

            JButton sbut1= new JButton();
            sbut1.setText("Login");
            sbut1.setBounds(290,350,100,20);
            JButton sbut2= new JButton();
            sbut2.setText("Back");
            sbut2.setBounds(290,380,100,20);
            JButton sbut3= new JButton();
            sbut3.setBounds(265,420,150,30);
            sbut3.setText("Change Password");

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


            JPanel panel2= new JPanel();
            panel2.setLayout(null);
            panel2.setBounds(0,0,700,700);
            panel2.add(label1);
            panel2.add(user);
            panel2.add(label2);
            panel2.add(password);
            panel2.add(sbut1);
            panel2.add(sbut2);
            panel2.add(sbut3);




            JFrame frame2=new JFrame();
            frame2.setLayout(null);
            frame2.setSize(700,700);
            frame2.setLocationRelativeTo(null);
            frame2.add(panel2);
            frame2.setResizable(false);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            sbut1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == sbut1) {

                          String userw, pwd;
                          userw=user.getText();
                          pwd=password.getText();

                        try {

                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                            System.out.println("conn");
                            String st = "select * from teachers where username=? and password=?";
                            PreparedStatement sts= conn.prepareStatement(st);
                            sts.setString(1,userw);
                            sts.setString(2, pwd);
                            ResultSet rs= sts.executeQuery();
                            if(rs.next()){
                                String ab=rs.getString(4);
                                int a=rs.getInt(5);
                                JOptionPane op= new JOptionPane();
                                op.showMessageDialog(frame2,"You have Successfully logged in");
                                frame2.dispose();
                                teachers_view viw= new teachers_view(ab,a);
                            }
                            else {
                                JOptionPane el= new JOptionPane();
                                el.showMessageDialog(frame2,"Check your password or username");
                            }
                                conn.close();
                        } catch (Exception exception) {
                            System.out.println(e);

                        }
                    }
                }
            });
            sbut2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==sbut2){
                        frame2.dispose();
                        first back1= new first();
                    }
                }
            });
            sbut3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==sbut3){
                        frame2.dispose();
                        Change_Password c= new Change_Password(1);
                    }
                }
            });



        }
    }


