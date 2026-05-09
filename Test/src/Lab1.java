import java.awt.Component;
import javax.swing.JOptionPane;

public class Lab1
{
    public static void main(String[] args)
    {
        String s1 = "Abdul Rahim";
        String s2 = new StringBuilder(s1).reverse().toString();

        JOptionPane.showMessageDialog((Component)null, s1 + "->" + s2);
        System.exit(0);
    }
}