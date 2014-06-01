/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xsi0;

/**
 *
 * @author anca
 */
public class Xsi0 {

    /**
     * @param args the command line arguments
     */
    public static final char X = 'x';
    public static final char O = 'o';
    public static final char N = ' ';
    static final int ROWS = 3;
    static final int COLS = 3;

    public static void main(String[] args) {

        char[][] oTabla = new char[][]{
            {O, X, O},
            {O, N, X},
            {O, N, X}
        };

        print(oTabla);
        String validitate = isValid(oTabla) ? "este" : "nu este";
        System.out.println("Tabla " + validitate + " valida");

        if(isWinner(X, oTabla))
        {
            System.out.println("X a castigat");
        }
        else if(isWinner(O, oTabla)) {
            System.out.println("O a castigat");
        }
            
    }

    
    /**
     *
     * @param cine 'x' sau 'o'
     * @param tabla
     * @return true daca "cine" este castigator 
     */
    public static boolean isWinner(char cine, char[][] tabla) {
        //pentru fiecare linie verific daca e plina cu caracterul "cine"
        for (int row = 0; row < ROWS; row++) {
            if (isFullLine(cine, row, tabla)) {
                return true;
            }
        }
        //liniile nu sunt pline. verific daca e vreo coloana plina
        for (int col = 0; col < COLS; col++) {
            if (isFullColumn(cine, col, tabla)) {
                return true;
            }
        }

        //caut o diagonala plina 
        if (isFullFirstDiag(cine, tabla)) {
            return true;
        }
        if (isFullSecondDiag(cine, tabla)) {
            return true;
        }
        return false;
    }

    public static boolean isValid(char[][] tabla) {
        int countX = numaraX(tabla);
        int countO = numaraO(tabla);
        int difXO = countX - countO;
        if (abs(difXO) <= 1) {
            if(isWinner(X, tabla) && isWinner(O, tabla)){
                return false;
            } else {
                return true;
            }
            
        } else {
            return false;
        }
    }

    private static void print(char[][] tabla) {
        String linie = "+---+---+---+";
        String linieSpatiu = "|   |   |   |";

        System.out.println(linie);

        for (int row = 0; row < ROWS; row++) {
            System.out.println(linieSpatiu);
            for (int col = 0; col < COLS; col++) {
                System.out.print("| " + tabla[row][col] + " ");
            }
            System.out.println("|");
            System.out.println(linieSpatiu);
            System.out.println(linie);
        }
    }

    private static int numaraX(char[][] tabla) {
        return numaraCaracter(X, tabla);
    }

    private static int numaraO(char[][] tabla) {
        return numaraCaracter(O, tabla);
    }

    private static int numaraCaracter(char caracterulCautat, char[][] tabla) {
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (tabla[row][col] == caracterulCautat) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    private static int abs(int numar) {
        if (numar >= 0) {
            return numar;
        } else {
            return -numar;
        }
    }

    private static boolean isFullLine(char caracterulCautat, int row, char[][] tabla) {
        for (int col = 0; col < COLS; col++) {
            if (tabla[row][col] != caracterulCautat) {
                return false;
            }
        }
        return true;

    }

    private static boolean isFullColumn(char caracterulCautat, int col, char[][] tabla) {
        for (int row = 0; row < ROWS; row++) {
            if (tabla[row][col] != caracterulCautat) {
                return false;
            }
        }
        return true;
    }


    private static boolean isFullSecondDiag(char cine, char[][] tabla) {
        for (int i=0; i<3; i++) {
            int row = i;
            int col = 2-row;//pe diagonala 2, row + col = 2;
            if (tabla[row][col] != cine) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFullFirstDiag(char cine, char[][] tabla) {
        for (int row=0; row<3; row++) {
            int col = row;//pe diagonala 1, row = col
            if (tabla[row][col] != cine) {
                return false;
            }
        }
        return true;
    }
   
}
