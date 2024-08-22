import java.awt.Dimension;
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

    this.setPreferredSize(new Dimension(450,500));
    this.setLayout(new GridBagLayout());

    this.add(
      nameLabel,
      new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,0),3,3)
    );

    this.add(
      cpfLabel,
      new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,16),3,3)
    );

    this.add(
      emailLabel,
      new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,16),3,3)
    );

    this.add(
      phoneLabel,
      new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,16),3,3)
    );

    this.add(
      passwordLabel,
      new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,16),3,3)
    );

    this.add(
      nameInput,
      new GridBagConstraints(1,0,2,1,1,0,GridBagConstraints.WEST,1,new Insets(0,0,10,0),3,3)
    );

    this.add(
      cpfInput,
      new GridBagConstraints(2,1,1,1,1,0,GridBagConstraints.WEST,1,new Insets(0,0,10,0),3,3)
    );

    this.add(
      emailInput,
      new GridBagConstraints(1,2,2,1,1,0,GridBagConstraints.WEST,1,new Insets(0,0,10,0),3,3)
    );

    this.add(
      phoneInput,
      new GridBagConstraints(1,3,2,1,1,0,GridBagConstraints.WEST,1,new Insets(0,0,10,0),3,3)
    );

    this.add(
      passwordInput,
      new GridBagConstraints(1,4,2,1,1,0,GridBagConstraints.WEST,1,new Insets(0,0,10,0),3,3)
    );

    JButton backButton=new JButton("Back");
    JButton registerButton=new JButton("Register");

    this.add(
      backButton,
      new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,0),3,3)
    );

    this.add(
      registerButton,
      new GridBagConstraints(2,5,1,1,0,0,GridBagConstraints.EAST,0,new Insets(0,0,10,0),3,3)
    );
  }
}
