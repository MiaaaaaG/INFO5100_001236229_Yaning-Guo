import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String subject1 = "DoDo is the cutest puppy in the world.";
        String subject2 = "Hello, world!";
        String subject3 = "123-45-6789";
        String subject4 = "email@example.com";
        String subject5 = "http://www.example.com";

        // Pattern 1: Matching a word containing at least one vowel
        Pattern pattern1 = Pattern.compile("\\b\\w*[aeiou]\\w*\\b");
        Matcher matcher1 = pattern1.matcher(subject1);
        System.out.println("Pattern 1: Matching a word containing at least one vowel");
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }
        System.out.println();

        // Pattern 2: Matching a string starting with "Hello"
        Pattern pattern2 = Pattern.compile("^Hello");
        Matcher matcher2 = pattern2.matcher(subject2);
        System.out.println("Pattern 2: Matching a string starting with \"Hello\"");
        if (matcher2.find()) {
            System.out.println("Match found: " + matcher2.group());
        } else {
            System.out.println("No match found.");
        }
        System.out.println();

        // Pattern 3: Matching a string in the format of a Social Security number (SSN)
        Pattern pattern3 = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
        Matcher matcher3 = pattern3.matcher(subject3);
        System.out.println("Pattern 3: Matching a string in the format of a Social Security number (SSN)");
        if (matcher3.find()) {
            System.out.println("Match found: " + matcher3.group());
        } else {
            System.out.println("No match found.");
        }
        System.out.println();

        // Pattern 4: Matching a string in the format of an email address
        Pattern pattern4 = Pattern.compile("\\b[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}\\b");
        Matcher matcher4 = pattern4.matcher(subject4);
        System.out.println("Pattern 4: Matching a string in the format of an email address");
        if (matcher4.find()) {
            System.out.println("Match found: " + matcher4.group());
        } else {
            System.out.println("No match found.");
        }
        System.out.println();

        // Pattern 5: Matching a string in the format of a URL
        Pattern pattern5 = Pattern.compile("\\bhttps?://[\\w.-]+\\.[A-Za-z]{2,}\\b");
        Matcher matcher5 = pattern5.matcher(subject5);
        System.out.println("Pattern 5: Matching a string in the format of a URL");
        if (matcher5.find()) {
            System.out.println("Match found: " + matcher5.group());
        } else {
            System.out.println("No match found.");
        }
        System.out.println();
    }
}
