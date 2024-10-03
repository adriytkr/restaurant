import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage extends JPanel{
  public LoginPage(Restaurant restaurant){
    JLabel emailLabel=new JLabel("Email");
    JLabel passwordLabel=new JLabel("Password");
    JTextField emailInput=new JTextField();
    JTextField passwordInput=new JTextField();

    this.setPreferredSize(new Dimension(450,500));
    this.setLayout(new GridBagLayout());

    GridBagConstraints gbc=new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,0,new Insets(0,0,10,0),3,3);

    this.add(emailLabel,gbc);

    gbc.gridy=1;
    this.add(passwordLabel,gbc);

    gbc.fill=1;
    gbc.weightx=1;
    gbc.gridx=1;

    gbc.gridy=0;
    this.add(emailInput,gbc);

    gbc.gridy=1;
    this.add(passwordInput,gbc);

    JButton backButton=new JButton("Back");
    JButton loginButton=new JButton("Login");

    gbc.fill=0;
    gbc.gridy=2;
    gbc.weightx=0;

    gbc.gridx=0;
    this.add(backButton,gbc);

    gbc.gridx=1;
    gbc.anchor=GridBagConstraints.EAST;
    this.add(loginButton,gbc);

    backButton.addActionListener(e->{
      restaurant.goToPage(Restaurant.Page.HOME);
    });

    loginButton.addActionListener(e->{
      String email=emailInput.getText();
      String password=passwordInput.getText();

      System.out.println("email:"+email);
      System.out.println("password:"+password);

      restaurant.goToPage(Restaurant.Page.USER_HOME);
    });
  }
}
