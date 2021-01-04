/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;
import java.awt.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.font.TextAttribute.FONT;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author Noura Aboelsoud
 */
public class TicTacToe extends JFrame{
    
    private Container pane;
    private String currentPlayer ;
    private JButton [][] board;
    private Boolean hasWinner ;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuItem quit;
    
    public TicTacToe(){
        super();
        pane=getContentPane();
        pane.setLayout(new GridLayout(3,3));
        setTitle("XO");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        board=new JButton[3][3];
        hasWinner=false;
        intializeMenuBar();
        intializeBoard();
        currentPlayer="x";
        
    }
    private void intializeBoard(){
    for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
    JButton btn=new JButton();
    btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
    board[i][j]=btn;
    btn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          if(((JButton)e.getSource()).getText().equals("") && hasWinner==false){
          btn.setText(currentPlayer);
          hasWinner();
          togglePlayer();
         
          }
        }
    
    
    
    });
    
    pane.add(btn);
    }
        }
    
    }
    private void resetBoard(){
    currentPlayer="x";
    hasWinner=false;
    for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
    board[i][j].setText("");
    
    }
        }
    }

    private void intializeMenuBar(){
    menuBar=new JMenuBar();
    menu = new JMenu("File");
    newGame =new JMenuItem("NewGame");
    newGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            resetBoard();
        }
   
    });
    quit= new JMenuItem("Quit");
    quit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    });
    menu.add(newGame);
    menu.add(quit);
    menuBar.add(menu);
    setJMenuBar(menuBar);
    
    
}
    private void togglePlayer(){
    if(currentPlayer.equals("x")){currentPlayer="o";}
    else currentPlayer="x";
    
    
    }
    private void hasWinner(){
        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
            /**
     * @param args the command line arguments
     */
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new TicTacToe();
            }
        
        
        
        
        });
        
       


    
}}
