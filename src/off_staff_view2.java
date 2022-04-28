import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JTable;

public class off_staff_view2 {
    off_staff_view2(int a){
        JFrame frame= new JFrame();
        Object[][] data= new Object[a][5];
        frame.setVisible(true);
        frame.setLocation(450,50);
        frame.setResizable(true);
        frame.setSize(800,850);
        frame.setLayout(null);
        JButton add= new JButton();
        add.setText("Add");
        JButton back= new JButton("Back");
        add.setBounds(200,690,100,30);
        back.setBounds(350,750,100,30);
        JButton remove= new JButton();
        remove.setText("Remove");
        remove.setBounds(350,690,100,30);
        JButton but= new JButton();
        JButton sear= new JButton("Search");
        sear.setBounds(600,20,70,30);
        JTextField sa= new JTextField();
        sa.setBounds(700,20,100,30);
        but.setText("Edit");
        but.setBounds(500,690,100,30);
        int f=0;

        try{


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            String sr="select * from students_list";
            Statement st=conn.createStatement();
            ResultSet rs= st.executeQuery(sr);
            while (rs.next()){
                data[f][0]=rs.getString(1);
                data[f][1]=rs.getString(3);
                data[f][2]=rs.getString(4);
                data[f][3]=rs.getInt(5);
                data[f][4]=rs.getString(6);
               f++;

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        Object[] head={"Username","Students Name"," Students Roll_No","Students Class","Fees to be Paid"};
        JTable table= new JTable(data,head);
        JScrollPane scrollPane=new JScrollPane(table);
        table.setRowHeight(40);
        scrollPane.createVerticalScrollBar();
        scrollPane.createVerticalScrollBar();
        scrollPane.setBounds(100,100,650,550);
        frame.add(scrollPane);
        frame.add(but);
        frame.add(add);
        frame.add(remove);
        frame.add(back);
        frame.add(sear);
        frame.add(sa);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  frame.dispose();
                  JFrame frame1= new JFrame();
                  frame1.setVisible(true);
                  frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                  frame1.setResizable(true);
                  frame1.setSize(500,500);
                  frame1.setLocation(450,150);
                  frame1.setLayout(null);
                  JLabel label= new JLabel("Enter Username");
                  JTextField textFielde= new JTextField();
                  JButton but1 = new JButton("Enter");
                  label.setBounds(100,100,100,30);
                  textFielde.setBounds(250,100,100,30);
                  but1.setBounds(260,200,100,30);
                  frame1.add(but1);
                  frame1.add(label);
                  frame1.add(textFielde);
                  but1.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          String a= textFielde.getText();
                          if (e.getSource() == but1) {
                              frame1.dispose();
                              off_staff_student_edit ew = new off_staff_student_edit(a);
                          }
                      }
                  });


            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                add_student l= new add_student();

            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                remove_student l= new remove_student();

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                office_Staff_view m= new office_Staff_view();
            }
        });
        sear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==sear){
                    String m=sa.getText();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
                        String sql= "select * from students_list where username=?";
                        System.out.println(m);
                        PreparedStatement ps= conn1.prepareStatement(sql);
                        ps.setString(1,m);
                        ResultSet rs= ps.executeQuery();
                        System.out.println("wiw");
                        Object[][] aom= new Object[1][5];


                        while (rs.next()){
                             aom[0][0]= rs.getString(1);
                             aom[0][1]=rs.getString(3);
                            int ap=rs.getInt(4);
                            String ar=""+ap;
                            aom[0][3]=ar;
                            aom[0][2]=rs.getString(5);
                            int aq=rs.getInt(6);
                            String as=""+aq;
                            aom[0][4]=as;

                        }


                        JFrame frame2= new JFrame();
                        frame2.setLocation(450,100);
                        frame2.setSize(600,600);
                        frame2.setLayout(null);
                        frame2.setVisible(true);
                        JTable table2= new JTable(aom, head);
                        JScrollPane scrollPane1= new JScrollPane(table2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                        scrollPane1.setLayout(new ScrollPaneLayout());
                        scrollPane1.setBounds(100,100,300,300);
                        frame2.add(scrollPane1);
                        JButton bac= new JButton("OK");
                        bac.setBounds(250,500,100,30);
                        frame2.add(bac);
                        bac.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(e.getSource()==bac){
                                    frame2.dispose();
                                }
                            }
                        });


                    }
                    catch (Exception exception){

                    }
                }
            }
        });
    }
}
