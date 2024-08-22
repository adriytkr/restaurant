import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class Home{
  public static JFrame frame=new JFrame("AAA");
  public static JPanel homePage=new JPanel();
  public static JPanel loginPage=new JPanel();
  public static Register registerPage=new Register();

  public static enum Page{
    HOME,
    REGISTER,
    LOGIN,
  };

  public static Page currentPage=Page.HOME;

  public static void goToPage(Page toPage){
    currentPage=toPage;

    if(toPage==Page.HOME) frame.setContentPane(homePage);
    else if(toPage==Page.LOGIN) frame.setContentPane(loginPage);
    else if(toPage==Page.REGISTER) frame.setContentPane(registerPage);

    frame.revalidate();
  }

  public static void main(String[] args){
    // homePage.setLayout(new GridBagLayout());
    
    // Button registerButton=new Button("Register");
    // Button loginButton=new Button("Login");

    // registerButton.addActionListener(e->{
    //   goToPage(Page.REGISTER);
    // });

    // loginButton.addActionListener(e->{
    //   goToPage(Page.LOGIN);
    // });

    // GridBagConstraints gbc=new GridBagConstraints();

    // gbc.gridy=0;
    // gbc.fill=1;
    // gbc.insets=new Insets(0,0,75,0);
    // homePage.add(registerButton,gbc);

    // gbc.gridy=1;
    // gbc.fill=1;
    // gbc.insets=new Insets(0,0,0,0);
    // homePage.add(loginButton,gbc);

    // frame.add(homePage);
    frame.setLayout(null);
    frame.add(registerPage);
    frame.setSize(800,800);
    frame.setVisible(true);
  }
}
