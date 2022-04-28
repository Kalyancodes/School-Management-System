import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class editteacher {

     editteacher(String m){
        JTextField textField2= new JTextField();
        JTextField textField3= new JTextField();
        JTextField textField4= new JTextField();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            String sql="select * from teachers where username=?";
            PreparedStatement pts=conn.prepareStatement(sql);
            pts.setString(1,m);
            ResultSet rs=pts.executeQuery();
            while (rs.next()){
                textField2.setText(rs.getString(3));
                textField3.setText(rs.getString(4));
                textField4.setText(rs.getString(5));
            }
        }
        catch (Exception exception){}

        JFrame frame= new JFrame();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocation(450,150);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1= new JLabel("username :");
        JLabel labelx= new JLabel(m);
        JLabel label2= new JLabel("Teachers name :");
        JLabel label3= new JLabel("Teachers Class :");
        JLabel label4= new JLabel("No of Stud :");
        label1.setBounds(100,100,100,30);
        labelx.setBounds(250,100,100,30);
        label2.setBounds(100,150,100,30);
        textField2.setBounds(250,150,100,30);
        label3.setBounds(100,200,100,30);
        textField3.setBounds(250,200,100,30);
        label4.setBounds(100,250,100,30);
        textField4.setBounds(250,250,100,30);
        JButton but= new JButton("Enter");
        but.setBounds(200,320,100,30);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(labelx);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but){
                    String a,b,c;
                    a=textField2.getText();
                    b=textField3.getText();
                    c=textField4.getText();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql="update teachers set teachers_name=?,teachers_class=?,no_of_students=? where username=?";
                        PreparedStatement ps= conn.prepareStatement(sql);
                        ps.setString(1,a);
                        ps.setString(2,b);
                        ps.setString(3,c);
                        ps.setString(4,m);
                        ps.executeUpdate();
                        System.out.println("wad");
                        String sql2="select * from teachers";
                        int n=0;
                        System.out.println("wad1");
                        Statement st= conn.createStatement();
                        ResultSet rs=st.executeQuery(sql2);
                        while (rs.next()){
                            System.out.println("wadad");
                            n++;
                        }
                        frame.dispose();
                        office_staff_view1 k= new office_staff_view1(n);
                    }
                    catch (Exception exception){

                    }
                }
            }
        });

    }
}
