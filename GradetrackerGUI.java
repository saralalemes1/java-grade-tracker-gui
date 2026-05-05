import javax.swing.JOptionPane;

public class GradetrackerGUI {

    public static void main(String[] args) {
        String name;
        String numOfClass; // varible as string
        String message;
        
        int numOfClass2; // variable to be converted to int
        name = JOptionPane.showInputDialog("Enter your name: ");
        numOfClass = JOptionPane.showInputDialog(null, "Enter the number of classes you want: ");
        numOfClass2 = Integer.parseInt(numOfClass); // converts from String to Int
        
        String[] clss = new String[numOfClass2]; // array to store multiple values
        
        for (int i = 0; i < numOfClass2; i++)
        {
            clss[i] = JOptionPane.showInputDialog("Enter the class" + (i+1) + ": "); //(i + 1) is used because array index starts at 0, but we want to show class numbers starting at 1 to the user
        }
        message = "Hello " + name + "\nThe number of classes you chose was: " + numOfClass2 + "\nHere are your classes:\n"; //initialize the variable message - builds the initial message for the final report
        for(int i = 0; i < numOfClass2; i++)
        {
            message = message + (i+1) + ". "  + clss[i] + "\n";
            
        }

        JOptionPane.showMessageDialog(null, message);

    }
    
}
