package grassseedinc;
import java.util.Scanner;
import java.util.ArrayList;

public class GrassSeedInc {
   
        private  boolean valid = false;
        private float costOfOne = 0;
        private float numberOfLawns = 0;
        private float widthOfLawn = 0;
        private float lengthOfLawn = 0;
        private ArrayList widthOfLawnsList =  new ArrayList();
        private ArrayList lengthOfLawnsList =  new ArrayList();
        
    /**
    * @param args the command line arguments
    */       
    public static void main(String[] args) {
        GrassSeedInc gsiObj = new GrassSeedInc();

        gsiObj.input();
        System.out.printf("%.7f", gsiObj.output());
        
        
    }
    /**
     * Take the input from the user for the cost of 1 square metre.
     * Take the input for the number of lawns.
     * Take the input of the width and length of each lawn.
     */
    private void input(){
        
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        while (!valid){
            System.out.println("Please enter the cost of seed to sow one square metre of lawn");   
            costOfOne = input.nextFloat();
            valid = validator(costOfOne);        
        }
        valid = false;
        while (!valid){
            System.out.println("Please enter the number of lawns");
            numberOfLawns = input.nextFloat();
            valid = validator(numberOfLawns);      
        }
        valid = false;
        for (int i = 0; i < numberOfLawns; i++){
            while (!valid){
                System.out.println("Please enter the width and length of lawn " + (i + 1));
                String temporaryInputHolder = input.next();
                String[] temporaryInputSpliter = temporaryInputHolder.split(" "); 
                widthOfLawn = Float.parseFloat(temporaryInputSpliter[0]);
                valid = validator(widthOfLawn); 
                widthOfLawnsList.add(widthOfLawn);            
                lengthOfLawn = Float.parseFloat(temporaryInputSpliter[1]);
                valid = validator(lengthOfLawn); 
                lengthOfLawnsList.add(lengthOfLawn);
            }       
            valid = false;
        }        
    }
    /**
     * Ensure the value given is greater than 0 and less than or equal to 100
     * @param value The value to be validated
     * 
     * @return True or false result from the validation process
     */
    private boolean validator(float value){
     return(value>0 && value <= 100 );
}
    /**
     * Calculate the area of each lawn and then add it to the running total
     * Multiply the final value by the cost to seed one square metre of lawn
     * 
     * @return The total cost to seed all the lawns
     */
   private float calculation(){
     
     float total = 0;
     float sum = 0;
      for(int i = 0;i <numberOfLawns;i++){
          float length = (float)lengthOfLawnsList.get(i);
          float width = (float)widthOfLawnsList.get(i);
          sum = (length * width);
          total = total+sum;
      }
      return(total*costOfOne);      
   }
   /**
    * Call the calculation method and return the result
    * 
    * @return Return the final result of the calculation method to the calling
    * method for display handling
    */
   private float output(){
        return(calculation());
   }
}
