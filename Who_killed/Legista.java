package Who_killed;
import javax.swing.*;


public class Legista {
    public static void main(String[] args) {

        //String nome = JOptionPane.showInputDialog("Digite alguma coisa");
        //JOptionPane.showMessageDialog(null,nome,"teste",JOptionPane.INFORMATION_MESSAGE,null);
        //System.out.println(Investigacao.GREEN + "\nCTTETETETETETET" + Investigacao.RESET);
        final Object[] optionsA = {
                "Ir até ele",
                "Bisbilhotar a sala",
                "Sair da sala"
        };
        final int n = JOptionPane.showOptionDialog(
                null,
                "Você entra na sala do legista e ver o legista distraido em uma canto. O que você faz?",
                "Necrotério",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsA,
                optionsA[2]
        );
        String consequenciaA = "";
        switch (n) {
            case 0:
                consequenciaA = "Então você anda até ele, chegando perto você fala\n" +
                        " - Oi sou o novo investigador tem um minuto?";
                dialogoB(consequenciaA);
                break;
            case 1:
                consequenciaA = "Você entra devagar e sé ve perto de algumas ficha e perto de um corpo";
                dialogoC(consequenciaA);
                break;
            case 2:
                consequenciaA = "Você sai da sala do lesgista";
                dialogoD(consequenciaA);
                break;

        }

    }

    public static void dialogoB(String consequenciaA) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaA,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE,
                null
        );
        final Object[] optionsB = {
                "Gostaria de saber mais sobre o caso",
                "A vítima oque pode falar mais sobre ela",
                "Ah so gostaria de falar um oi"
        };
        final int n = JOptionPane.showOptionDialog(
                null,
                "O legista com uma voz ironia e um pouco debochada fala:\n" +
                        " - Ah o novato, e ai o que quer?",
                "Necrotério",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsB,
                optionsB[2]
        );
        String consequenciaB = "";
        switch (n) {
            case 0:
                consequenciaB = "O legista abre uma gaveta de uma mesa e pega uma ficha do caso." +
                        "\nOlha para você e começa a fala:";
                dialogoB1(consequenciaB);
                break;
            case 1:
                consequenciaB = "O legista levanta e vai até uma mesa com o corpo da vítima, e pega uma ficha ao lado.\n" +
                        "Olha para você e começa a fala:";
                dialogoB2(consequenciaB);
                break;
            case 2:
                consequenciaB = "O legista te olha estranho e fala:\n - Oi. Ta você sabe onde e a porta, to ocupado." +
                        "\nEntão ele vira e volta a fazer oque estava fazendo e você sai da sala.";
                dialogoB3(consequenciaB);
                break;

        }
    }

    public static void dialogoB1(String consequenciaB) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaB,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        final Object[] optionsB1 = {
                "Tem alguma dica de como seria a assasino?",
                "Algum detalhe te chama a ateção nesse caso?"
        };
        final int n = JOptionPane.showOptionDialog(
                null,
                Investigacao.DIALOGO04,
                "Necrotério",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsB1,
                optionsB1[1]
        );
        String consequenciaB1 = "";
        switch (n) {
            case 0:
                consequenciaB1 = Investigacao.DIALOGO05;
                dialogoB1A(consequenciaB1, "Tem alguma dica de como seria a assasino?");
                break;
            case 1:
                consequenciaB1 = Investigacao.DIALOGO06;
                dialogoB1A(consequenciaB1, "Algum detalhe te chama a ateção nesse caso?");
                break;

        }
    }

    public static void dialogoB1A(String consequenciaB1, String pergunta) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaB1,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.out.println(Investigacao.GREEN + "\n" + pergunta + "\n" +
                consequenciaB1 + Investigacao.RESET);
        dialogoE();
    }

    public static void dialogoB2(String consequenciaB) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaB,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        final Object[] optionsB2 = {
                "Fala mais sobre a vítima em sí",
                "Conte mais sobre a morte dele(a)"
        };
        final int n = JOptionPane.showOptionDialog(
                null,
                Investigacao.DIALOGO01,
                "Necrotério",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsB2,
                optionsB2[1]
        );
        String consequenciaB2 = "";
        switch (n) {
            case 0:
                consequenciaB2 = Investigacao.DIALOGO02;
                dialogoB2A(consequenciaB2,"Fala mais sobre a vítima em sí");
                break;
            case 1:
                consequenciaB2 = Investigacao.DIALOGO03;
                dialogoB2A(consequenciaB2,"Conte mais sobre a morte dele(a)");
                break;

        }
    }

    public static void dialogoB2A(String consequenciaB2,String pergunta) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaB2,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE);
                System.out.println(Investigacao.GREEN + "\n" + pergunta + "\n" +
                        consequenciaB2 + Investigacao.RESET);
        dialogoE();
    }


    public static void dialogoB3(String consequenciaB) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaB,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void dialogoC(String consequenciaA) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaA,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        final Object[] optionsC = {
                "Olha o corpo",
                "Ver as fichas"
        };
        final int n = JOptionPane.showOptionDialog(
                null,
                "Você ve que o corpo parece com as decriçoes da vítima da investigação. " +
                        "\nÉ tem uma ficha que bate com nome da vítima.",
                "Necrotério",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsC,
                optionsC[1]
        );
        String consequenciaC = "";
        switch (n) {
            case 0:
                dialogoC1();
                break;
            case 1:
                consequenciaC = Investigacao.DIALOGO07;
                dialogoC2(consequenciaC);
                break;


        }

    }

    public static void dialogoC1() {
        JOptionPane.showMessageDialog(
                null,
                "Você chegar perto do corpo e começa a olha mais perto, mas antes de ver algo você escuta:",
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        dialogoC3();
    }

    public static void dialogoC2(String consequenciaC) {
        JOptionPane.showMessageDialog(
                null,
                "Ao olha mais de perto você encontra um pequeno bilhete em uma ficha do mesmo caso.\n" +
                        "E nele esta escrito:\n" +
                        consequenciaC +
                        "\nMas então você escuta:",
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.out.println(Investigacao.GREEN + "\nUm pequeno bilhete com anotações\n" +
                consequenciaC + Investigacao.RESET);
        dialogoC3();
    }

    public static void dialogoC3() {
        JOptionPane.showMessageDialog(
                null,
                "\n - Ei ta fazendo oque ai!? O legista aqui sou eu sai dai de perto!" +
                        "\nO legista levanta de onde estava e vem em sua direção e começa a falar agrevivamente:" +
                        "\n - Cara tu so pode ser o novato, ta querendo informações do seu caso?. Mas você nao pode so chegar" +
                        "\n mecher nas coisas assim!",
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        dialogoE();
    }


    public static void dialogoD(String consequenciaA) {
        JOptionPane.showMessageDialog(
                null,
                consequenciaA,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void dialogoE() {
        String dialogofinal = "Toc Toc! Você escuta alguem batendo na porta, é um homem jovem abre e fala" +
                "\n - Legista, o capitão ta te chamando lá na sala dele, parece que e urgente" +
                "\nO legista sai com você para fora da sala, e olha pra você e fala:" +
                "\n - Tenho que ir ver oque ele quer, dé uma olhado melhor na sua mesa tem tudo lá";
        JOptionPane.showMessageDialog(
                null,
                dialogofinal,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
