import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Home extends JPanel{
  public Home(Restaurant restaurant){
    this.setLayout(new GridBagLayout());
    
    Button registerButton=new Button("Register");
    Button loginButton=new Button("Login");

    registerButton.addActionListener(e->{
      restaurant.goToPage(Restaurant.Page.REGISTER);
    });

    loginButton.addActionListener(e->{
      restaurant.goToPage(Restaurant.Page.LOGIN);
    });

    this.add(
      registerButton,
      new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,1,new Insets(0,0,75,0),3,3)
    );

    this.add(
      loginButton,
      new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST,1,new Insets(0,0,0,0),3,3)
    );
  }
}
