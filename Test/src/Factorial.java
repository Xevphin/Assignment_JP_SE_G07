import java.awt.Component;
import javax.swing.JOptionPane;

public class Factorial {
    
    public static void main(String[] args)
    {
        final int NUM_FACTS = 14;
        for (int i = 0; i < NUM_FACTS; i++)
        {
            JOptionPane.showMessageDialog((Component)null, i + "! is " + factorial(i), "Factorial", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static int factorial(int n)
    {
        int result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }
}
