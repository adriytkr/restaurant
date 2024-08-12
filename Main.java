import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;

public class Main{
  public static void main(String[] args){
    JFrame frame=new JFrame("AAA");

    JButton registerButton=new JButton("Register");
    JButton loginButton=new JButton("Login");
    registerButton.setFont(new Font("Arial",Font.BOLD,24));
    loginButton.setFont(new Font("Arial",Font.BOLD,24));

    JPanel panel=new JPanel();
    panel.setLayout(new GridLayout(2,1,0,50));
    panel.setBounds(150,250,500,300);

    panel.add(registerButton);
    panel.add(loginButton);

    frame.add(panel);
    frame.setSize(800,800);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
