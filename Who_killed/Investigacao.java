package Who_killed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Investigacao {
    static Scanner ler = new Scanner(System.in);
    static String CULPADO, CAMINHO, RESUMO1, RESUMO2, DIALOGO01, DIALOGO02, DIALOGO03;
    static boolean SUCESSO = true;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        CAMINHO = "C:\\Users\\2022101202010198\\Documents\\GitHub\\whokilled\\Who_killed\\Crime00.txt";
        String espacos = "\n------------------------------------------\n";
        System.out.println(espacos);
        pistasDoCrime(); //Esse e o metodo que vai imprimir as pistas do crime
        System.out.println(espacos);
        falaComLegista(); //Esse e o metdo que vai imprimir as gravaçoes do legista
        System.out.println(espacos);
        vereditoDoCaso(); //Esse e o metodo que vai fazer o chute de quem e o assasino
        System.out.println(espacos);
        epilogo(); //Esse e o metodo final que vai falar se voce acertou ou nao e imprimir o resumo
        System.out.println(espacos);

    }

    public static void pistasDoCrime() throws FileNotFoundException {
        Scanner input = new Scanner(new File(CAMINHO));
        CULPADO = input.nextLine();
        RESUMO1 = input.nextLine();
        RESUMO2 = input.nextLine();
        DIALOGO01 = input.nextLine();
        DIALOGO02 = input.nextLine();
        DIALOGO03 = input.nextLine();
        while (input.hasNext()) {
            System.out.println(input.nextLine());
        }
    }

    public static void falaComLegista() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Depois de ler a ficha do crime, você decide ir ver o legista.\n" +
                "Mas ao chegar você encontra apenas seu gravador que esta sobe a ficha \ndo caso com 2 gravaçoes salvas" +
                ".Será que devo ouvir as gravações?");

        while (true) {
            String resposta = ler.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println(" Legista - FALA O DIALOGO 1" +
                        "\n Legista - FALA O DIALOGO 2");
                Thread.sleep(3000);
                return;
            } else if (resposta.equalsIgnoreCase("nao")) {
                System.out.println("Acho melhor nao mecher nas coisas alheias");
                return;
            } else {
                System.out.println("As vezes preciso confimar comigo mesmo com palavras simples com 'sim' ou 'nao'");
            }

        }

    }

    public static void vereditoDoCaso() throws InterruptedException {
        System.out.println(RESUMO1);
        Thread.sleep(3000);
        System.out.println("Você fica um tempo mais olhado a ficha e então sente que sabe o necessario para mostrar o culpado do crime" +
                "Eu - Certo conseguir provas o suficente para indentificar o assasino." +
                "\n O culpado esta entre essas pessoas\n" +
                " -Suspeito01\n -Suspeito02\n -Suspeito03\n -Suspeito04\n E o culpado so poder ser o ");
        while (SUCESSO) {
            String chute = ler.nextLine();
            if (chute.equalsIgnoreCase("culpado")) {
                System.out.println("Sim, e ele mesmo");
                SUCESSO = true;
                return;
            } else if (chute.equalsIgnoreCase("suspeito02")) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else if (chute.equalsIgnoreCase("suspeito03")) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else if (chute.equalsIgnoreCase("suspeito04")) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            }else {
                System.out.println("Oque esse nome nao esta na lista de suspeitos, nao deve ser um desse");
            }
        }
    }
    public static void epilogo(){
        if(SUCESSO){
            System.out.println("Seu papite estava CERTO");
        }else {
            System.out.println("Seu papite estava ERRADO");
        }
        System.out.println(RESUMO2);
    }
}