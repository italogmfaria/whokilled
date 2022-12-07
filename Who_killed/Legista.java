package Who_killed;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;


public class Legista {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

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
                /*consequenciaA = "Chegando até ele, você diz:
                        - Posso tomar um minuto do seu tempo?Acabei de ser transferido para esse caso. ";
                dialogoB(consequenciaA);*/

                String tituloLeituraA1 = "Ir até ele";
                String textoLeituraA1 = """
                        Chegando até ele, você diz: 
                                - Posso tomar um minuto do seu tempo? Acabei de ser transferido para esse caso.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraA_1.wav", textoLeituraA1, tituloLeituraA1);
                dialogoB();
                break;
            case 1:
                /*consequenciaA = "Analisando tudo, você encontra uma ficha que está do lado de um corpo. Dentro dela tem uma ficha.";
                dialogoC(consequenciaA);*/

                String tituloLeituraA2 = "Bisbilhotar a sala";
                String textoLeituraA2 = """
                        Ao analisar tudo, você encontra uma ficha que está do lado de um corpo.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraA_2.wav", textoLeituraA2, tituloLeituraA2);
                dialogoC();
                break;
            case 2:
                /*consequenciaA = "Você sai da sala do lesgista";
                dialogoD(consequenciaA);*/
                String tituloLeituraA3 = "Sair da sala";
                String textoLeituraA3 = """
                        Você sai da sala do legista.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraA_3.wav", textoLeituraA3, tituloLeituraA3);
                break;

        }

    }

    public static void dialogoB() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsB = {
                "Gostaria de saber mais sobre o caso",
                "A vítima oque pode falar mais sobre ela",
                "Ah so gostaria de falar um oi"
        };
        String textoLeituraB ="""
                 Com tom irônico o legista diz: 
                 - E ai novato, o que quer aqui?""";
        String tituloLeituraB = "Um minuto do seu tempo?";
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraB.wav",optionsB,textoLeituraB,tituloLeituraB)) {
            case 0:
                String tituloLeituraB_1 = "Mais sobre o caso";
                String textoLeituraB_1 = """
                        O legista abre e pega de dentro de uma gaveta uma ficha sobre o caso.
                        E começa a falar com você:
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraB_1.wav", textoLeituraB_1, tituloLeituraB_1);
                dialogoB1();
                break;
            case 1:
                String tituloLeituraB_2 = "Mais sobre a vítima";
                String textoLeituraB_2 = """
                        O legista levanta e vai até uma mesa com o corpo da vítima, e pega uma ficha ao lado.
                        Olha para você e começa a falar:
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraB_2.wav", textoLeituraB_2, tituloLeituraB_2);
                dialogoB2();
                break;
            case 2:
                String tituloLeituraB_3 = "Mais sobre a vítima";
                String textoLeituraB_3 = """
                        O legista te olha estranho e fala:
                        - Oi. Tá você sabe onde e a porta, to ocupado.
                        Então ele vira e volta a fazer oque estava fazendo e você sai da sala.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraB_3.wav", textoLeituraB_3, tituloLeituraB_3);
                break;

        }
    }

    public static void dialogoB1() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsB1 = {
                "Tem alguma dica de como seria o assasino?",
                "Algum detalhe te chama a ateção nesse caso?"
        };
        String textoLeituraB1 =Investigacao.DIALOGO04;
        String tituloLeituraB1 = "Uma ficha na gaveta";
        String consequenciaB1;
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraCrime00_0.wav",optionsB1,textoLeituraB1,tituloLeituraB1)){
            case 0:
                String tituloLeituraB_3 = "Como seria o assasino?";
                consequenciaB1 = Investigacao.DIALOGO05;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraCrime00_0.wav", consequenciaB1, tituloLeituraB_3);
                System.out.println(Investigacao.GREEN + "\n" + "Tem alguma dica de como seria o assasino?" + "\n" +
                        consequenciaB1 + Investigacao.RESET);
                dialogoE();
                break;
            case 1:
                consequenciaB1 = Investigacao.DIALOGO06;
                dialogoB1A(consequenciaB1, "Algum detalhe te chama a ateção nesse caso?");
                break;

        }
    }

    public static void dialogoB1A(String consequenciaB1, String pergunta) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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

    public static void dialogoB2() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
                dialogoB2A(consequenciaB2, "Fale mais sobre a vítima em sí");
                break;
            case 1:
                consequenciaB2 = Investigacao.DIALOGO03;
                dialogoB2A(consequenciaB2, "Conte mais sobre a morte dele(a)");
                break;

        }
    }

    public static void dialogoB2A(String consequenciaB2, String pergunta) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        JOptionPane.showMessageDialog(
                null,
                consequenciaB2,
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE);
        System.out.println(Investigacao.GREEN + "\n" + pergunta + "\n" +
                consequenciaB2 + Investigacao.RESET);
        dialogoE();
    }
    public static void dialogoC() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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

    public static void dialogoC1() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        JOptionPane.showMessageDialog(
                null,
                "Quando você começa a olhar o corpo mais de perto, escuta uma voz dizendo: ",
                "Necrotério",
                JOptionPane.INFORMATION_MESSAGE
        );
        dialogoC3();
    }

    public static void dialogoC2(String consequenciaC) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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

    public static void dialogoC3() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String tituloLeituraC3 = "Necrotério";
        String textoLeituraC3 = """
                - Tá fazendo o que aqui? Pode ir saindo de perto.
                 O legista vem em sua direção e começa a falar agressivamente:
                - Você só pode ser o novato, ta querendo informações do seu caso?. Você não pode só chegar
                   e ir mexendo nas coisas assim!
                 """;
        Who_killed.ReprodutorAudio.leitura("Audios/LeituraC_3.wav", textoLeituraC3, tituloLeituraC3);
        dialogoE();
    }

    public static void dialogoE() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String tituloLeituraE = "Necrotério";
        String textoLeituraE = """
                Toc Toc! Você escuta alguem batendo na porta, um jovem abre e fala:
                 - Legista, o capitão esta te chamando na sala dele, parece ser urgente!
                Você acompanha o legista até de fora da sala, ele olha para você e diz: 
                 - Tenho que ir ver oque ele quer, tudo que precisa está na sua mesa.
                 """;
        Who_killed.ReprodutorAudio.leitura("Audios/LeituraE.wav", textoLeituraE, tituloLeituraE);
    }
}
