package AssignmentWork;

public class ReverseWordByWord {
    public static void main(String[] args){
        String str="I Am Tom";
        StringBuilder rev= new StringBuilder();
        for(int i=0;i<=str.length()-1;i++)
            rev.insert(0, str.charAt(i));
        System.out.println("Reverse String : " + rev);
    }
}
