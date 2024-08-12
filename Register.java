import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Register{
  public static void main(String[] args){
    JFrame frame=new JFrame("AAA");
    Font primaryFont=new Font("Arial",Font.PLAIN,36);
    Font secondaryFont=new Font("Arial",Font.BOLD,24);

    JLabel usernameLabel=new JLabel("Username");
    JLabel emailLabel=new JLabel("Email");
    JLabel passwordLabel=new JLabel("Password");
    usernameLabel.setFont(secondaryFont);
    emailLabel.setFont(secondaryFont);
    passwordLabel.setFont(secondaryFont);

    JTextField usernameInput=new JTextField();
    JTextField emailInput=new JTextField();
    JTextField passwordInput=new JTextField();
    usernameInput.setFont(primaryFont);
    emailInput.setFont(primaryFont);
    passwordInput.setFont(primaryFont);

    int fontSize=primaryFont.getSize();
    usernameInput.setPreferredSize(new Dimension(150,fontSize));
    emailInput.setPreferredSize(new Dimension(150,fontSize));
    passwordInput.setPreferredSize(new Dimension(150,fontSize));


    JButton submitButton=new JButton("Submit");
    submitButton.setBackground(Color.BLACK);
    submitButton.setForeground(Color.WHITE);
    submitButton.setFont(primaryFont);

    JPanel panel=new JPanel();
    panel.setLayout(new GridLayout(7,1,10,10));
    panel.setBounds(150,250,500,300);

    panel.add(usernameLabel);
    panel.add(usernameInput);
    panel.add(emailLabel);
    panel.add(emailInput);
    panel.add(passwordLabel);
    panel.add(passwordInput);
    panel.add(submitButton);

    JLabel title=new JLabel("Sign up form");
    title.setBounds(150,50,300,150);
    title.setFont(new Font("Arial",Font.BOLD,36));

    frame.add(title);
    frame.add(panel);
    frame.setSize(800,800);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
