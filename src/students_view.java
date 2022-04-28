import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class students_view {
    students_view(String a, String b, String c){
        JFrame fra= new JFrame();
        String alu=a;
        String balu=b;
        String al;
        fra.setLocation(340,0);
        fra.setSize(1000,1000);
        fra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fra.setResizable(false);
        fra.setVisible(true);
        fra.setLayout(null);
        JButton bac= new JButton();
        bac.setText("Back");
        bac.setBounds(500,890,100,30);

        Object[][] data= new Object[5][5];
        Object[][] data2= new Object[1][4];
        int i=0;
        int j=0;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            String sql="Select * from students_list where username =? and password=? ";
            System.out.println("connected successfully");
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,alu);
            ps.setString(2,balu);
            ResultSet rs1;
            rs1= ps.executeQuery();
            while (rs1.next()){
                data2[0][0]=rs1.getString(3);
                data2[0][1]=rs1.getInt(4);
                data2[0][2]=rs1.getString(5);
                data2[0][3]=rs1.getInt(6);
            }

            String m ="class";
            String n= "timetable";
            String o=m+c+n;
            String f="Select * from ";
            String sql2= f+o;
            System.out.println(sql2);
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(sql2);
            while (rs.next()){
                data[i][0]=rs.getString(1);
                data[i][1]=rs.getString(2);
                data[i][2]=rs.getString(3);
                data[i][3]=rs.getString(4);
                data[i][4]=rs.getString(5);
                i++;
            }



            conn.close();


        }
        catch (Exception e){

        }
        String[] head= {"Name", "Roll no", "Class", "Fee Balance"};
        String[] head2={"Mon","Tue","Wed","Thurs","Fri"};
        JTable table1=new JTable(data,head2);
        JTable table= new JTable(data2,head);
        table1.setRowHeight(100);
        table.setRowHeight(100);
        JScrollPane scrollPane1= new JScrollPane(table1);
        JScrollPane scrollPane= new JScrollPane(table);
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane1.setLayout(new ScrollPaneLayout());
        scrollPane.createVerticalScrollBar();
        scrollPane.createVerticalScrollBar();
        scrollPane1.createHorizontalScrollBar();
        scrollPane1.createVerticalScrollBar();
        scrollPane.setBounds(100,100,750,100);
        scrollPane1.setBounds(100,350,750,500);
        fra.add(scrollPane);
        fra.add(scrollPane1);
        fra.add(bac);
        bac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bac){
                    fra.dispose();
                    studentspage bac= new studentspage();
                }
            }
        });

     }
}
