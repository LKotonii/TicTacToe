
package TicTacToe;


import java.util.*;

public class boardXO {

    private polePlanszy[][] boardXO;
    public String O = " O ";
    public String X = " X ";
    private Random r = new Random();
    private  polePlanszy poleKomputera = new polePlanszy(" ");
   


    private final int GAME_CONTINUES = 0;
    private final int O_WINS = 1;
    private final int X_WINS = 2;
    private final int REMIS = 3;

    boardXO() {
        boardXO = new polePlanszy[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                boardXO[x][y] = new polePlanszy(" * ");
            }
        } 
    }

    public polePlanszy[][] getBoardXO() {
        return this.boardXO;
    }
    
    
    
    public int gameState () {
        int gameState = -1;
        // sprawdzamy linie poziome i pionowe.
        for (int y = 0; y < this.getBoardXO().length; y++) {
            if (this.getBoardXO()[0][y].typeOfElem.equals(this.getBoardXO()[1][y].typeOfElem) && this.getBoardXO()[0][y].typeOfElem.equals(this.getBoardXO()[2][y].typeOfElem)) {

                if (this.getBoardXO()[0][y].typeOfElem.equals(X)) {
                    gameState = X_WINS;
                } else if (this.getBoardXO()[0][y].typeOfElem.equals(O)) {
                    gameState = O_WINS;
                }
            }
            else if (this.getBoardXO()[y][0].typeOfElem.equals(this.getBoardXO()[y][1].typeOfElem) && this.getBoardXO()[y][0].typeOfElem.equals(this.getBoardXO()[y][2].typeOfElem)){
                if (this.getBoardXO()[y][0].typeOfElem.equals(X)) {
                    gameState = X_WINS;
                } else if (this.getBoardXO()[y][0].typeOfElem.equals(O)) {
                    gameState = O_WINS;
                }
            }
        }
        
        // sprawdzamy przekątne 
        if (this.getBoardXO()[0][0].typeOfElem.equals(this.getBoardXO()[1][1].typeOfElem) && this.getBoardXO()[0][0].typeOfElem.equals(this.getBoardXO()[2][2].typeOfElem)) {
            if (this.getBoardXO()[0][0].typeOfElem.equals(X)) {
                gameState = X_WINS;
            } else if (this.getBoardXO()[0][0].typeOfElem.equals(O)) {
                gameState = O_WINS;
            }
        } else if (this.getBoardXO()[0][2].typeOfElem.equals(this.getBoardXO()[1][1].typeOfElem) && this.getBoardXO()[0][2].typeOfElem.equals(this.getBoardXO()[2][0].typeOfElem)) {
            if (this.getBoardXO()[0][2].typeOfElem.equals(X)) {
                gameState = X_WINS;

            } else if (this.getBoardXO()[0][2].typeOfElem.equals(O)) {
                gameState = O_WINS;
            }
        }


        if (gameState != O_WINS && gameState != X_WINS) {
            int polaZajete = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (this.getBoardXO()[i][j].zajete()){
                        polaZajete += 1;
                    }
                }
            }
            if (polaZajete == 9){  // sprzwdzamy czy w kazdym polu planszy znajduje się "X" lub "O" 
                gameState = REMIS;
            }
            else 
                gameState = GAME_CONTINUES;
        }
            return gameState;
        }


    private String whoseMove() {
        int iloscX = 0;
        int iloscO = 0;
        for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                if (this.getBoardXO()[i][j].typeOfElem.equals(X)) iloscX += 1;
                else if (this.getBoardXO()[i][j].typeOfElem.equals(O)) iloscO += 1;
            }
        }
        if (iloscO > iloscX) {
            return X;
        } else {
            return O;
        }
    }

    public polePlanszy computersMove(){
        for (int y = 0; y < this.getBoardXO().length; y++) // sprawdza linie pionowe i poziome (czy sa tam 2 jednakowe el-ty)
        {
            if (this.getBoardXO()[0][y].typeOfElem.equals(this.getBoardXO()[1][y].typeOfElem) && this.getBoardXO()[0][y].zajete()) {
                poleKomputera = this.getBoardXO()[2][y]; 
                break;
            } else if (this.getBoardXO()[1][y].typeOfElem.equals(this.getBoardXO()[2][y].typeOfElem) && this.getBoardXO()[1][y].zajete()) {
                poleKomputera = this.getBoardXO()[0][y];
                break;
            } else if (this.getBoardXO()[0][y].typeOfElem.equals(this.getBoardXO()[2][y].typeOfElem) && this.getBoardXO()[0][y].zajete()) {
                poleKomputera = this.getBoardXO()[1][y];
                break;
            } else if (this.getBoardXO()[y][0].typeOfElem.equals(this.getBoardXO()[y][1].typeOfElem) && this.getBoardXO()[y][0].zajete()) {
                poleKomputera = this.getBoardXO()[y][2];
                break;
            } else if (this.getBoardXO()[y][1].typeOfElem.equals(this.getBoardXO()[y][2].typeOfElem) && this.getBoardXO()[y][1].zajete()) {
                poleKomputera = this.getBoardXO()[y][0];
                break;
            } else if (this.getBoardXO()[y][2].typeOfElem.equals(this.getBoardXO()[y][0].typeOfElem) && this.getBoardXO()[y][2].zajete()) {
                poleKomputera = this.getBoardXO()[y][1];
                break;
            }
            else poleKomputera = this.getBoardXO()[r.nextInt(3)][r.nextInt(3)];
         }
         // sprawdza przekątne
         if (this.getBoardXO()[0][0].typeOfElem.equals(this.getBoardXO()[1][1].typeOfElem) && this.getBoardXO()[0][0].zajete()) {
                poleKomputera = this.getBoardXO()[2][2];
            } else if ((this.getBoardXO()[0][0].typeOfElem.equals(this.getBoardXO()[2][2].typeOfElem) || this.getBoardXO()[0][0].typeOfElem.equals(this.getBoardXO()[0][2].typeOfElem)) && this.getBoardXO()[0][0].zajete()) {
                poleKomputera = this.getBoardXO()[1][1];
            } else if (this.getBoardXO()[1][1].typeOfElem.equals(this.getBoardXO()[2][2].typeOfElem) && this.getBoardXO()[2][2].zajete()) {
                poleKomputera = this.getBoardXO()[0][0];
            } else if (this.getBoardXO()[1][1].typeOfElem.equals(this.getBoardXO()[2][0].typeOfElem) && this.getBoardXO()[2][0].zajete()) {
                poleKomputera = this.getBoardXO()[0][2];
            } else if (this.getBoardXO()[0][2].typeOfElem.equals(this.getBoardXO()[1][1].typeOfElem) && this.getBoardXO()[1][1].zajete()) {
                poleKomputera = this.getBoardXO()[2][0];
            } else poleKomputera = this.getBoardXO()[r.nextInt(3)][r.nextInt(3)];
        
        if (poleKomputera.zajete()){
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (!this.getBoardXO()[x][y].zajete()){
                        poleKomputera = this.getBoardXO()[x][y];
                        break;
                    }
                }
            }
        }
        
        poleKomputera.setTypeOfElem(this.whoseMove());
        return poleKomputera;
    }
    

    class polePlanszy {
        String typeOfElem;

        polePlanszy(String typeOfElem) {
            this.typeOfElem = typeOfElem;
        }

        public boolean setTypeOfElem(String typeOfElem) {
            if (!this.zajete()){
            this.typeOfElem = typeOfElem;
            return true;
            }
            else return false;
        }

        public boolean zajete() {
            return this.typeOfElem.equals(X) || this.typeOfElem.equals(O);
        }
    }
}