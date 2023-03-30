import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        CusDequeue<Character> deq = new CusDequeue<>();

        for(char c : input.replaceAll(" ", "").toLowerCase().toCharArray()){
            deq.enqueueB(c);
        }

        int length = deq.size;
        boolean isPalindrome = true; //Assume true

        for (int i = 0; i < length / 2; i++){
            if(deq.getF() != deq.getB()){
                isPalindrome = false;
                break;
            }
            deq.removeB();
            deq.removeF();
        }

        System.out.println("The word \"" + input + "\" is " + (isPalindrome ? "" : "not ") + "palindrome");
    }
}