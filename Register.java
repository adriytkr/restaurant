import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class Register extends JPanel{
  public Register(){
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

    this.setSize(450,500);
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc=new GridBagConstraints();
    gbc.insets=new Insets(0,25,25,0);

    gbc.gridy=0;
    gbc.gridx=0;
    this.add(nameLabel,gbc);

    gbc.gridy=1;
    gbc.gridx=0;
    this.add(cpfLabel,gbc);

    gbc.gridy=2;
    gbc.gridx=0;
    this.add(emailLabel,gbc);

    gbc.gridy=3;
    gbc.gridx=0;
    this.add(phoneLabel,gbc);

    gbc.gridy=4;
    gbc.gridx=0;
    this.add(passwordLabel,gbc);

    // ffsfsfs
    gbc.gridy=0;
    gbc.gridx=2;
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.weightx=1;
    this.add(nameInput,gbc);

    gbc.gridy=1;
    gbc.gridx=2;
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.weightx=1;
    this.add(cpfInput,gbc);

    gbc.gridy=2;
    gbc.gridx=2;
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.weightx=1;
    this.add(emailInput,gbc);

    gbc.gridy=3;
    gbc.gridx=2;
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.weightx=1;
    this.add(phoneInput,gbc);

    gbc.gridy=4;
    gbc.gridx=2;
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.weightx=1;
    this.add(passwordInput,gbc);

    // JButton backButton=new JButton("Back");
    // JButton registerButton=new JButton("Register");
    // JLabel gap=new JLabel("");

    // gbc.gridy=5;
    // gbc.gridx=0;
    // this.add(backButton,gbc);

    // gbc.gridy=5;
    // gbc.gridx=1;
    // gbc.fill=GridBagConstraints.HORIZONTAL;
    // gbc.weightx=1;
    // this.add(gap,gbc);


    // gbc.gridy=5;
    // gbc.gridx=2;
    // this.add(registerButton,gbc);
  }
}
