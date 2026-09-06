import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        List<Integer> bingo = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            bingo.add(i);
        }

        Collections.shuffle(bingo);

        for (int numero : bingo) {
            String continuar = perguntar(scanner,  numero);

            while (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.println("Você digitou algo errado. Tente novamente.");
                continuar = perguntar(scanner,  numero);
            }

            if (continuar.equals("n")) {
                break;
            }
        }
        scanner.close();
    }

    private static String perguntar (Scanner scanner, int numero) {
        System.out.println("O numero sorteado é: " + numero + ". Deseja continuar? (s/n): ");
        return scanner.nextLine().toLowerCase();

    }
}


