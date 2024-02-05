import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random; 
import java.util.Scanner; 
public class BubbleSort {

    public static int[] createRandomArray(int arrayLength) {  
        Random randomnumbers = new Random();  
        int[] array = new int[arrayLength]; 
        for (int i = 0; i < arrayLength; i++) {
            array[i] = randomnumbers.nextInt(101); 
            System.out.print(array[i] + " "); 
        }
        
        return array;  
    } 

    public static void writeArrayToFile( int[] array, String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true)); 
        for (int i = 0; i < array.length; i++) {
           writer.write(array[i] + "");
           writer.newLine(); 
        }
        writer.close(); 
        
    }

    public static void writeArrayToFile2( int[] array, String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename)); 
        for (int i = 0; i < array.length; i++) {
           writer.write(array[i] + "");
           writer.newLine(); 
        }
        writer.close(); 
        
    }

    public static int[] readFileToArray(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line; 
        int num = 0; 
        
        while ((line = reader.readLine()) != null) {
            num++;          
        }
        reader.close();
        reader = new BufferedReader(new FileReader(filename));
        int[] array = new int[num]; 
        int num2 = 0; 
        while ((line = reader.readLine()) != null) {  
            array[num2] = Integer.parseInt(line); 
            num2++; 
         }
            reader.close();
            return array; 
    } 
    public static void bubbleSort(int[] array){
        int[] swap = new int[array.length]; 
        for (int i = 0; i < array.length; i++){
            for (int h = i+1; h < array.length; h++){
                if (array[i] > array[h]){
                    swap[h] = array[i];
                    array[i] = array[h]; 
                    array[h] = swap[h]; 
                }
            }
        }
            for (int k = 0; k < array.length; k++){
                System.out.print(array[k] + " "); 
            }
    }

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Make a selection\n1.Generate a Random Array and store it in a file\n2.Read an existing file and store it in another file");  
        int selection = input.nextInt(); 
        if (selection == 1){
            System.out.print("Enter the length of the array: ");  
            int length = input.nextInt();
            System.out.print("Array: "); 
            int array1[] = createRandomArray(length); 
            System.out.println("\nEnter a valid filename: ");
            input.nextLine(); 
            String filename = input.nextLine();
            writeArrayToFile(array1, filename);
        }   
        if (selection == 2){
            System.out.println("Enter a valid filename: "); 
            input.nextLine(); 
            String filename = input.nextLine();
            int[] array2 = readFileToArray(filename);
            System.out.print("Array before being sorted: ");        
            for (int j =0; j < array2.length; j++){
                System.out.print(array2[j] + " "); 
            }
            System.out.print("\nThe sorted array is: ");
            bubbleSort(array2);  
            writeArrayToFile2(array2, "Array2.txt"); 
            input.close();         
        }  
    }
}
