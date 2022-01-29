//Author: Sheetal Ghodake
//0-1 Knapsack problem with Dynamic programming
//Bottom-up approach

import java.util.Random;

public class KnapsackRandom {

    public static int n = 10; //Number of items to generate randomly
    public static int  W = 100; //Total weight of the Knapsack
    public static int K[][] = new int[n+1][W+1]; //2D array to store total weights and calculate them.
    public static int i; //Integer for looping
    public static int j; //Integer for looping
    public static int g=1; //Integer for looping
    public static int[] cost = new int[n]; //Value of the items
    public static int[] wgt = new int[n]; //Weight of the items
    public static int max = 100; //Maximum value for Random number generator
    public static int min = 10; //Minimum value for Random number generator

    //Knapsack method below takes total number of items n as first input, weight of each items, cost of each items and total weight of the knapsack as arguments.
    public static int knapsack(int n, int wgt[], int cost[], int W) //Knapsack integer method with four arguments
    {
        //Bottom-up approach for dynamic programming
        for (i = 0; i <= n; i++) { //First for loop for iteration
            for (j = 0; j <= W; j++) { //Second for loop for iteration
                if (i==0 || j==0) //Checking if the array is empty or not.
                    K[i][j] = 0; // If empty, then fill 0th value with 0.
                else if (wgt[i-1] <= j){ //Check if the second last weight is less than j
                    K[i][j] = Math.max(K[i-1][j], cost[i-1] + K[i-1][j-wgt[i-1]]); //If it is, then find maximum between Knapsack array K and the sum of cost and knapsack value
                }
                else
                    K[i][j] = K[i-1][j]; //If neither one is the case, then copy the value of i-1 element to K[i][j]
            }
        }
        System.out.println("Number of Input: "+n);
        System.out.println("Maximum value that can fit in weight "+W+ " is: "+ K[n][W]); //Print results
        return K[n][W]; //Return an integer as the method returns an integer.
    }


    public static void main(String args[]) //Main Method which generates random numbers and give that to the Knapsack method as input.
    {
        randomGenerator(); // Calling the random number generator method
        knapsack(n, wgt, cost, W); //Calling the previously created knapsack method with arguments.
    }

    public static void randomGenerator(){ //Create Random numbers
        Random r = new Random(); //Define new object r
        System.out.print("Randomly Generated Item Value:  [ "); //Print the randomly generated numbers
        for(int i = 0; i < cost.length; i++) { //For loop for generating random numbers
            cost[i] = r.nextInt(max - min + 1) + min; //Setting minimum and maximum range for random numbers
            System.out.print(cost[i] + " "); //Print statement to end the bracket.
        }
        System.out.print("]\nRandomly Generated Item Weight: [ "); //Print the randomly generated numbers
        for(int i = 0; i < wgt.length; i++) { //For loop for generating random numbers
            wgt[i] = r.nextInt(max - min + 1) + min; //Setting minimum and maximum range for random numbers
            System.out.print(wgt[i] + " "); //Print statement to end the bracket.
        }
        System.out.print("]\n");
    }
}