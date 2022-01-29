//Author: Tapas Joshi
//0-1 Knapsack problem with Dynamic programming
//Bottom-up approach


import java.util.Scanner;

public class Knapsack_01_User_Input
{
        //Knapsack method below takes total number of items n as first input, weight of each items, cost of each items and total weight of the knapsack as arguments.
        public static int knapsack ( int n, int wgt[], int cost[], int W) //Knapsack integer method with four arguments
        {
           int i; //Integer for looping
           int j; //Integer for looping
            int K[][] = new int[n + 1][W + 1];
            //Bottom-up approach for dynamic programming
            for (i = 0; i <= n; i++) { //First for loop for iteration
                for (j = 0; j <= W; j++) { //Second for loop for iteration
                    if (i == 0 || j == 0) //Checking if the array is empty or not.
                        K[i][j] = 0; // If empty, then fill 0th value with 0.
                    else if (wgt[i - 1] <= j) { //Check if the second last weight is less than j
                        K[i][j] = Math.max(K[i - 1][j], cost[i - 1] + K[i - 1][j - wgt[i - 1]]); //If it is, then find maximum between Knapsack array K and the sum of cost and knapsack value
                    } else
                        K[i][j] = K[i - 1][j]; //If neither one is the case, then copy the value of i-1 element to K[i][j]
                }
            }
            System.out.println("Maximum value that can fit in weight " + W + " is: " + K[n][W]); //Print results
            return K[n][W]; //Return an integer as the method returns an integer.
        }


        public static void main (String args[]) //Main Method which generates random numbers and give that to the Knapsack method as input.
        {
//
            int n;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the number of items: ");
//reading the number of items from the that we want to enter
            n=sc.nextInt();
//creates an array in the memory of length 10
            int[] cost = new int[10];
            System.out.println("Enter the value of item ");
            for(int i=0; i<n; i++)
            {
//reading array value of items from the user
                cost[i]=sc.nextInt();
            }
            Scanner sc2=new Scanner(System.in);

//creates an array in the memory of length 10
            int[] wgt = new int[10];
            System.out.println("Enter the weight of item ");
            for(int i=0; i<n; i++)
            {
//reading array weight of item from the user
                wgt[i]=sc.nextInt();
            }

            int W;
            Scanner sc1=new Scanner(System.in);
            System.out.print("Enter the total weight of knapsack: ");
//reading the total weight of knapsack from the that we want to enter
            W=sc1.nextInt();

            knapsack(n, wgt, cost, W); //Calling the previously created knapsack method with arguments.
        }
}
