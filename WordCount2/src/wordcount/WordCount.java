package wordcount;
import java.util.*;
import java.io.*;

public class WordCount {
    public static void main(String args[]) {  
    	System.out.println("Welcome to the second task of CODSOFT--WORDCOUNT");
        System.out.println("Enter the path of the text file:");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        sc.close();

        try {
            String s = readTextFromFile(filePath);
            
            // Counting words
            int wordCount = countWords(s);
            System.out.println("The number of words: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static String readTextFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static int countWords(String text) {
        int count = 0;
        for (int i = 0; i < text.length() - 1; i++) {
            if ((text.charAt(i) == ' ') && (text.charAt(i + 1) != ' ')) {
                count++;
            }
        }
        return count;
    }
}
