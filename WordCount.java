import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class WordCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String input;
        String text;
        String[] words;
        int count;


        System.out.println("Welcome to the Word Count Program!");
        System.out.println("This program will count the number of words in a text or a file.");
        System.out.println("You can enter a text directly or provide a file name.");


        System.out.print("Enter a text or a file name: ");
        input = scanner.nextLine();


        if (input.endsWith(".txt")) {

            try {

                File file = new File(input);


                Scanner fileScanner = new Scanner(file);


                text = fileScanner.useDelimiter("\\A").next();


                fileScanner.close();
            }
            catch (FileNotFoundException e) {

                System.out.println("The file " + input + " was not found.");
                System.out.println("Please check the file name and try again.");
                return;
            }
        }
        else
        {
            text = input;
        }
        words = text.split("[\\s\\p{Punct}]+");
        count = 0;
        for (String word : words) {

            if (!word.isEmpty()) {

                count++;
            }
        }


        System.out.println("The total number of words is " + count + ".");
    }
}
