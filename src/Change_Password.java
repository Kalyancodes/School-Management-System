import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Change_Password {
    Change_Password(int x){
        JFrame frame= new JFrame();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(300,100);
        frame.setSize(700,700);
        JLabel label1= new JLabel();
        label1.setText("Username :");
        label1.setBounds(200,200,70,30);
        JLabel label2= new JLabel();
        label2.setText("Password :");
        label2.setBounds(200,250,70,30);
        JTextField user= new JTextField();
        user.setBounds(350,200,120,23);
        JTextField password= new JTextField();
        password.setBounds(350,250,120,23);
        JLabel label3= new JLabel();
        label3.setText("New Password :");
        JLabel label4= new JLabel();
        label4.setText("Confirm New Password :");
        JTextField new1= new JTextField();
        JTextField cnew= new JTextField();
        label3.setBounds(200,300,150,30);
        label4.setBounds(200,350,150,30);
        new1.setBounds(350,300,120,23);
        cnew.setBounds(350,350,120,23);
        JButton but= new JButton();
        but.setText("OK");
        but.setBounds(360,390,100,30);
        but.setFocusable(false);

        JPanel panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0,700,700);
        panel2.add(label1);
        panel2.add(user);
        panel2.add(label2);
        panel2.add(password);
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(new1);
        panel2.add(cnew);
        panel2.add(but);
        frame.add(panel2);

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but){

                    String userw= user.getText();
                    String pwd= password.getText();
                    String pwdn= new1.getText();
                    String pwdc= cnew.getText();
                    if(!(pwdc.equals(pwdn))){
                        JOptionPane op1= new JOptionPane();
                        op1.showMessageDialog(frame,"Your passwords do not match");
                    }
                    if(x==1 && pwdn.equals(pwdc)) {
                        System.out.println("wo");

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                            String sql = "UPDATE teachers SET password=? where username=? and password=?";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1, pwdn);
                            ps.setString(2, userw);
                            ps.setString(3, pwd);
                            ps.executeUpdate();
                            System.out.println("done");
                            String sql1 = "select * from teachers where username=? and password=?";
                            PreparedStatement pts = conn.prepareStatement(sql1);
                            pts.setString(1, userw);
                            pts.setString(2, pwdn);
                            ResultSet rs = pts.executeQuery();
                            if (!(rs.next())) {
                                JOptionPane op = new JOptionPane();
                                op.showMessageDialog(frame, "Username and Password do not belong to same account");
                            }
                            else {
                                JOptionPane op1= new JOptionPane();
                                op1.showMessageDialog(frame,"Password Successfully changed");
                                frame.dispose();
                                teachers_login t= new teachers_login();
                            }

                        } catch (Exception exception) {
                            System.out.println(e);
                        }
                    }

                    if(x==2 && pwdn.equals(pwdc)) {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                            String sql = "UPDATE students_list SET password=? where username=? and password=?";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1, pwdn);
                            ps.setString(2, userw);
                            ps.setString(3, pwd);
                            ps.executeUpdate();
                            System.out.println("done");
                            String sql1 = "select * from students_list where username=? and password=?";
                            PreparedStatement pts = conn.prepareStatement(sql1);
                            pts.setString(1, userw);
                            pts.setString(2, pwdn);
                            ResultSet rs = pts.executeQuery();
                            System.out.println("wa");
                            if (!(rs.next())) {
                                JOptionPane op = new JOptionPane();
                                op.showMessageDialog(frame, "Username and Password do not belong to same account");
                            }
                            else{
                                JOptionPane op1= new JOptionPane();
                                op1.showMessageDialog(frame,"Password Successfully changed");
                                frame.dispose();
                                studentspage s= new studentspage();
                            }

                        } catch (Exception exception) {
                            System.out.println(e);
                        }
                    }

                        if(x==3 && pwdn.equals(pwdc)){
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                                String sql="UPDATE officestafflist SET password=? where username=? and password=?";
                                PreparedStatement ps= conn.prepareStatement(sql);
                                ps.setString(1,pwdn);
                                ps.setString(2,userw);
                                ps.setString(3,pwd);
                                ps.executeUpdate();
                                System.out.println("done");
                                String sql1="select * from officestafflist where username=? and password=?";
                                PreparedStatement pts=conn.prepareStatement(sql1);
                                pts.setString(1,userw);
                                pts.setString(2,pwdn);
                                ResultSet rs=pts.executeQuery();
                                if(!(rs.next())){
                                    JOptionPane op=new JOptionPane();
                                    op.showMessageDialog(frame,"Username and Password do not belong to same account");
                                }
                                else{
                                    JOptionPane op1= new JOptionPane();
                                    op1.showMessageDialog(frame,"Password Successfully changed");
                                    frame.dispose();
                                    officestaffpage op= new officestaffpage();
                                }

                            }
                            catch (Exception exception){
                                System.out.println(e);
                            }
                        }


                    }

                }

        });

        }
    }


