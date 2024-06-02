// Name = Areesha Kaleem
// roll no = 2022-CE-15

import java.util.Random;
import java.util.Scanner;

class Hangman {
    private static String[] EASY = {"cat", "dog", "fish", "bird", "moon", "star", "tree", "frog", "rose"};
    private static String[] MEDIUM = {"apple", "banana", "orange", "grapes", "elephant", "giraffe", "cheetah", "penguin", "octopus"};
    private static String[] HARD = {"avocado", "pineapple", "blueberry", "strawberry", "alligator", "crocodile", "watermelon", "raspberry"};
    private static int warnings = 4;
    private static String toguess;
    public static String tofill;
    private static int guesses;
    private static String av_letters = "abcdefghijklmnopqrstuvwxyz";

    Hangman(String level) {
        Random rn = new Random();
        if (level == "Easy") {
            int toguessindex = rn.nextInt(EASY.length);
            toguess = EASY[toguessindex];
        } else if (level == "Medium") {
            int toguessindex = rn.nextInt(MEDIUM.length);
            toguess = MEDIUM[toguessindex];
        } else if (level == "Hard") {
            int toguessindex = rn.nextInt(HARD.length);
            toguess = HARD[toguessindex];
        }
        guesses = (int) (1.5 * toguess.length());
        for (int j = 0; j < toguess.length(); j++) {
            tofill = "_".repeat(toguess.length());
        }
    }
    public void Toplay() {
        char[] tofillChars = tofill.toCharArray();
        System.out.printf("\nI am thinking of a %d-letter word!", toguess.length());
        System.out.printf("\nYou have %d warnings left", warnings);

        while (guesses > 0 && !tofill.equals(toguess)) {
            System.out.print("\n------------");
            System.out.printf("\nYou have %d guesses left", guesses);
            System.out.printf("\nAvailable letters = %s", av_letters);

            Scanner sc = new Scanner(System.in);
            System.out.print("\nPlease guess a letter: ");
            String answer = sc.nextLine().toLowerCase();

            if (av_letters.contains(answer)) {
                guesses -= 1;
                int delindex = av_letters.indexOf(answer);
                StringBuilder builder = new StringBuilder(av_letters);
                builder.deleteCharAt(delindex);
                av_letters = builder.toString();

                boolean correctGuess = false;

                for (int k = 0; k < toguess.length(); k++) {
                    if (toguess.charAt(k) == answer.charAt(0) && tofillChars[k] == '_') {
                        tofillChars[k] = answer.charAt(0);
                        correctGuess = true;
                    }
                }

                tofill = new String(tofillChars);

                if (correctGuess) {
                    System.out.println("Good Guess: " + tofill);
                } else {
                    System.out.println("Oops! That letter is not in my word.😫");
                    System.out.println(tofill);
                }
            } else {
                warnings -= 1;
                System.out.printf("Oops! You've already guessed that letter.😇 You have %d warnings left: %s", warnings, tofill);
            }
        }

        if (tofill.equals(toguess)) {
            System.out.println("Congratulations! you won.🎉");
        } else {
            System.out.println("Game over!🤪");
            System.out.println("Try better next time.☹");
        }
    }
}




public class Hman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lvl = "null";
        System.out.println("Welcome to Hangman!");
        System.out.println("Which level you wanna play:\n1.Easy\n2.Medium\n3.Hard\n4.Exit\n");
        int option = sc.nextInt();
        switch (option){
            case 1:
                lvl = "Easy";
                break;
            case 2:
                lvl = "Medium";
                break;
            case 3:
                lvl = "Hard";
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("invalid input");
                return;
        }
        Hangman player1 = new Hangman(lvl);
        player1.Toplay();
    }
}

