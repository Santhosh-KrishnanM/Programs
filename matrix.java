//Matrix 
import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("=== Matrix Operations ===");
            System.out.println("1. Matrix Addition");
            System.out.println("2. Find the Normal and Trace of a Matrix");
            System.out.println("3. Find the Determinant of a Matrix");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    performMatrixAddition(scanner);
                    break;
                case 2:
                    performNormalAndTrace(scanner);
                    break;
                case 3:
                    performDeterminant(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 4.");
            }
            System.out.println();
        } while(choice != 4);
        
        scanner.close();
    }
    
    // Method to perform matrix addition
    public static void performMatrixAddition(Scanner scanner) {
        System.out.println("--- Matrix Addition ---");
        System.out.print("Enter number of rows of matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns of matrices: ");
        int cols = scanner.nextInt();
        
        System.out.println("Enter elements of first matrix:");
        int[][] matrixA = readMatrix(scanner, rows, cols);
        
        System.out.println("Enter elements of second matrix:");
        int[][] matrixB = readMatrix(scanner, rows, cols);
        
        int[][] result = addMatrices(matrixA, matrixB);
        
        System.out.println("Resultant Matrix after Addition:");
        printMatrix(result);
    }
    
    // Method to perform calculation of normal and trace
    public static void performNormalAndTrace(Scanner scanner) {
        System.out.println("--- Normal and Trace of a Matrix ---");
        System.out.print("Enter the size of square matrix: ");
        int size = scanner.nextInt();
        
        System.out.println("Enter elements of the matrix:");
        int[][] matrix = readMatrix(scanner, size, size);
        
        double normal = calculateNormal(matrix);
        int trace = calculateTrace(matrix);
        
        System.out.println("Normal of the matrix: " + normal);
        System.out.println("Trace of the matrix: " + trace);
    }
    
    // Method to perform determinant calculation
    public static void performDeterminant(Scanner scanner) {
        System.out.println("--- Determinant of a Matrix ---");
        System.out.print("Enter the size of square matrix: ");
        int size = scanner.nextInt();
        
        System.out.println("Enter elements of the matrix:");
        int[][] matrix = readMatrix(scanner, size, size);
        
        int determinant = calculateDeterminant(matrix, size);
        
        System.out.println("Determinant of the matrix: " + determinant);
    }
    
    // Method to read matrix elements from user
    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        return matrix;
    }
    
    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        
        return result;
    }
    
    // Method to calculate the normal of a matrix
    public static double calculateNormal(int[][] matrix) {
        int sum = 0;
        for(int[] row : matrix) {
            for(int element : row) {
                sum += element * element;
            }
        }
        return Math.sqrt(sum);
    }
    
    // Method to calculate the trace of a matrix
    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for(int i=0; i<matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    // Method to calculate determinant of a matrix
    public static int calculateDeterminant(int[][] matrix, int n) {
        int determinant = 0;
        
        // Base case for 2x2 matrix
        if(n == 1) {
            return matrix[0][0];
        }
        if(n == 2) {
            return (matrix[0][0]*matrix[1][1]) - (matrix[0][1]*matrix[1][0]);
        }
        
        int sign = 1;
        for(int i=0; i<n; i++) {
            int[][] subMatrix = getSubMatrix(matrix, 0, i, n);
            determinant += sign * matrix[0][i] * calculateDeterminant(subMatrix, n-1);
            sign = -sign;
        }
        
        return determinant;
    }
    
    // Method to get submatrix for determinant calculation
    public static int[][] getSubMatrix(int[][] matrix, int excludingRow, int excludingCol, int n) {
        int[][] subMatrix = new int[n-1][n-1];
        int row = 0;
        for(int i=0; i<n; i++) {
            if(i == excludingRow)
                continue;
            int col = 0;
            for(int j=0; j<n; j++) {
                if(j == excludingCol)
                    continue;
                subMatrix[row][col] = matrix[i][j];
                col++;
            }
            row++;
        }
        return subMatrix;
    }
    
    // Method to print matrix
    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }
}
