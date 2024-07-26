import java.util.Scanner;

public class JogoDaVelha {
    private char[][] tabuleiro;
    private int totalPartidas;
    private int pontosJogador1;
    private int pontosJogador2;
    private String jogador1;
    private String jogador2;

    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        totalPartidas = 0;
        pontosJogador1 = 0;
        pontosJogador2 = 0;
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private void mostrarTabuleiro() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    private void mostrarPlacar() {
        System.out.println("Placar:");
        System.out.println(jogador1 + ": " + pontosJogador1);
        System.out.println(jogador2 + ": " + pontosJogador2);
        System.out.println("Total de partidas: " + totalPartidas);
    }

    private void apresentar() {
        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Comandos: ");
        System.out.println("Para sair do jogo, pressione 'q'.");
    }

    private boolean jogadaValida(String jogada) {
        if (jogada.length() != 3) return false;
        char linha = jogada.charAt(0);
        char coluna = jogada.charAt(1);
        char simbolo = jogada.charAt(2);

        if (linha < '0' || linha > '2' || coluna < '0' || coluna > '2') return false;
        if (simbolo != 'X' && simbolo != '0') return false;
        if (tabuleiro[linha - '0'][coluna - '0'] != ' ') return false;

        return true;
    }

    private boolean verificarVencedor(char simbolo) {
        // Verificar linhas, colunas e diagonais
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) return true;
            if (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo) return true;
        }
        if (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) return true;
        if (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo) return true;

        return false;
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);

        apresentar();
        System.out.print("Nome do Jogador 1: ");
        jogador1 = scanner.nextLine();
        System.out.print("Nome do Jogador 2: ");
        jogador2 = scanner.nextLine();

        boolean jogando = true;

        while (jogando) {
            inicializarTabuleiro();
            mostrarTabuleiro();
            mostrarPlacar();

            System.out.print("Pressione 'q' para sair ou qualquer outra tecla para começar uma nova partida: ");
            String comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("q")) {
                jogando = false;
            } else {
                totalPartidas++;
                boolean partidaEmAndamento = true;
                char jogadorAtual = 'X'; // Jogador 1 começa com 'X'

                while (partidaEmAndamento) {
                    System.out.println("Vez de " + (jogadorAtual == 'X' ? jogador1 : jogador2) + " (" + jogadorAtual + "):");
                    System.out.print("Digite a jogada (LinhaColunaSimbolo): ");
                    String jogada = scanner.nextLine();

                    if (jogadaValida(jogada)) {
                        int linha = jogada.charAt(0) - '0';
                        int coluna = jogada.charAt(1) - '0';
                        char simbolo = jogada.charAt(2);

                        tabuleiro[linha][coluna] = simbolo;
                        mostrarTabuleiro();

                        if (verificarVencedor(simbolo)) {
                            System.out.println("Parabéns " + (simbolo == 'X' ? jogador1 : jogador2) + "! Você venceu esta partida.");
                            if (simbolo == 'X') pontosJogador1++;
                            else pontosJogador2++;
                            partidaEmAndamento = false;
                        } else {
                            boolean empate = true;
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    if (tabuleiro[i][j] == ' ') {
                                        empate = false;
                                        break;
                                    }
                                }
                            }
                            if (empate) {
                                System.out.println("A partida terminou em empate.");
                                partidaEmAndamento = false;
                            } else {
                                jogadorAtual = (jogadorAtual == 'X' ? '0' : 'X');
                            }
                        }
                    } else {
                        System.out.println("Jogada inválida! Tente novamente.");
                    }
                }
                mostrarPlacar();
            }
        }

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.iniciarJogo();
    }
}