public class GradeTracker {

    public String[] clss; 
    public double[] grade;
    /**
     * Initializes arrays to store class names and grades
     * @param numOfClass2 number of classes entered by the user
     */ 
    public GradeTracker(int numOfClass2) 
    {
        clss = new String[numOfClass2];
        grade = new double[numOfClass2];
    
    }
    /**
     * calculates the average of all the grades
     * @return the average grade rounded to a doule
     */ 
    public double calculateAverage()
    {
        double total = 0;
        double average = 0;
        double numOfClass2 = grade.length;
        

        for(int i = 0; i < numOfClass2; i++)
        {
            total = total + grade[i];

        }
        
        average = total / grade.length;
        return average;
        
    }
   /**
    * converts a numeric grade to a letter grade
    * @param grade is the numeric grade to convert
    * @return letter grade (A, B, C, D, F)
    */
    public String getLetterGrade(double grade) 
    
    {
    
        if (grade >= 90)
        {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else
            return "F";
    }
    /**
     * Validate that class names starts with a letter
     * @param the class name to validate
     * @return true if the class name starts with a latter, false otherwise
     */
    public boolean validateClassName(String clss)
    {
        if (Character.isLetter(clss.charAt(0))) {
            return true;            
        } else
        {
            return false;
        }

    }

}
