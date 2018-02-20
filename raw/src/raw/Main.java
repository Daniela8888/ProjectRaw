package raw;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args) {


        String fileName = "rowText.txt";

        try {

            byte[] buffer = new byte[1000];

            FileInputStream inputStream = new FileInputStream(fileName);


            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) {

                System.out.println(new String());
                total += nRead;

                Scanner scanner = new Scanner(System.in);
                fileName=scanner.nextLine();

                String pattern= "\\c{2}\d{3}\c{2}" || "\([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})"||    ;
                Pattern r = Pattern.compile(pattern);      //pattern-class
                Matcher m = r.matcher(FileInputStream);
                if (m.find()){
                    System.out.println("SPZ is correct");

                }
                else{
                    throw  ;
                }
            }


            inputStream.close();

            System.out.println("Read " + total + " bytes");
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

