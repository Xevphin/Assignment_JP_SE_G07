package Assignment;
//JAVA PROGRAMMING ASSIGNMENT 2 
//SE LG05 (G07)

//CONTRIBUTED BY NISA//
import javax.swing.*;

class Encoded{

    private String inputText;
    private int charCount;
    private String resultText;
    private final String groupID = "G05/SE-G07"; // Hardcoded secret key

    // Default constructor
    public Encoded() {}
    //Sets the input text and performs counting, shifting, and encoding
    //This avoids method calls inside constructor (warning)

    public void Encoded(String inputText) {
        this.inputText = inputText;
        this.charCount = countCharacters();
        int finalShift = calculateFinalShift();
        this.resultText = applyCipher(finalShift);
    }


    //Counts the number of non-space characters in the input
    public int countCharacters() {
        int count = 0;
        for (char c : inputText.toCharArray()) {
            if (c != ' ')
                count++;
        }
        return count;
    }

    // Validates that input contains only uppercase letters, digits, and spaces
    public boolean checkStringValidity(String inputText) {
        for (char c : inputText.toCharArray()) {
            if (!(Character.isLowerCase(c) || Character.isDigit(c) || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    
    //Generates a unique shift based on the group's ID using hashCode()
    public int generateShift() {
        return Math.abs(groupID.hashCode()) % 10 + 1;
    }


    //Calculates final shift as groupShift + non-space char count
    public int calculateFinalShift() {
        return generateShift() + charCount;
    }

    //Applies the cipher to the inputText using the given shift value
    public String applyCipher(int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else if (Character.isDigit(c)) {
                result.append((char) ((c - '0' + shift) % 10 + '0'));
            } else {
                result.append(' ');
            }
        }
        return result.toString();
    }

    // === Getters ===

    public String getResultText() {
        return resultText;
    }

    public int getCharCount() {
        return charCount;
    }

    public int getFinalShift() {
        return calculateFinalShift();
    }
}

public class Assignment {

    public static void main(String[] args) {

        //Main application window GUI
        JFrame frame = new JFrame("Text Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);

        JLabel instructionLabel = new JLabel("Enter text (LOWERCASE letters, digits, spaces only):");
        JTextField inputField = new JTextField(30);
        JButton encodeButton = new JButton("Encode");
        
        //Label and text area to display the encoded result
        JLabel resultLabel = new JLabel("Encoded Result:");
        JTextArea resultArea = new JTextArea(2, 30);
        resultArea.setEditable(false); //Block user to edit encoded result
        resultArea.setLineWrap(true); 
        resultArea.setWrapStyleWord(true);

        //Label to display the final calceulated shift
        JLabel shiftLabel = new JLabel("Final Shift: ");

        //Panel to hold and organize UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        //Add all UI components to the panel
        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(encodeButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(resultLabel);
        panel.add(new JScrollPane(resultArea));
        panel.add(Box.createVerticalStrut(10));
        panel.add(shiftLabel);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Button click logic
        encodeButton.addActionListener(e -> {
            String input = inputField.getText().trim();
            Encoded encoder = new Encoded();

            //Validate input format
            if (!encoder.checkStringValidity(input)) {

                //Show error popup if input is invalid
                JOptionPane.showMessageDialog(frame,
                        "Invalid input! Only LOWERCASE letters, digits, and spaces allowed.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Process input using overloaded constructor
            encoder.Encoded(input); // Process input
            resultArea.setText(encoder.getResultText());
            shiftLabel.setText("Final Shift: " + encoder.getFinalShift());
        });
    }
}


