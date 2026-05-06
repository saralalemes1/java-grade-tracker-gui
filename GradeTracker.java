public class GradeTracker {

    public String[] clss; // it's public because it is an array and will store multiple values
    public double[] grade;
    public double[] average;

    public GradeTracker(int numOfClass2)
    {
        clss = new String[numOfClass2];
        grade = new double[numOfClass2];
    }
    
   /*  public calculateAverage(int numOfClass2)
    {
        average = new double[numOfClass2];
        
    
    }*/
    
}
