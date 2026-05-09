import java.awt.Component;
import javax.swing.JOptionPane;
public class HelloWorld
{
   public static void main (String[] args)
   {
      JOptionPane.showMessageDialog((Component)null,"Hello World","Hello World",JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
   }
}