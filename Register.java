import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class Register extends JPanel{
  public Register(Restaurant restaurant){
    // JPanel fixedPanel=new JPanel(new GridBagLayout());
    // fixedPanel.setPreferredSize(this.getSize());

    // fixedPanel.add(homePage);
    // this.add(fixedPanel);

    JLabel nameLabel=new JLabel("Full name");
    JLabel cpfLabel=new JLabel("CPF");
    JLabel emailLabel=new JLabel("Email");
    JLabel phoneLabel=new JLabel("Phone");
    JLabel passwordLabel=new JLabel("Password");
    JTextField nameInput=new JTextField();
    JTextField cpfInput=new JTextField();
    JTextField emailInput=new JTextField();
    JTextField phoneInput=new JTextField();
    JTextField passwordInput=new JTextField();

    this.setPreferredSize(new Dimension(450,500));
    this.setLayout(new GridBagLayout());

    GridBagConstraints gbc=new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,0),3,3);

    this.add(nameLabel,gbc);

    gbc.gridy=1;
    this.add(cpfLabel,gbc);

    gbc.gridy=2;
    this.add(emailLabel,gbc);

    gbc.gridy=3;
    this.add(phoneLabel,gbc);

    gbc.gridy=4;
    this.add(passwordLabel,gbc);

    gbc.fill=1;
    gbc.weightx=1;
    gbc.gridx=1;

    gbc.gridy=0;
    this.add(nameInput,gbc);

    gbc.gridy=1;
    this.add(cpfInput,gbc);

    gbc.gridy=2;
    this.add(emailInput,gbc);

    gbc.gridy=3;
    this.add(phoneInput,gbc);

    gbc.gridy=4;
    this.add(passwordInput,gbc);

    JButton backButton=new JButton("Back");
    JButton registerButton=new JButton("Register");

    gbc.fill=0;
    gbc.gridy=5;
    gbc.weightx=0;

    gbc.gridx=0;
    this.add(backButton,gbc);

    gbc.gridx=1;
    gbc.anchor=GridBagConstraints.EAST;
    this.add(registerButton,gbc);

    backButton.addActionListener(e->{
      restaurant.goToPage(Restaurant.Page.HOME);
    });

    registerButton.addActionListener(e->{
      System.out.println("Register xD");
    });
  }
}
