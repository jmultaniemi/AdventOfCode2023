import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) {
        // Source material in text file
        String filePath = "AoC-material.txt";


        try {
            int lineNumber = 0;
            int totalSum = 0;
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                int first = findFirstDigit(line);
                int last = findLastDigit(line);
                int calibrationValue = getFirst(first) + getLast(last);
                totalSum += calibrationValue;
            }
            System.out.printf("Lines: %d\n", lineNumber);
            System.out.printf("Total sum: %d\n", totalSum);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean containsNumberWord(String line, String numberWord) {
        return line.toLowerCase().contains(numberWord.toLowerCase());
    }

    private static String findWrittenNumber(String line) {
        String[] numberWords = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (String word : numberWords) {
            if (containsNumberWord(line, word)) {
                return word;
            }
        }
        return null;
    }
    
    private static int findFirstDigit(String line) {
        char ch = '0';
        String writtenNumber = null;
        for (int index = 0; index < line.length(); index++) {
            ch = line.charAt(index);
            if (Character.isDigit(ch)) {
                return Character.getNumericValue(ch);
            } else if (Character.isLetter(ch)) {
                writtenNumber = findWrittenNumber(line.substring(0, index + 1));
                if (writtenNumber != null) {
                    index += writtenNumber.length() - 1;
                    return convertWrittenNumber(writtenNumber);
                }
            }
        }
        return 0;
    }

    private static int findLastDigit(String line) {
        char ch = '0';
        String writtenNumber = null;
        for (int index = line.length() - 1; index >= 0; index--) {
            ch = line.charAt(index);
            if (Character.isDigit(ch)) {
                return Character.getNumericValue(ch);
            } else if (Character.isLetter(ch)) {
                writtenNumber = findWrittenNumber(line.substring(index));
                if (writtenNumber != null) {
                    index += writtenNumber.length() - 1;
                    return convertWrittenNumber(writtenNumber);
                }
            }
        }
        return 0;
    }

    private static int convertWrittenNumber(String writtenNumber) {
        switch (writtenNumber) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return 0; // Return 0 for unrecognized written numbers
        }
    }

    private static int getFirst(int first) {
        return first * 10;
    }

    private static int getLast(int last) {
        return last;
    }
}


