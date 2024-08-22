import javax.swing.JFrame;
import javax.swing.JPanel;

public class Restaurant extends JFrame{
  public Home homePage=new Home(this);
  public Login loginPage=new Login(this);
  public Register registerPage=new Register(this);

  public static enum Page{
    HOME,
    REGISTER,
    LOGIN,
  };

  public void goToPage(Page toPage){
    JPanel page=null;

    if(toPage==Page.HOME) page=homePage;
    else if(toPage==Page.LOGIN) page=loginPage;
    else if(toPage==Page.REGISTER) page=registerPage;

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
