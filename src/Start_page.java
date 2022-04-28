import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_page  {
    public static void main(String[] args) {
        JLabel label=new JLabel("Unicorn School");
        label.setBounds(210,100,150,100);
        JButton fbut= new JButton();
        fbut.setText("Login");
        fbut.setFocusable(false);
        fbut.setBounds(200,200,100,30);

        JFrame frame= new JFrame();
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(fbut);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(label);



        fbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==fbut){
                    frame.dispose();
                    first fi = new first();

                }
            }
        });




    }


}
