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
                "Ao entrar na sala você tem que tomar um decisão: ",
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
                consequenciaA = "Chegando até ele, você diz: \n" +
                        " - Posso tomar um minuto do seu tempo? Acabei de ser transferido para esse caso.";
                dialogoB(consequenciaA);
                break;
            case 1:
                consequenciaA = "Analisando tudo, você encontra uma ficha que está do lado de um corpo. Dentro dela tem uma ficha.";
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
                "Com tom irônico o legista diz: \n" +
                        " - Ah o novato, o que quer aqui?",
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
                consequenciaB = "O legista abre e pega de dentro de uma gaveta uma ficha sobre o caso." +
                        "\nE começa a falar com você: ";
                dialogoB1(consequenciaB);
                break;
            case 1:
                consequenciaB = "O legista levanta e vai até uma mesa com o corpo da vítima, e pega uma ficha ao lado.\n" +
                        "Olha para você e começa a fala:";
                dialogoB2(consequenciaB);
                break;
            case 2:
                consequenciaB = "O legista te olha estranho e fala:\n - Oi. Tá você sabe onde e a porta, to ocupado." +
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
                "Tem alguma dica de como seria o assasino?",
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
                dialogoB2A(consequenciaB2,"Fale mais sobre a vítima em sí");
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
                "Olhar o corpo",
                "Ver as fichas"
        };
        final int n = JOptionPane.showOptionDialog(
                null,
                "O corpo e a ficha batem com as informações recebidas anteriormente sobre a vítima do caso. " +
                        "\n",
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
                "Quando você começa a olhar o corpo mais de perto, escuta uma voz dizendo: ",
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
                "\n - Tá fazendo o que aqui? Pode ir saindo de perto." +
                        "\nO legista vem em sua direção e começa a falar agressivamente: " +
                        "\n - Você só pode ser o novato, ta querendo informações do seu caso?. Você não pode só chegar" +
                        "\n e ir mexendo nas coisas assim!",
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
        String dialogofinal = "Toc Toc! Você escuta alguem batendo na porta, um jovem abre e fala: " +
                "\n - Legista, o capitão esta te chamando na sala dele, parece ser urgente!" +
                "\nVocê acompanha o legista até a parte de fora da sala, ele olha para você e diz: " +
                "\n - Tenho que ir ver oque ele quer, tudo que precisa está na sua mesa.";
        JOptionPane.showMessageDialog(
                null,
                dialogofinal,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
