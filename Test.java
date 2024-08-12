import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridBagConstraints;

public class Test{
  public static void main(String[] args){
    JFrame frame=new JFrame("AAA");
    Font titleFont=new Font("Arial",Font.PLAIN,36);
    Font primaryFont=new Font("Arial",Font.PLAIN,24);

    JPanel panel=new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.setBounds(150,250,500,300);

    JLabel firstNameLabel=new JLabel("First Name");
    JLabel lastNameLabel=new JLabel("Last Name");
    JLabel emailLabel=new JLabel("Email");
    JLabel passwordLabel=new JLabel("Password");
    JButton submitButton=new JButton("Submit");

    firstNameLabel.setFont(primaryFont);
    lastNameLabel.setFont(primaryFont);
    emailLabel.setFont(primaryFont);
    passwordLabel.setFont(primaryFont);
    submitButton.setFont(primaryFont);

    JTextField firstNameInput=new JTextField();
    JTextField lastNameInput=new JTextField();
    JTextField emailInput=new JTextField();
    JTextField passwordInput=new JTextField();

    firstNameInput.setFont(primaryFont);
    lastNameInput.setFont(primaryFont);
    emailInput.setFont(primaryFont);
    passwordInput.setFont(primaryFont);

    GridBagConstraints gbc=new GridBagConstraints();

    gbc.fill=1;
    gbc.weightx=1;
    gbc.gridx=0;
    gbc.gridy=0;
    gbc.insets=new Insets(4, 4, 4, 4);
    panel.add(firstNameLabel,gbc);

    gbc.weightx=1;
    gbc.gridx=0;
    gbc.gridy=1;
    panel.add(firstNameInput,gbc);

    gbc.weightx=1;
    gbc.gridx=1;
    gbc.gridy=0;
    panel.add(lastNameLabel,gbc);

    gbc.weightx=1;
    gbc.gridx=1;
    gbc.gridy=1;
    panel.add(lastNameInput,gbc);

    gbc.weightx=1;
    gbc.gridwidth=2;
    gbc.gridx=0;
    gbc.gridy=2;
    panel.add(emailLabel,gbc);

    gbc.weightx=1;
    gbc.gridx=0;
    gbc.gridy=3;
    panel.add(emailInput,gbc);

    gbc.weightx=1;
    gbc.gridx=0;
    gbc.gridy=4;
    panel.add(passwordLabel,gbc);

    gbc.weightx=1;
    gbc.gridx=0;
    gbc.gridy=5;
    panel.add(passwordInput,gbc);

    gbc.weightx=1;
    gbc.gridx=0;
    gbc.gridy=6;
    panel.add(submitButton,gbc);

    JLabel title=new JLabel("Sign up xD");
    title.setBounds(150,100,300,150);
    title.setFont(titleFont);

    frame.add(title);
    frame.add(panel);
    frame.setSize(800,800);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
