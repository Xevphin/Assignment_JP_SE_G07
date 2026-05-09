import java.awt.Component;
import javax.swing.JOptionPane;

public class CallingMethodsInSameClass {
    public static void main(String[] args) {
        printOne();
        printOne();
        printTwo();
    }

    public static void printOne()
    {
        JOptionPane.showMessageDialog((Component)null, "Hello World");
    }

    public static void printTwo() 
    {
        printOne();
        printOne();
    }
}
