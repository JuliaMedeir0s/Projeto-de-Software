# 🏆 Jogo da Velha - Refatoração com Strategy
Este projeto é uma **refatoração** de um jogo da velha simples em Java. O código original concentrava toda a lógica na classe `Main.java`, tornando-o **difícil de manter** e pouco modular.  
Nesta refatoração, aplicamos **boas práticas de POO** e o **padrão Strategy** para melhorar a organização e a reutilização do código.

---

## 📌 Refatoração: O que foi Melhorado?
### **1️⃣ Separação de Responsabilidades (SRP - Single Responsibility Principle)**
Antes: Toda a lógica estava dentro da `Main.java`, misturando **regras do jogo**, **interação do usuário** e **verificação de vitória**.  
Agora: Criamos classes separadas seguindo a **arquitetura MVC**.

---

### **2️⃣ Implementação do Padrão Strategy**
Antes: A lógica de verificação de vitória era rígida e estava acoplada à `Main.java`.  
Agora: Implementamos o **padrão Strategy**, criando classes específicas para verificar vitórias por **linha, coluna e diagonal**.

```java
private boolean verificarVitoria() {
    char simbolo = jogador.getSimboloAtual();
    for (EstrategiaVitoria estrategia : estrategiasVitoria) {
        if (estrategia.verificar(tabuleiro, simbolo)) {
            return true;
        }
    }
    return false;
}
```
Isso torna mais fácil adicionar novas regras de vitória, se necessário.

---

### **3️⃣ Substituição da Matriz `char[][]` por uma Estrutura Orientada a Objetos**
Antes: O tabuleiro era representado como uma matriz char[][], dificultando a manipulação.
Agora: Criamos uma classe Celula e usamos uma lista de células (List<Celula>), tornando o código mais modular.

---

### **4️⃣ Organização do Código em Pacotes**
Agora, o código está organizado de forma modular e escalável, seguindo a estrutura:

# Jogo da Velha
    ├── 📂 refatorado 
        ├── 📂 controller
        │   ├── JogoDaVelha.java
        ├── 📂 models 
        │   ├── Celula.java 
        │   ├── Jogador.java
        │   ├── Tabuleiro.java
        ├── 📂 strategies 
        │   ├── EstrategiaVitoria.java
        │   ├── VitoriaLinha.java
        │   ├── VitoriaColuna.java
        │   ├── VitoriaDiagonal.java
        ├── Main.java

---

## 🚀 Como executar

