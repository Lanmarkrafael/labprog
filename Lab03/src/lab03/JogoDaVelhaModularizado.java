/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 01 - Prof.: Daniel Gondim
*  Alunos: Higor Pereira / Lanmark Rafael / Danilo de Souza
 */
package lab03;

import java.util.Scanner;

public class JogoDaVelhaModularizado {

    public void startGame() {
        //Inicializando as variáveis.
        char player = 'O';
        int linha, coluna, linhaMatriz, colunaMatriz, player1 = 0, player2 = 0;
        Scanner aux = new Scanner(System.in);
        Game g = new Game();

        //Inicializando o Jogo
        g.inicializarJogo();
        System.out.println("Jogo iniciado!\n");
        g.exibirTabuleiro();

        while (true) {
            player = g.mudarPlayer(player);
            //Lendo as informações da jogada
            System.out.print("\nJogador " + player + ", defina a sua jogada (nº linha e nº coluna).\n");
            System.out.print("Informe o número correspondente a LINHA desejada: ");
            linhaMatriz = aux.nextInt();
            linha = linhaMatriz - 1;
            System.out.print("Informe o número correspondente a COLUNA desejada: ");
            colunaMatriz = aux.nextInt();
            coluna = colunaMatriz - 1;

            //Verificando se a opção de jogada é válida.
            while (g.verificarSlotValido(linhaMatriz, colunaMatriz)) {
                g.exibirTabuleiro();
                System.out.println("Você escolheu uma opção inválida, tente novamente (nº linha e nº coluna).\n");
                System.out.print("Informe o número correspondente a LINHA desejada (Entre 1 e 3): ");
                linhaMatriz = aux.nextInt();
                linha = linhaMatriz - 1;
                System.out.print("Informe o número correspondente a COLUNA desejada (Entre 1 e 3): ");
                colunaMatriz = aux.nextInt();
                coluna = colunaMatriz - 1;
            }

            //Verificando se o slot escolhido pelo jogador está vazio.
            while (g.verificarSlot(linha, coluna)) {
                g.exibirTabuleiro();
                System.out.println("Este espaço já está preenchido, tente novamente (nº linha e nº coluna).\n");
                System.out.print("Informe o número correspondente a LINHA desejada: ");
                linhaMatriz = aux.nextInt();
                linha = linhaMatriz - 1;
                System.out.print("Informe o número correspondente a COLUNA desejada: ");
                colunaMatriz = aux.nextInt();
                coluna = colunaMatriz - 1;
            }

            g.trocarLado(player, linha, coluna);
            //Exibindo o Tabuleiro
            g.exibirTabuleiro();

            //Imprimindo na tela as informações do vencedor do jogo.
            if (g.verificarVencedor()) {
                System.out.println("\n- O vencedor é o jogador " + player + " !!");
                if (player == 'X') {
                    player1++;
                } else {
                    player2++;
                }
                break;

            }
            //Imprimindo na tela que o jogo resultou em empate, caso ocorra.
            if (g.verificarEmpate()) {
                System.out.println("\nEste jogo está empatado!");
                break;
            }
        }
        // Solicitando recomeço ou não do jogo
        System.out.print("Gostaria de jogar novamente?\nSe sim, informe um número qualquer. Se não, informe '-1': ");
        Scanner entrada = new Scanner(System.in);
        int jogadorInput = entrada.nextInt();
        // Estabelecendo parâmetro de sáida
        if (jogadorInput != -1) {
            System.out.println();
            startGame();
        } else {
            System.out.print("Jogo finalizado.\n");
            System.out.print("----------------------------------\n");
            System.out.print("Vitórias do Jogador X: " + player1 + "\n");
            System.out.print("Vitórias do Jogador O: " + player2 + "\n");
        }
    }

    public static void main(String[] args) {
        JogoDaVelhaModularizado g = new JogoDaVelhaModularizado();
        g.startGame();
    }
}