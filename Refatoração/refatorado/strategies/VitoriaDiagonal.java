package strategies;
import models.Tabuleiro;

public class VitoriaDiagonal implements EstrategiaVitoria {
    @Override
    public boolean verificar(Tabuleiro tabuleiro, char simbolo) {
        return (tabuleiro.getSimbolo(0, 0) == simbolo &&
                tabuleiro.getSimbolo(1, 1) == simbolo &&
                tabuleiro.getSimbolo(2, 2) == simbolo) ||
                (tabuleiro.getSimbolo(0, 2) == simbolo &&
                        tabuleiro.getSimbolo(1, 1) == simbolo &&
                        tabuleiro.getSimbolo(2, 0) == simbolo);
    }
}