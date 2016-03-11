package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String fileName = args[0];
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                String splitString[] = line.split(" \\| ");
                String stringToFind = splitString[0];
                String stringToSearch = splitString[1];

                boolean outerMatch = false;
                for(int i = 0; i < stringToSearch.length() - stringToFind.length() + 1; i++){
                    boolean innerMatch = true;
                    for(int j = 0; j < stringToFind.length(); j++){
                        if(stringToSearch.charAt(i+j) != stringToFind.charAt(j)){
                            innerMatch = false;
                            break;
                        }
                    }

                    if(innerMatch == true){
                        outerMatch = true;
                    }
                }
                if(outerMatch == true){
                    System.out.println("True");
                } else {
                    System.out.println("False");
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
