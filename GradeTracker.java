public class GradeTracker {

    private String[] clss; 
    private double[] grade;
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
     * Calculates the average of all the grades
     * @return the average grade rounded to a double
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
    * Converts a numeric grade to a letter grade
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
     * @param clss the class name to validate
     * @return true if the class name starts with a letter, false otherwise
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
    /**
     * Sets grade in a range of 0 and 100
     * @param index value of the grade
     * @param grade variable to store input for grade
     * @return true if grade is greater or equal to zero and less or equal to 100, false otherwise
     */
    public boolean setGrade(int index, double grade){
        if (grade >= 0 && grade <= 100) {
            this.grade[index] = grade;
            return true;        
        } else {
            return false;
        }
    }
    /**
     * Gets grade at specific index
     * @param index position of the grade in the array
     * @return the grade value at the given index
     */

    public double getGrade(int index){
        return grade[index];
    }
    /**
     * Sets class index and validate if class name starts with a letter
     * @param index position of the class in the array
     * @param clss variable to store input for class
     */

    public void setClss(int index, String clss){
        if (validateClassName(clss)) {
            this.clss[index] = clss;            
        }
    }
    /**
     * Gets class at specific index
     * @param index position of clss in the array
     * @return the class value at the given index
     */
    public String getClss(int index){
        return clss[index];
    }


}
