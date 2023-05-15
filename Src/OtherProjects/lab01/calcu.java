import javax.swing.JOptionPane;

public class calcu {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Enter the first number:");
        double num1 = Double.parseDouble(strNum1);

        String strNum2 = JOptionPane.showInputDialog("Enter the second number:");
        double num2 = Double.parseDouble(strNum2);
        if(num2 == 0){
            JOptionPane.showMessageDialog(null, "The divisor should be different from 0");
            double sum = num1 + num2;
            double diff = num1 - num2;
            double prod = num1 * num2;
    
            String output = "Sum: " + sum + "\n"
                    + "Difference: " + diff + "\n"
                    + "Product: " + prod + "\n";
    
            JOptionPane.showMessageDialog(null, output);
    }
        else{

        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;
        double quot = num1 / num2;

        String output = "Sum: " + sum + "\n"
                + "Difference: " + diff + "\n"
                + "Product: " + prod + "\n"
                + "Quotient: " + quot;

        JOptionPane.showMessageDialog(null, output);
        }
    }
}
