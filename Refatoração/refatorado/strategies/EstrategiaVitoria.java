package strategies;
import models.Tabuleiro;

public interface EstrategiaVitoria {
    boolean verificar(Tabuleiro tabuleiro, char simbolo);
}
