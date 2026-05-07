public class GradeTracker {

    public String[] clss; // it's public because it is an array and will store multiple values
    public double[] grade;
     
    public GradeTracker(int numOfClass2)
    {
        clss = new String[numOfClass2];
        grade = new double[numOfClass2];
    
    }
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
    
}
