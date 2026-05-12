import javax.swing.JOptionPane;

public class GradetrackerGUI {

    public static void main(String[] args) {
        String name;
        String numOfClass; // varible as string
        String message;
        int numOfClass2; // variable to be converted to int
        
        name = JOptionPane.showInputDialog("Enter your name: ");
        if (name == null) {
            System.exit(0);
        }

        //Initialize the variables:
        boolean val = false;
        numOfClass = "";
        numOfClass2 = 0;

        while (numOfClass2 <= 0 && val == false) //while loop to test if user input is correct according to each prompt
        {
            // catches non-numeric input and prompts user to try again
            try {
                numOfClass = JOptionPane.showInputDialog(null, "Enter the number of classes you want: ");
                numOfClass2 = Integer.parseInt(numOfClass); // converts from String to Int
    
                if ( numOfClass2 > 0) {
                    val = true;
                } else {
                    JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again! \n");
                }
                
            } catch (Exception e) {
                //tests if user canceled the program or entered an invalid input.
                if (numOfClass == null) {
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again! \n");
                }
                
            } 
        }
        GradeTracker tracker = new GradeTracker(numOfClass2); // creates a GradeTracker object to store class names and grades
            
        for (int i = 0; i < numOfClass2; i++) // nested loop is created to validate input
        {
            
            String gradeInput = "";//temporary variable to store grade input before parseing, allows null check on cancel
            tracker.clss[i] = JOptionPane.showInputDialog("Enter the class " + (i+1) + ": "); //(i + 1) is used because array index starts at 0, but we want to show class numbers starting at 1 to the user
            String clss = tracker.clss[i]; //temporary variable to store clss input before parseing, allows null check on cancel
            boolean valid = false;
            if ( clss == null) {
                System.exit(0);
            }

            while (valid == false) // future improvement: validate that >> the class name is not numeric!!! <<
                try 
            {
                gradeInput = JOptionPane.showInputDialog("Enter grade for class " + (i+1) + ": ");
                tracker.grade[i] = Double.parseDouble(gradeInput);
                valid = true;
            } catch (Exception e) 
            {
                if (gradeInput == null) {
                    System.exit(0);
                } else
                {JOptionPane.showMessageDialog(null, "Enter a valid number!");}
        
            }
        }
        message = "Hello " + name + "\nThe number of classes you chose was: " + numOfClass2 + "\nHere are your classes and grade:\n"; //initialize the variable message - builds the initial message for the final report

        
        for(int i = 0; i < numOfClass2; i++) // builds the message with each class name, numeric grade, and letter grade
        {
            message = message + (i+1) + ". "  + tracker.clss[i] + "   " + tracker.grade[i] + " - " + tracker.getLetterGrade(tracker.grade[i]) + "\n";
            
        }
        double average = tracker.calculateAverage();
        String formattedAverage = String.format("%.2f", average);//round average to 2 decimal places
        JOptionPane.showMessageDialog(null, message + "Average Grade: " + formattedAverage);

    }
    
}
