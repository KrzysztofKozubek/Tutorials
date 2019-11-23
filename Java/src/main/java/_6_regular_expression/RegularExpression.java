package _6_regular_expression;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Regular expression is a pattern describe a group strings
 * Example:
 * */
public class RegularExpression {
    public static void main(String[] args) {
        String text = "34-346 548-42 5432185 -6546543 3247-4 315-44 32-654 123123123-23423432432";
        String regexPlZipCode = "\\d{2}-\\d{3}";

        Pattern patternPlZipCode = Pattern.compile(regexPlZipCode);
        Matcher matcher = patternPlZipCode.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
