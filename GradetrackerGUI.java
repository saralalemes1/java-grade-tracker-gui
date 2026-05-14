import javax.swing.*;
import java.awt.*; //library for layout

public class GradetrackerGUI {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Grade Tracker"); // creates a JFrame object
        frame.setSize(400, 500); // sets width and height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when click on X

        CardLayout cardLayout = new CardLayout(); // manages multiple pages inside JFrame
        JPanel mainPanel = new JPanel(cardLayout);
        
        JPanel page1 = new JPanel(); 
        JPanel page2 = new JPanel();
        JPanel page3 = new JPanel();
        
        //Add pages to the mainPanel
        mainPanel.add(page1, "Page 1");
        mainPanel.add(page2, "Page 2");
        mainPanel.add(page3, "Page 3");

        frame.add(mainPanel);
        
        page1.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Grade Tracker"); // creates a JLabel obect for Title
        page1.add(titleLabel, BorderLayout.NORTH); // adds title to frame and position to north
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // aligns title to center
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        JPanel topPanel = new JPanel(); // creates a panel at them top to place "name" and "number of classes"
        JLabel nameLabel = new JLabel("Name: ");
        JTextField textField = new JTextField(10); // creates a text field for user input
        JLabel classLabel = new JLabel("Number of classes: ");
        JTextField textField2 = new JTextField(10);
        // add label and text field to topPanel
        topPanel.add(nameLabel);
        topPanel.add(textField);
        topPanel.add(classLabel);
        topPanel.add(textField2);
        page1.add(topPanel, BorderLayout.CENTER); // location of top panel

        // creates "CANCEL" and "NEXT" buttons
        JPanel bottomPanel = new JPanel();
        JButton cancelButton = new JButton("CANCEL");
        JButton nextButton = new JButton("NEXT");
        bottomPanel.add(cancelButton);
        bottomPanel.add(nextButton);

        // add position of buttons
        page1.add(bottomPanel, BorderLayout.SOUTH);

        // adds action to buttons
        cancelButton.addActionListener(e -> {System.exit(0);});
        nextButton.addActionListener(e -> 
            {
                String input = textField2.getText();  // gets the user input from textfield2 ("Enter number of classes")              
                int txt = Integer.parseInt(input); // converts String to int
                cardLayout.show(mainPanel, "Page 2");

                // creates arrays to store multiple text fields
                JTextField[] classFields = new JTextField[txt];
                JTextField[] gradeFields = new JTextField[txt];

                page2.setLayout(new BorderLayout());

                JPanel topPanel2 = new JPanel(); // creates Panel to add Title and subtitle to align correctly at the center
                JLabel titleLabel2 = new JLabel("Grade Tracker");
                JLabel subtitleLabel = new JLabel("Enter your classes and grade");

                topPanel2.setLayout(new BoxLayout(topPanel2, BoxLayout.Y_AXIS));
                topPanel2.add(titleLabel2); // adds title to Panel
                topPanel2.add(subtitleLabel); // adds subtitle to Panel

                //Sets the aligment, font and font size to title and subtitle
                titleLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
                titleLabel2.setFont(new Font("Arial", Font.BOLD,36));
                subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                subtitleLabel.setFont(new Font("Arial", Font.BOLD, 20));

                page2.add(topPanel2, BorderLayout.NORTH); // adds Panel to page #2
                
                JPanel westPanel = new JPanel(); // creates a Panel on the west side of the window
                JLabel clssLabel = new JLabel("Classes: "); // creates the lable "Classes"
                
                //Future improvement: Responsive Design/Layout
                westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS)); // uses BoxLayout to set the text boxes verically at Y-axis.
                westPanel.add(clssLabel); // adds "clssLabel" to west side of the Panel
                
                // creates a for loop to check how many JTextField should be created according to user input in page 1
               for (int i = 0; i < txt; i++)
               {
                classFields[i] = new JTextField(15);// 15 is the max number of characters for each text field
                classFields[i].setPreferredSize(new Dimension(300, 25)); // sets the size
                classFields[i].setMaximumSize(new Dimension(300, 25)); // keeps the size according to preferred size
                westPanel.add(classFields[i]);
               }
               

               JPanel eastPanel = new JPanel();//creates a Panel on the east side of the window
               JLabel gradeLabel = new JLabel("Grade: ");// creates the lable "Grade"   

               eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
               eastPanel.add(gradeLabel);// adds "gradeLabel" to east side of the Panel

               for (int i = 0; i < txt; i++)
               {
                gradeFields[i] = new JTextField(15);
                gradeFields[i].setPreferredSize(new Dimension(300, 25));
                gradeFields[i].setMaximumSize(new Dimension(300, 25));
                eastPanel.add(gradeFields[i]);                
               }

                page2.add(westPanel, BorderLayout.WEST);// adds westPanel to west side of the screen
                page2.add(eastPanel, BorderLayout.EAST);// adds eastPanel to east side of the screen
                
                // creates "BACK" and "SUBMIT" buttons
                JPanel bottomPanel2 = new JPanel();
                JButton backButton = new JButton("BACK");
                JButton submitButton = new JButton("SUBMIT");
                bottomPanel2.add(backButton);
                bottomPanel2.add(submitButton);

                 // add position of buttons
                page2.add(bottomPanel2, BorderLayout.SOUTH);

                // adds action to buttons
                backButton.addActionListener(evt -> {cardLayout.show(mainPanel, "Page 1");});
                submitButton.addActionListener(evt -> {});
                

            });



        frame.setVisible(true);// makes the window to be visible 

        
        



    }
    
}
