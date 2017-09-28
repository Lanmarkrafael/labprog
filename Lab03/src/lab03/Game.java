/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 01 - Prof.: Daniel Gondim
*  Alunos: Higor Pereira / Lanmark Rafael / Danilo de Souza
 */
package lab03;

public class Game {

    char[][] table = new char[3][3];

    //Função de inicialização do tabuleiro.
    public void inicializarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                table[i][p] = ' ';
            }
        }
    }

    //Função de verificar slot.
    public boolean verificarSlot(int linha, int coluna) {
        if ((linha > 2 || coluna > 2) || (linha < 0 || coluna < 0)) {
            return true;
        } else if (table[linha][coluna] == 'X' || table[linha][coluna] == 'O') {
            return true;
        }
        return false;
    }

    //Função de verificar se a jogada é válida.
    public boolean verificarSlotValido(int linha, int coluna) {
        if ((linha < 1 || linha > 3) || (coluna < 1 || coluna > 3)) {
            return true;
        }
        return false;
    }

    public void trocarLado(char player, int linha, int coluna) {
        table[linha][coluna] = player;
    }

    //Função que imprime o tabuleiro.
    public void exibirTabuleiro() {
        System.out.println("\n");
        System.out.println("  1  " + table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  3  " + table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
        System.out.println("     1 2 3 ");
        System.out.println("\n");
    }

    //Função para mudar o turno do jogador.
    public char mudarPlayer(char player) {
        char novaRodada = '-';
        if (player == 'O') {
            novaRodada = 'X';
        }
        if (player == 'X') {
            novaRodada = 'O';
        }
        return novaRodada;
    }

    //Função para verificar o vencedor do jogo.
    public boolean verificarVencedor() {
        if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && (table[0][1] == 'X' || table[0][1] == 'O')) {
            return true;
        } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && (table[0][2] == 'X' || table[0][2] == 'O')) {
            return true;
        } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && (table[1][0] == 'X' || table[1][0] == 'O')) {
            return true;
        } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
            return true;
        } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[2][0] == table[1][1] && table[1][1] == table[0][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
            return true;
        } else {
            return false;
        }
    }

    //Função para verificar se ocorreu o empate.
    public boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                if (table[i][p] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}