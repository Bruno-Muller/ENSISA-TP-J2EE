/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tf.muller.bruno.tpj2eemuller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bruno
 */
public class TicTacToe {
    
    public enum Player {User, Computer};
    public enum State {Empty, User, Computer};
    
    private State[][] states;
    
    private TicTacToe() {
        this.states = new State[3][3];
    }
    
    public static TicTacToe getInstance(HttpServletRequest request) {
        if (request.getSession(true).getAttribute("TicTacToe") == null)
            request.getSession(true).setAttribute("TicTacToe", new TicTacToe());
        
        return (TicTacToe) request.getSession(true).getAttribute("TicTacToe");
    }
    
    public void startGame(Player player) { 
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                this.states[i][j]=State.Empty;
                
        if (player == Player.Computer)
            this.computerPlay();
    } 
    
    public State getState(int i, int j) {
        return this.states[i][j];
    }
    
    public void userPlay(int i, int j) {
        if (this.isGameFinished()) return;
        
        if (this.states[i][j] == State.Empty) {
            this.states[i][j] = State.User;
            this.computerPlay();
        }
    }
    
    private void computerPlay() {
        if (this.isGameFinished()) return;
        
        int i, j; 
        do {
            i = (int)(Math.random() * 3);
            j = (int)(Math.random() * 3);
        } while (this.states[i][j] != State.Empty);
        this.states[i][j] = State.Computer;
    }
    
    public boolean isGameFinished() {
        return isFull() || isSomeoneVictorious(); 
    }
    
    public boolean isFull() {
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                if (this.states[i][j]==State.Empty) return false;
        return true; 
    }
    
    public boolean isSomeoneVictorious() {
        for (int i=0; i<3; i++) {
            if (this.states[i][0] != State.Empty && this.states[i][0] == this.states[i][1] && this.states[i][1] == this.states[i][2]) return true;
            if (this.states[0][i] != State.Empty && this.states[0][i] == this.states[1][i] && this.states[1][i] == this.states[2][i]) return true;
        }
        
        if (this.states[0][0] != State.Empty && this.states[0][0] == this.states[1][1] && this.states[1][1] == this.states[2][2]) return true;
        if (this.states[0][2] != State.Empty && this.states[0][2] == this.states[1][1] && this.states[1][1] == this.states[2][0]) return true;
        
        return false;
    }
    
    public boolean isUserVictorious() {
        for (int i=0; i<3; i++) {
            if (this.states[i][0] == State.User && this.states[i][0] == this.states[i][1] && this.states[i][1] == this.states[i][2]) return true;
            if (this.states[0][i] == State.User && this.states[0][i] == this.states[1][i] && this.states[1][i] == this.states[2][i]) return true;
        }
        
        if (this.states[0][0] == State.User && this.states[0][0] == this.states[1][1] && this.states[1][1] == this.states[2][2]) return true;
        if (this.states[0][2] == State.User && this.states[0][2] == this.states[1][1] && this.states[1][1] == this.states[2][0]) return true;
         
        return false;
    }
    
}
