/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 *
 * Esta clase implementa KeyEventDispatcher e captura os eventos das teclas
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class KeyDispatcher implements KeyEventDispatcher {

    /**
     * Referenza ao obxecto do xogo actual
     */
    private Game game;

    /**
     * Constructor da clase KeyDispatcher
     *
     * @param game
     */
    public KeyDispatcher(Game game) {
        this.game = game;
    }

    /**
     * Captura os eventos das teclas e mediante un switch fai cada cousa
     *
     * @param e o evento dunha tecla
     * @return Devolve false para que actué sempre
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        // Si o xogo non está pausado
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
