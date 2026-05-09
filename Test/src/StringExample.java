import java.awt.Component;
import javax.swing.JOptionPane;

public class StringExample {
    public static void main(String[] args)
    {
        String s1 = "Java Programming";
        int x = 307;
        String s2 = s1 + " " + s1;
        String s3 = s2.substring(10,17);
        String s4 = " is fun";
        String s5 = s2 + s4;
        
        //Display GUI
        JOptionPane.showMessageDialog((Component)null, s1);
        JOptionPane.showMessageDialog((Component)null, s2);
        JOptionPane.showMessageDialog((Component)null, s3);
        JOptionPane.showMessageDialog((Component)null, s4);
        JOptionPane.showMessageDialog((Component)null, s5);
        
        //showing effect of precedence

        x = 3;
        int y = 5;
        String s6 = x + y + "total";
        String s7 = "total" + x + y;
        String s8 = " " + x + y + "total";
        
        //Display GUI
        JOptionPane.showMessageDialog((Component)null, s6);
        JOptionPane.showMessageDialog((Component)null, s7);
        JOptionPane.showMessageDialog((Component)null, s8);
    }
}
