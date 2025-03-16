package strategies;
import models.Tabuleiro;

public class VitoriaLinha implements EstrategiaVitoria {
    @Override
    public boolean verificar(Tabuleiro tabuleiro, char simbolo) {
        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            if (tabuleiro.getSimbolo(i, 0) == simbolo &&
                tabuleiro.getSimbolo(i, 1) == simbolo &&
                tabuleiro.getSimbolo(i, 2) == simbolo) {
                return true;
            }
        }
        return false;
    }
}
