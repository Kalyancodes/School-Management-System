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

public class officestaffpage {
    officestaffpage(){

        JButton sbut= new JButton();
        sbut.setText("Login");
        sbut.setBounds(290,350,100,30);

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
        JButton sbut3= new JButton();
        sbut3.setBounds(280,410,150,30);
        sbut3.setText("Change Password");
        JButton bu= new JButton("Back");
        bu.setBounds(280,470,150,30);


        JPanel panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0,0,700,700);
        panel2.add(label1);
        panel2.add(user);
        panel2.add(label2);
        panel2.add(password);
        panel2.add(sbut);
        panel2.add(sbut3);
        panel2.add(bu);




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
                     try{
                         String user1= user.getText();
                         String pass= password.getText();
                         Class.forName("com.mysql.cj.jdbc.Driver");
                         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                         String c= "select * from officestafflist where username=? and password=?";
                         PreparedStatement ps=conn.prepareStatement(c);
                         ps.setString(1,user1);
                         ps.setString(2,pass);
                         ResultSet rs=ps.executeQuery();
                         if(rs.next()){
                             JOptionPane op=new JOptionPane();
                             op.showMessageDialog(frame2,"You have successfully logged in");
                             frame2.dispose();
                             office_Staff_view p= new office_Staff_view();



                         }
                     }
                     catch (Exception exception){
                         System.out.println(e);
                     }
                 }

             }
         });
         sbut3.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==sbut3){
                     frame2.dispose();
                     Change_Password l= new Change_Password(3);
                 }
             }
         });
         bu.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame2.dispose();
                 first a= new first();
             }
         });

    }
}

