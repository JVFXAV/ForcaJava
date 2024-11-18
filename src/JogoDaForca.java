import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array de palavras possíveis
        String[] palavras = {"JAVA", "PROGRAMACAO", "COMPUTADOR", "SOFTWARE", "DESENVOLVEDOR", "SISTEMA"};

        // Selecionar uma palavra aleatória
        String palavraSecreta = gerarPalavraAleatoria(palavras).toUpperCase();
        char[] palavra = palavraSecreta.toCharArray();
        char[] exibicao = new char[palavra.length];
        for (int i = 0; i < exibicao.length; i++) {
            exibicao[i] = '_';
        }

        int tentativasRestantes = 6; // Número de tentativas permitidas
        boolean venceu = false;

        System.out.println("Bem-vindo ao Jogo da Forca!");

        while (tentativasRestantes > 0 && !venceu) {
            System.out.println("\nPalavra: " + String.valueOf(exibicao));
            desenharForca(tentativasRestantes);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char tentativa = scanner.nextLine().toUpperCase().charAt(0);

            boolean acerto = false;
            for (int i = 0; i < palavra.length; i++) {
                if (palavra[i] == tentativa && exibicao[i] == '_') {
                    exibicao[i] = tentativa;
                    acerto = true;
                }
            }

            if (!acerto) {
                tentativasRestantes--;
                System.out.println("Letra incorreta!");
            } else {
                System.out.println("Boa! Você acertou uma letra!");
            }

            // Verificar se venceu
            venceu = String.valueOf(exibicao).equals(palavraSecreta);
        }

        if (venceu) {
            System.out.println("\nParabéns! Você venceu!");
            System.out.println("A palavra era: " + palavraSecreta);
        } else {
            desenharForca(0);
            System.out.println("\nVocê perdeu! A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }

    // Método para gerar uma palavra aleatória
    private static String gerarPalavraAleatoria(String[] palavras) {
        Random random = new Random();
        int index = random.nextInt(palavras.length);
        return palavras[index];
    }

    // Método para desenhar a forca
    private static void desenharForca(int tentativas) {
        System.out.println(" +---+");
        System.out.println(" |   |");

        if (tentativas <= 5) {
            System.out.println(" O   |");
        } else {
            System.out.println("     |");
        }

        if (tentativas <= 4) {
            if (tentativas == 4) {
                System.out.println(" |   |");
            } else if (tentativas <= 3) {
                System.out.println("/|   |");
            } else {
                System.out.println("/|\\  |");
            }
        } else {
            System.out.println("     |");
        }

        if (tentativas <= 2) {
            if (tentativas == 2) {
                System.out.println("/    |");
            } else {
                System.out.println("/ \\  |");
            }
        } else {
            System.out.println("     |");
        }

        System.out.println("     |");
        System.out.println("=====");
    }
}
