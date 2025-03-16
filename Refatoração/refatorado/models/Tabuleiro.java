package models;
import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private final int tamanho = 3; //tabuleiro 3x3
    private final List<Celula> celulas;

    //iniciar com um tabuleiro vazio
    public Tabuleiro() {
        celulas = new ArrayList<>(tamanho * tamanho);
        for (int i = 0; i < tamanho * tamanho; i++) {
            celulas.add(new Celula());
        }
    }

    //mostra tabuleiro
    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.printf(" %c | %c | %c \n", 
                celulas.get(i * tamanho).getSimbolo(),
                celulas.get(i * tamanho + 1).getSimbolo(),
                celulas.get(i * tamanho + 2).getSimbolo()
            );
            if (i < tamanho - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    //marca a jogada no tabuleiro
    public boolean marcarJogada(int linha, int coluna, char jogador) {
        int indice = (linha * tamanho) + coluna;
        return celulas.get(indice).marcarCelula(jogador);
    }

    //retorna símbolo de uma posição específica
    public char getSimbolo(int linha, int coluna) {
        return celulas.get((linha * tamanho) + coluna).getSimbolo();
    }

    public int getTamanho() {
        return tamanho;
    }
}
