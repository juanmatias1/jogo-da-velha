# Jogo da Velha

Este é um jogo da velha simples implementado em Java. O jogo permite que dois jogadores se enfrentem em um tabuleiro 3x3, alternando entre as jogadas e verificando o vencedor.

## Funcionalidades

- Mensagem de boas-vindas e comandos de saída.
- Solicitação dos nomes dos jogadores.
- Exibição do tabuleiro do jogo.
- Alternância entre os jogadores com indicação de vez.
- Verificação de jogadas válidas.
- Verificação de vencedor ou empate.
- Exibição do placar de pontos e total de partidas.

## Regras do Jogo

- O tabuleiro é uma grade 3x3.
- Dois jogadores se alternam para jogar.
- As jogadas são feitas no formato `LinhaColunaSimbolo` (ex: `01X`, `220`).
- O jogador não pode repetir jogadas, tanto dele quanto do oponente.
- Vence o jogador que conseguir alinhar três símbolos iguais em linha, coluna ou diagonal.
- Se todas as posições forem preenchidas sem um vencedor, a partida termina em empate.

## Como Jogar
1. Clone o repositório:
    ```sh
    git clone https://github.com/juanmatias1/jogo-da-velha.git
    ```
    ```sh
    cd jogo-da-velha
    ```
3. Compile o código-fonte:
    ```sh
    javac JogoDaVelha.java
    ```

2. Execute o jogo:
    ```sh
    java JogoDaVelha
    ```

3. Siga as instruções no terminal para inserir os nomes dos jogadores e fazer as jogadas.

## Exemplo de Uso
- Durante o jogo, insira as jogadas no formato `LinhaColunaSimbolo` (ex: `01X` para colocar um 'X' na posição (0, 1)).
