import javax.swing.JFrame;
import javax.swing.JPanel;

public class Restaurant extends JFrame{
  // public HomePage homePage=new HomePage(this);
  // public LoginPage loginPage=new LoginPage(this);
  // public RegisterPage registerPage=new RegisterPage(this);
  // public RegisterEmployeePage registerEmployeePage=new RegisterEmployeePage(this);
  // public RegisterUserPage registerUserPage=new RegisterUserPage(this);

  public static enum Page{
    HOME,
    REGISTER,
    LOGIN,
    REGISTER_EMPLOYEE,
    REGISTER_USER,
  };

  public void goToPage(Page toPage){
    JPanel page=null;

    if(toPage==Page.HOME) page=new HomePage(this);
    else if(toPage==Page.LOGIN) page=new LoginPage(this);
    else if(toPage==Page.REGISTER) page=new RegisterPage(this);
    else if(toPage==Page.REGISTER_EMPLOYEE) page=new RegisterEmployeePage(this);
    else if(toPage==Page.REGISTER_USER) page=new RegisterUserPage(this);

    this.setContentPane(page);
    this.revalidate();
  }

  public void initialize(){
    this.setTitle("Restaurant");
    this.setSize(800,800);
    this.setVisible(true);
    this.goToPage(Page.HOME);
  }
}
