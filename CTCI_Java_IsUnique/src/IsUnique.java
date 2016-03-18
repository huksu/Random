/**
 * Created by thuskinson on 3/18/2016.
 * Implement an algorithm to determine if a string has all unique characters.
 */

import java.io.*;
import java.util.Hashtable;
import java.util.BitSet;

public class IsUnique {
    public static void main(String [] args)
    {
        IsUnique4(args);
    }

    public static void IsUnique(String [] args){
        String fileName = args[0];

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                Hashtable<String, Integer> myHashTable = new Hashtable<String, Integer>();
                boolean duplicate = false;

                for(int i = 0; i < line.length(); i++){
                    if(myHashTable.get(line.substring(i,i+1)) == null){
                        myHashTable.put(line.substring(i,i+1),1);
                    } else {
                        duplicate = true;
                        break;
                    }
                }

                if(duplicate){
                    System.out.println("Duplicate.");
                } else {
                    System.out.println("No duplicate.");
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    public static void IsUnique2(String [] args){
        String fileName = args[0];

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                // Characters in java are two bytes.  8 bits per byte.
                BitSet bitSet = new BitSet((int)Math.pow(2,2*8));

                boolean duplicate = false;

                for(int i = 0; i < line.length(); i++){
                    if(bitSet.get((int)line.charAt(i)) == false){
                        bitSet.set((int)line.charAt(i), true);
                    } else {
                        duplicate = true;
                        break;
                    }
                }

                if(duplicate){
                    System.out.println("Duplicate.");
                } else {
                    System.out.println("No duplicate.");
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    public static void IsUnique3(String [] args){
        String fileName = args[0];

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                // Characters in java are two bytes.  8 bits per byte.
                boolean[] bitSet = new boolean[(int)Math.pow(2,2*8)];

                boolean duplicate = false;

                for(int i = 0; i < line.length(); i++){
                    if(bitSet[(int)line.charAt(i)] == false){
                        bitSet[(int)line.charAt(i)] = true;
                    } else {
                        duplicate = true;
                        break;
                    }
                }

                if(duplicate){
                    System.out.println("Duplicate.");
                } else {
                    System.out.println("No duplicate.");
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    public static void IsUnique4(String [] args){
        String fileName = args[0];

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                // Characters in java are two bytes.  8 bits per byte.
                boolean[] bitSet = new boolean[(int)Math.pow(2,2*8)];

                boolean duplicate = false;

                for(int i = 0; i < line.length(); i++){
                    if(bitSet[(int)line.charAt(i)] == false){
                        bitSet[(int)line.charAt(i)] = true;
                    } else {
                        duplicate = true;
                        break;
                    }
                }

                if(duplicate){
                    System.out.println("Duplicate.");
                } else {
                    System.out.println("No duplicate.");
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }
}
