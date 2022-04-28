import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class office_staff_view1 {
    office_staff_view1(int a){
        Object[][] data= new Object[a][4];
        JFrame frame= new JFrame();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(700,700);
        frame.setLocation(150,100);
        JPanel panel= new JPanel(null);
        panel.setBounds(0,0,500,300);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-proto", "root", "CKalyan12345@.");
            String sr="select * from teachers";
            Statement st=conn.createStatement();
            ResultSet rs= st.executeQuery(sr);
            int m=0;
            while (rs.next()){
                data[m][0]=rs.getString(1);
                data[m][1]=rs.getString(3);
                data[m][2]=rs.getString(4);
                data[m][3]=rs.getString(5);
                   m++;
            }


        }
        catch (Exception exception){

        }
        String[] head={"Username", "Teachers Name","Teacher Class","No of Students"};
        JTable table= new JTable(data,head);
        table.setRowHeight(50);
         JScrollPane scrollPane= new JScrollPane(table);
         scrollPane.createVerticalScrollBar();
         scrollPane.createHorizontalScrollBar();
         scrollPane.setBounds(100,50,500,300);
         scrollPane.setLayout(new ScrollPaneLayout());
         JButton add= new JButton("Add");
         add.setBounds(150,450,100,30);
         JButton remove= new JButton("Remove");
         remove.setBounds(300,450,100,30);
         JButton edit= new JButton("Edit");
         edit.setBounds(450,450,100,30);
         JButton bac= new JButton("Back");
         bac.setBounds(300,490,100,30);
         frame.add(scrollPane);
         frame.add(add);
         frame.add(remove);
         frame.add(edit);
         frame.add(bac);
         add.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.dispose();
                 addteacher m= new addteacher();
             }
         });
         remove.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.dispose();
                 removeteacher m= new removeteacher();
             }
         });
         edit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.dispose();
                 JFrame fra= new JFrame();
                 fra.setLocation(450,150);
                 fra.setLayout(null);
                 fra.setSize(600,600);
                 fra.setVisible(true);
                 fra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                 JLabel label= new JLabel("Username :");
                 JTextField textField= new JTextField();
                 JButton bud= new JButton("Enter");
                 label.setBounds(250,100,100,30);
                 textField.setBounds(350,100,100,30);
                 bud.setBounds(300,180,100,30);
                 fra.add(bud);
                 fra.add(label);
                 fra.add(textField);
                 bud.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         if(e.getSource()==bud){
                             String ab=textField.getText();
                             fra.dispose();
                             editteacher m= new editteacher(ab);
                         }
                     }
                 });
             }
         });
         bac.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==bac){
                     frame.dispose();
                     office_Staff_view m= new office_Staff_view();
                 }
             }
         });
    }
}
