package models;
public class Jogador {
    private char simboloAtual; //indica o simbolo do jogador da vez 'X' ou 'O'
    
    //inicia com o primeiro jogador
    public Jogador() {
        this.simboloAtual = 'X';
    }

    //alterna entre os jogadores
    public void trocarJogador() {
        this.simboloAtual = (this.simboloAtual == 'X') ? 'O' : 'X';
    }
    
    public char getSimboloAtual() {
        return simboloAtual;
    }
}
