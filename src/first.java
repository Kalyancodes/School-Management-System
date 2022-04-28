import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class first {
    first(){
        JButton but1= new JButton();
        JButton but2= new JButton();
        JButton but3= new JButton();
        but1.setBounds(200,200,200,30);
        but1.setText("Teachers Login");
        but2.setBounds(200,250,200,30);
        but2.setText("Students Login");
        but3.setBounds(200,300,200,30);
        but3.setText("Office Staff Login");
        but1.setFocusable(false);
        but2.setFocusable(false);
        but3.setFocusable(false);

      JPanel pan= new JPanel();
      pan.setBounds(0,0,600,600);
      pan.setBackground(Color.lightGray);
      pan.setLayout(null);
      pan.add(but1);
      pan.add(but2);
      pan.add(but3);
      JFrame fra= new JFrame();
      fra.setVisible(true);
      fra.setSize(600,600);
      fra.setResizable(false);
      fra.setLocationRelativeTo(null);
      fra.add(pan);
      fra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


      but1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()==but1){
                 teachers_login tp=new teachers_login();
                 fra.dispose();

              }

          }
      });

      but2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()==but2){
                  studentspage st= new studentspage();
                  fra.dispose();

              }

          }
      });
      but3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(e.getSource()==but3){
                  officestaffpage osp= new officestaffpage();
                  fra.dispose();

              }

          }
      });
}


}