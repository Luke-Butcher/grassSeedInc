/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grassseedinc;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author conorfarrell
 */
public class GrassSeedInc {
    
    private boolean valid = false;
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
        // TODO code application logic here
        GrassSeedInc gsiObj = new GrassSeedInc();

        gsiObj.input();
        System.out.printf("%.7f", gsiObj.output());
    }
    
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
    
    private boolean validator(float value){
        return(value>0 && value <= 100 );
    }
    
    private float calculation(){
        float total = 0;
     float sum = 0;
      for(int i = 0;i <numberOfLawns;i++){
          float length = (float)lengthOfLawnsList.get(i);
          float width = (float)widthOfLawnsList.get(i);
          sum = (length * width);
          total = total + sum;
      }
      return(total*costOfOne);
    }
    
    private float output(){
        return calculation();
    }
    
}
