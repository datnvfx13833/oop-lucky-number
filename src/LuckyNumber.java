import java.util.Scanner;
//import java.util.Arrays;
public class LuckyNumber {
    //Tạo hàm play()
    public static int play(int max){
        int r = (int) (Math.random()*(max + 1));
        int num = -1;
        int count = 0;
        //System.out.println(r);
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("You guess? ");
            num = sc.nextInt();
            count++;
            if(num > r){
                System.out.println("Lucky number is less than your prediction");
            } else if(num < r){
                System.out.println("Lucky number is greater than your prediction");
            }
        } while (num != r);

        System.out.println("Congratulations, you guessed the correct number after "+count+" times!");

        return count;
    }

    //Tạo hàm report()
    public static void report(int tGames, int tGuess, int bestGame){
        double trungbinh = (double) tGuess/tGames;
        System.out.println("Result: ");
        System.out.println("Total number of times played  = "+tGames);
        System.out.println("Total number of predictions = "+tGuess);
        System.out.println("Average number of guesses per turn = "+Math.ceil(trungbinh*10.0)/10.0);
        System.out.println("Minimum number of predictions    = "+ bestGame);
    }

    public static void main(String[] args){
        int max = 100;
        Scanner sc = new Scanner(System.in);
        String[] key = {"y", "Y", "yes", "YES", "Yes"};
        String ans = "";
        int bienLuuTru = 0;
        int tGames = 0;
        int tGuess = 0;
        int bestGame = 10000;

        System.out.println("I'm thinking a number between 0 and " + max +"...");

        do {
            bienLuuTru= play(max);
            tGames++;
            tGuess += bienLuuTru;
            if(bestGame >= bienLuuTru){
                bestGame = bienLuuTru;
            }
            System.out.print("Do you want to continue playing?");
            ans = sc.next();
        } while (ans.equals(key[0])||ans.equals(key[1])||ans.equals(key[2])||ans.equals(key[3])||ans.equals(key[4]));

        report(tGames,tGuess,bestGame);
    }
}
