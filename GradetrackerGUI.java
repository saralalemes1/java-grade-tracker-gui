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

        while (numOfClass2 <= 0 && !val) //while loop to test if user input is correct according to each prompt
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
            String gradeInput = "";//temporary variable to store grade input before parsing, allows null check on cancel
            boolean valid = false;
            
            String myClass = "0";
            while (!tracker.validateClassName(myClass)) 
                                
                {
                    try {
                        String clss = JOptionPane.showInputDialog("Enter the class " + (i+1) + ": "); //(i + 1) is used because array index starts at 0, but we want to show class numbers starting at 1 to the user
                                                
                    if ( clss == null) {
                        System.exit(0);//check if user clicked on cancel or 'x' button 
                        }                        
                        myClass = clss;
                        boolean isValid = tracker.validateClassName(myClass);
                        if (!isValid) 
                            {
                                JOptionPane.showMessageDialog(null, "The class name MUST start with a letter. Try again!");
                            } else {
                                tracker.setClss(i, clss);
                            }                        
                        
                    } catch (Exception e) {
                        //no action needed, loop will re-prompt            
                    }
                }
                
            while (!valid)
                try 
            {
                gradeInput = JOptionPane.showInputDialog("Enter grade for class " + (i+1) + ": ");
                if (gradeInput == null) {System.exit(0);} //check if user clicked on cancel or 'x' button           
                double parseGrade = Double.parseDouble(gradeInput); //converts from String to double
                if (tracker.setGrade(i, parseGrade)) {
                    valid = true;
                } else {JOptionPane.showMessageDialog(null, "Enter a valid number!");} //else for out of range numbers like 150
                
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Enter a valid number!"); // catch for non-numeric input like "abc"
            }
            
        }
        message = "Hello " + name + "\nThe number of classes you chose was: " + numOfClass2 + "\nHere are your classes and grade:\n"; //initialize the variable message - builds the initial message for the final report

        
        for(int i = 0; i < numOfClass2; i++) // builds the message with each class name, numeric grade, and letter grade
        {
            message = message + (i+1) + ". "  + tracker.getClss(i) + "   " + tracker.getGrade(i) + " - " + tracker.getLetterGrade(tracker.getGrade(i)) + "\n";
            
        }
        double average = tracker.calculateAverage();
        String formattedAverage = String.format("%.2f", average);//round average to 2 decimal places
        JOptionPane.showMessageDialog(null, message + "Average Grade: " + formattedAverage);

    }
    
}
