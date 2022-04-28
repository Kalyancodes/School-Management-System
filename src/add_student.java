import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class add_student {
    add_student(){
        JFrame frame= new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(450,150);
        frame.setSize(800,800);
        frame.setLayout(null);
        JButton but1= new JButton();
        JButton bac= new JButton("Back");
        but1.setText("Add Above Student");
        but1.setBounds(280,450,150,30);
        bac.setBounds(280,500,150,30);
        JLabel label1= new JLabel();
        JLabel label2= new JLabel();
        JLabel label3= new JLabel();
        JLabel label4= new JLabel();
        JTextField textField1= new JTextField();
        JTextField textField2= new JTextField();
        JTextField textField3= new JTextField();
        JTextField textField4= new JTextField();
        label1.setText("Username :");
        label2.setText("Name :");
        label3.setText("Roll No :");
        label4.setText("Class");
        label1.setBounds(200,100,100,30);
        textField1.setBounds(320,100,100,30);
        label2.setBounds(200,170,100,30);
        textField2.setBounds(320,170,100,30);
        label3.setBounds(200,240,100,30);
        textField3.setBounds(320,240,100,30);
        label4.setBounds(200,310, 100,30);
        textField4.setBounds(320,310,100,30);
        JLabel label5= new JLabel();
        label5.setBounds(200,380,100,30);
        label5.setText("Fee Balance");
        JTextField textField5= new JTextField();
        textField5.setBounds(320,380,100,30);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.add(but1);
        frame.add(label5);
        frame.add(textField5);
        frame.add(bac);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but1) {
                    String a = textField1.getText();
                    String b = textField2.getText();
                    int c = Integer.parseInt(textField3.getText());
                    String d = textField4.getText();
                    int f= Integer.parseInt(textField5.getText());
                    int m=0;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql="insert into students_list (username, password, Students_name, Students_roll_no, Students_class,Students_Fee_Balance) values(?,?,?,?,?,?)";
                        PreparedStatement ps= conn.prepareStatement(sql);
                        ps.setString(1,a);
                        ps.setString(2,a);
                        ps.setString(3,b);
                        ps.setInt(4,c);
                        ps.setString(5,d);
                        ps.setInt(6,f);
                        ps.executeUpdate();

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
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bac) {
                    frame.dispose();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn1= DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql="select * from students_list";
                        Statement sts=conn1.createStatement();
                        ResultSet rs2= sts.executeQuery(sql);
                        int o=0;
                        while (rs2.next()){
                            o++;
                        }
                        off_staff_view2 m = new off_staff_view2(o);
                    }
                    catch (Exception exception){

                    }
                }

            }
        });

    }
}
