package models;
public class Celula {
    private char simbolo; //pode ser 'X', 'O' ou ' ' (vazio)

    //tem que iniciar a célula vazia
    public Celula() {
        this.simbolo = ' ';
    }

    //verifica se a célula ta vazia
    public boolean isVazia() {
        return simbolo == ' ';
    }

    //marca a célula com o símbolo jogado, se estiver vazia
    public boolean marcarCelula(char jogador) {
        if(isVazia()){
            this.simbolo = jogador;
            return true;
        }
        return false;
    }

    public char getSimbolo() {
        return simbolo;
    }
}