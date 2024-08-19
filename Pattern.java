package Programs;

import java.util.Scanner;

class Pattern
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        int k=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(k=1; k<=i;k++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}