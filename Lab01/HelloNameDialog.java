//Example 3: HellonameDialog.java

import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args){
        String result;
        result= JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + result +"!");
        System.exit(0);
    }    
}
