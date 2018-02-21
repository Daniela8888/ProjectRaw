package raw;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) throws IOException{

        File file = new File("rowText.txt");
        Scanner input = new Scanner(file);


        PrintWriter printWriterMac = new PrintWriter("mac.txt");
        PrintWriter printWriterSpz = new PrintWriter("spz.txt");
        PrintWriter printWriterRc = new PrintWriter("rc.txt") ;
        while (input.hasNext()) {


            String word = input.next();
            Pattern spz = Pattern.compile ("\\c{2}\\d{3}\\c{2}");
            Pattern rc = Pattern.compile ("\\d{2}(([05][1-9])|([16][012]))([0][1-9]|[12]\\d|[3][01])\\/?\\d{4}");
            Pattern mac = Pattern.compile ("[a-fA-F0-9:]{17}|[a-fA-F0-9]{12}") ;
             Matcher c = mac.matcher((String) word);
            Matcher a = spz.matcher((String) word);
            Matcher b = rc.matcher((String) word);


            if (a.matches()) {
                printWriterSpz.println(word);
                System.out.println(word);
            }

            if (b.matches()) {
                printWriterRc.println(word);
                System.out.println(word);
            }

            if (c.matches()) {
                printWriterMac.println(word);
                System.out.println(word);
            }


        }

         printWriterRc.flush();
        printWriterRc.close();
        printWriterSpz.flush();
        printWriterSpz.close();
        printWriterMac.flush();
        printWriterMac.close();
    }

}
