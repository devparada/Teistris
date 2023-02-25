/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Game;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 *
 * @author Raúl Parada de la Fuente
 */
public class TetrisKeyListener implements KeyEventDispatcher {

    /**
     *
     */
    private Game game;

    /**
     *
     * @param game
     */
    public TetrisKeyListener(Game game) {
        this.game = game;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (!game.isPaused()) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        game.getCurrentPiece().moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.getCurrentPiece().moveRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        game.getCurrentPiece().moveDown();
                        break;
                    case KeyEvent.VK_UP:
                        game.getCurrentPiece().rotate();
                        break;
                }
            }
        }
        return false;
    }
}
