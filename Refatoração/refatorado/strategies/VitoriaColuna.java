package strategies;
import models.Tabuleiro;

public class VitoriaColuna implements EstrategiaVitoria {
    @Override
    public boolean verificar(Tabuleiro tabuleiro, char simbolo) {
        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            if (tabuleiro.getSimbolo(0, i) == simbolo &&
                tabuleiro.getSimbolo(1, i) == simbolo &&
                tabuleiro.getSimbolo(2, i) == simbolo) {
                return true;
            }
        }
        return false;
    }
}