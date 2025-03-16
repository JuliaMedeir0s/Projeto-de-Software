package controllers;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.Jogador;
import models.Tabuleiro;
import strategies.EstrategiaVitoria;
import strategies.VitoriaColuna;
import strategies.VitoriaDiagonal;
import strategies.VitoriaLinha;

public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private Jogador jogador;
    private boolean jogoFinalizado;
    private final List<EstrategiaVitoria> estrategiasVitoria;

    public JogoDaVelha() {
        this.estrategiasVitoria = Arrays.asList(
                new VitoriaLinha(),
                new VitoriaColuna(),
                new VitoriaDiagonal());
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente;

        do {
            limparTela();
            tabuleiro = new Tabuleiro();
            jogador = new Jogador();
            jogoFinalizado = false;
            int jogadas = 0;

            while (!jogoFinalizado) {
                tabuleiro.exibir();
                System.out.printf("\nJogador %c, informe a linha (1-3): ", jogador.getSimboloAtual());
                int linha = scanner.nextInt() - 1;
                System.out.printf("Jogador %c, informe a coluna (1-3): ", jogador.getSimboloAtual());
                int coluna = scanner.nextInt() - 1;

                if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3
                        || !tabuleiro.marcarJogada(linha, coluna, jogador.getSimboloAtual())) {
                    System.out.println(
                            "\n--> Jogada inválida! Escolha um número entre 1 e 3 para linha e coluna. Tente novamente.\n");
                    continue;
                }

                jogadas++;
                if (verificarVitoria()) {
                    tabuleiro.exibir();
                    System.out.println("\n**** PARABÉNS! ****");
                    System.out.printf("**** O jogador %c venceu! ****\n", jogador.getSimboloAtual());
                    jogoFinalizado = true;
                } else if (jogadas == 9) {
                    tabuleiro.exibir();
                    System.out.println("\n---- O jogo empatou! ----");
                    jogoFinalizado = true;
                } else {
                    jogador.trocarJogador();
                }
            }

            System.out.print("\n Deseja jogar novamente? (S/N): ");
            char resposta = scanner.next().toUpperCase().charAt(0);
            jogarNovamente = (resposta == 'S');
        } while (jogarNovamente);

        System.out.println("\n Obrigado por jogar! Até a próxima! ");
        scanner.close();
    }

    private boolean verificarVitoria() {
        char simbolo = jogador.getSimboloAtual();
        for (EstrategiaVitoria estrategia : estrategiasVitoria) {
            if (estrategia.verificar(tabuleiro, simbolo)) {
                return true;
            }
        }
        return false;
    }

    //limpa a tela
    private void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
