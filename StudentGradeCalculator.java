

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {
    private JTextField subjectFields[];
    private JLabel resultLabel;
    private JButton calculateButton;
    
    public StudentGradeCalculator(int numSubjects) {
        setTitle("Student Grade Calculator");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLayout(new GridLayout(numSubjects + 3, 2, 10, 10));


        subjectFields = new JTextField[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            add(new JLabel("Subject " + (i + 1) + " Marks:"));
            subjectFields[i] = new JTextField();
            add(subjectFields[i]);
        }

        calculateButton = new JButton("Calculate Grade");
        resultLabel = new JLabel("Result: ");
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        setVisible(true);
    }

    private void calculateGrade() {
        int total = 0;
        int numSubjects = subjectFields.length;

        try {
            for (JTextField field : subjectFields) {
                total += Integer.parseInt(field.getText());
            }
            double percentage = (double) total / numSubjects;
            String grade = getGrade(percentage);

            resultLabel.setText("<html>Total: " + total + "<br>Percentage: " + String.format("%.2f", percentage) + "%" +
                    "<br>Grade: " + grade + "</html>");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        int numSubjects = Integer.parseInt(JOptionPane.showInputDialog("Enter number of subjects:"));
        new StudentGradeCalculator(numSubjects);
    }
}




