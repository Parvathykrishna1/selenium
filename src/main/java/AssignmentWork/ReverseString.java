package AssignmentWork;
import java.util.regex.Pattern;
public class ReverseString {
    public static void main(String[] args) {
        String s1 = "I Am Tom";
        Pattern pattern = Pattern.compile(" ");
        String[] temp = pattern.split(s1);
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        System.out.println(result);
    }
}
