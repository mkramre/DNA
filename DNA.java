//Morgan Kramer
//11/17/2021
//CS 141 
//This program outputs a file that displays 
//varies information about DNA samples


import java.util.*;
import java.io.*;


public class DNA {
   public static double[] masses = {135.128, 111.103, 151.128, 125.107, 100.000};

   public static void main(String[] args) throws FileNotFoundException {
      //Lines  14- 22 prompt the user to input filenames, makes a string with the filename,
      //Make File objects based on the string, and makes a scanner using the file object
      //So that we can read and perhaps even write to the files if we're feeling zesty.
      Scanner console = new Scanner(System.in);
      
      System.out.print("Type an input filename. Don't forget the .txt! ");
      String inputFileStr = console.nextLine();
      File inputFile = new File(inputFileStr);
      Scanner input = new Scanner(inputFile);
      
      System.out.print("Type an output filename. Slap that .txt in there. ");
      String outputFileStr = console.nextLine();
      File outputFile = new File(outputFileStr);
      PrintStream output = new PrintStream(outputFile);
      
      int i = 0;
      int countACGT[] = new int[5];
      while(input.hasNextLine()){
         i++;
         String line = input.nextLine();
         if(i % 2 == 0) {
            output.println("Region Name: " + line);  
          }
          else {
             count(line, output);
             mass(countACGT, output);
          }
       }
    }

      
//This takes the string that we give it and then counts the number of each
// letter and dashes then saves those numbers into an array      
     public static void count(String line, PrintStream output) {
//This loop runs until we've scanned every line of our input file
              output.println("Nucleotides: " + line);
              int A = 0;
              int C = 0;
              int G = 0;
              int T = 0;
              int junk = 0;
              for(int i = 0; i < line.length(); i++) {
                 if (line.charAt(i) == 'A') {
                    A ++;
                 }
                 else if (line.charAt(i) == 'C') {
                    C ++;
                 }
                 else if (line.charAt(i) == 'G') {
                    G ++;
                 }
                 else if (line.charAt(i) == 'T') {
                    T ++;
                 }
                 else if (line.charAt(i) == '-') {
                    junk ++;
                 }       
              }
           int[] countACGT = {A, C, G, T, junk};
           output.println("Nuc counts: [" + A + ", " + C + ", " + G + ", " + T + "]");
        }
// takes the number of each Nuc and multiplies it by the corresponding Nuc 
//and prints the total masses based on that
   public static void mass(int[] countACGT, PrintStream output) {
      double nucMasses[] = new double [5];
      double totalMass = 0;
      for (int i = 0; i < 4; i++) {
         nucMasses[i] = countACGT[i] * masses[i];
         totalMass = totalMass + nucMasses[i];
      }
      output.println("TotalMass%: [" + nucMasses[0] + ", " + nucMasses[1] + ", " + nucMasses[2] + ", " + nucMasses[3] + ", " + nucMasses[4] + "] of " + totalMass);
      }
   }