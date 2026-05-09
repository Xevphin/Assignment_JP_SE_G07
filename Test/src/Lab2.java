import javax.swing.JOptionPane;
import java.text.DecimalFormat;

interface CollegeScore {
    double computeScore(int year_of_study);
    double computeScore(int year_of_study, double cgpa);
    double computeScore(int year_of_study, double cgpa, int extracurricular_activities);
    }

class Student implements CollegeScore {
    public double computeScore(int year_of_study) {
        return year_of_study * 10; // Assume each year of study gives 10 points to the score
    }
    public double computeScore(int year_of_study, double cgpa) {
        return (year_of_study * 10) + (cgpa * 25); // Assume each year of study gives 10 points and each point of CGPA gives 25 points to the score
    }
    public double computeScore(int year_of_study, double cgpa, int extracurricular_activities) {
        return (year_of_study * 10) + (cgpa * 25) + (extracurricular_activities * 5); // Assume each year of study gives 10 points, each point of CGPA gives 25 points, and each extracurricular activity gives 5 points to the score
    }
}

public class Lab2 {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##"); // Create a DecimalFormat object to format the score to 2 decimal places
        Student std = new Student();
        String name = JOptionPane.showInputDialog("Enter student name: ");
        

        String yearOfStudyStr = JOptionPane.showInputDialog("Enter year of study: ");
        int yearOfStudy = yearOfStudyStr.isEmpty() ? -1 : Integer.parseInt(yearOfStudyStr); // Convert the input string

        String cgpaStr = JOptionPane.showInputDialog("Enter CGPA: ");
        double cgpa = cgpaStr.isEmpty() ? -1 : Double.parseDouble(cgpaStr);

        String extracurricularStr = JOptionPane.showInputDialog("Enter number of extracurricular activities: ");
        int extracurricularActivities = extracurricularStr.isEmpty() ? -1 : Integer.parseInt(extracurricularStr);

        if (yearOfStudy == -1) {
            JOptionPane.showMessageDialog(null, "Year of study is required. Please try again.");
            System.exit(0);
        }
        else if (cgpa == -1 && extracurricularActivities == -1) {
            JOptionPane.showMessageDialog(null, name + " scored(year of study): " + df.format(std.computeScore(yearOfStudy))); // Compute score based on year of study only
        }
        else if (cgpa != -1 && extracurricularActivities == -1) {
            JOptionPane.showMessageDialog(null, name + " scored(year of study, CGPA): " + df.format(std.computeScore(yearOfStudy, cgpa))); // Compute score based on year of study and CGPA
        }
        else if (cgpa != -1 && extracurricularActivities != -1) {
            JOptionPane.showMessageDialog(null, name + " scored(year of study, CGPA, extracurricular activities): " + df.format(std.computeScore(yearOfStudy, cgpa, extracurricularActivities))); // Compute score based on year of study, CGPA, and extracurricular activities
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
        }
        
        System.exit(0);
    }
}

