package AssignmentWork;
import java.util.Scanner;
public class VowelAndConsonant {
    public static void main(String args[]){
        char ch;
        boolean isVowel=false;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the character  ");
        ch=scan.next().charAt(0);
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                isVowel=true;
        }
        if(isVowel==true){
            System.out.println(ch+" is a vowel");
        }
        else {
            if ((ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                System.out.println(ch + " is a consonant");
            } else {
                System.out.println(ch + " is not a Alphabets");
            }
        }
    }
}
