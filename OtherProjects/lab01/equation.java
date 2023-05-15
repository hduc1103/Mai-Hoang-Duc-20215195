import javax.swing.JOptionPane;
import java.lang.Math;
import java.lang.String;

public class equation {
    public static void main(String[] args) {
        String[] options = { "Linear equation", "Linear system", "Second-degree equation" };
        int choice = JOptionPane.showOptionDialog(null, "Which type of equation do you want to solve?",
                "Option Selector", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == JOptionPane.CLOSED_OPTION) {
            System.out.println("No option selected");
        } else if (choice == 0) {
            String strNum1 = JOptionPane.showInputDialog("You choosed: ax+b \n Enter a: ");
            double a = Double.parseDouble(strNum1);

            String strNum2 = JOptionPane.showInputDialog("You choosed ax+b \n Enter b: ");
            double b = Double.parseDouble(strNum2);

            if (a == 0) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(null, "Infinitely many roots");
                } else {
                    JOptionPane.showMessageDialog(null, "No root!");
                }
            } else {
                double result = -a / b;
                String output = "Root: " + result;
                JOptionPane.showMessageDialog(null, output);
            }
        } else if (choice == 1) {
            String strNum1 = JOptionPane
                    .showInputDialog("You choosed: a11* x1 + a12* x2 = b1* a21* x1+ a22* x2 = b2 \n Enter a11: ");
            double a11 = Double.parseDouble(strNum1);

            String strNum2 = JOptionPane
                    .showInputDialog("You choosed: a11* x1 + a12* x2 = b1* a21* x1+ a22* x2 = b2 \n Enter a12: ");
            double a12 = Double.parseDouble(strNum2);

            String strNum3 = JOptionPane
                    .showInputDialog("You choosed: a11* x1 + a12* x2 = b1* a21* x1+ a22* x2 = b2 \n Enter b1: ");
            double b1 = Double.parseDouble(strNum3);

            String strNum4 = JOptionPane
                    .showInputDialog("You choosed: a11* x1 + a12* x2 = b1* a21* x1+ a22* x2 = b2 \n Enter a21: ");
            double a21 = Double.parseDouble(strNum4);

            String strNum5 = JOptionPane
                    .showInputDialog("You choosed: a11* x1 + a12* x2 = b1* a21* x1+ a22* x2 = b2 \n Enter a22: ");
            Double.parseDouble(strNum5);
            
            String strNum6 = JOptionPane
                    .showInputDialog("You choosed: a11* x1 + a12* x2 = b1* a21* x1+ a22* x2 = b2 \n Enter b2: ");
            double b2 = Double.parseDouble(strNum6);

            double D = a11 * b2 - a21 * b1;
            if (D == 0) {
                JOptionPane.showMessageDialog(null, "Infinite number of roots!");
            } else {
                double Dx = b2 * b1 * a21 - a12 * b2;
                double Dy = a11 * b2 - b1 * a21 * b2;
                double x1 = Dx / D;
                double x2 = Dy / D;
                String output = "The two roots of the linear system: " + "\n" + "x1= " + x1 + " and x2= " + x2;
                JOptionPane.showMessageDialog(null, output);
            }
        } else if (choice == 2) {
            String strNum1 = JOptionPane.showInputDialog("You choosed a* x^2+ b* x+ c \n Enter a: ");
            double a = Double.parseDouble(strNum1);
            String strNum2 = JOptionPane.showInputDialog("You choosed a* x^2+ b* x+ c \n Enter b: ");
            double b = Double.parseDouble(strNum2);
            String strNum3 = JOptionPane.showInputDialog("You choosed a* x^2+ b* x+ c \n Enter c: ");
            double c = Double.parseDouble(strNum3);

            if (a == 0) {
                double root = -c / b;
                String output = "The equation has one root x= " + root;
                JOptionPane.showMessageDialog(null, output);
            } else if (a == 0 && b == 0) {
                JOptionPane.showMessageDialog(null, "The equation has no root");
            } else if (a==0 && b==0 && c==0){
                JOptionPane.showMessageDialog(null, "The equation has no root");
            }
            
            else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    JOptionPane.showMessageDialog(null, "The equation has no root");
                    System.exit(0);
                }
                if (delta == 0) {
                    double root = -b / (2 * a);
                    String output = "The equation has double root x= " + root;
                    JOptionPane.showMessageDialog(null, output);
                }
                if (delta > 0) {
                    double no1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double no2 = (-b - Math.sqrt(delta)) / (2 * a);
                    String output = "The equation has two roots x1= " + no1 + " and x2=" + no2;
                    JOptionPane.showMessageDialog(null, output);
                }
            }
        }
    }
}
