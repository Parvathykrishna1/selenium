package AssignmentWork;

public class ReverseWord {
    public  static void main(String[] args){
        String str="Mango";
        StringBuilder rev= new StringBuilder();
        int len=str.length();
        for(int i=0;i<=len-1;i++)
            rev.insert(0, str.charAt(i));
        System.out.println("Reversed String:"+rev);
    }
}
