import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner =  new Scanner(System.in);

        //lista representando uma sequencia de numeros de 1 até 75
        List<Integer> bingo = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            bingo.add(i);
        }

        //efeito de "sortear" o codigo, pra nao precisa complicar o codigo, embaralha aqui e percorre a lista normal
        Collections.shuffle(bingo);

        int indice = 0;

        //sorteia os 6 primeiros números automaticamente
        indice = sorteioAutomatico(bingo, 6);

        //a partir do 7º número, volta ao modo manual (pergunta s/n)
        for (int i = indice; i < bingo.size(); i++ ) {
            int numero = bingo.get(i);
            String continuar = perguntar(scanner,  numero);

            while (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.println("Você digitou algo errado. Tente novamente.");
                continuar = perguntar(scanner,  numero);
            }

            if (continuar.equals("n")) {
                System.out.println("Sorteio finalizado.");
                break;
            }
        }
        scanner.close();
    }

    //Sorteia "quantidade" números automaticamente, sem repetir,
    // e retorna o índice de onde o sorteio manual deve continuar
    private static int sorteioAutomatico(List<Integer> bingo, int quantidade) throws InterruptedException {
        System.out.println("Iniciando sorteio automático...");
        int contador = 0;

        while (contador < quantidade && contador < bingo.size()) {
            int numero =  bingo.get(contador);
            System.out.println("Sorteio: " + (contador + 1) + ": número " +  numero);
            Thread.sleep(1000); // pausa de 1 segundo entre cada sorteio automático
            contador++;
        }

        System.out.println("Sorteio automático finalizado!");
        return contador;
    }


    //toLowerCase para que transforme 'S' e 'N' maiusculo pra minusculo
    private static String perguntar (Scanner scanner, int numero) {
        System.out.println("O numero sorteado é: " + numero + ". Deseja continuar? (s/n): ");
        return scanner.nextLine().toLowerCase();

    }
}


