/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teistris;

import model.Game;
import model.Square;
import model.Piece;
import java.awt.Color;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class LPiece extends Piece {
    
    public LPiece(Game game) {
        this.game = game;

        squares = new Square[4];

        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.GREEN, game);
        squares[1] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE*2, Color.GREEN, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                Color.GREEN, game);
        squares[3] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2, Color.GREEN, game);
    }
    
    @Override
    public boolean rotate() {

        int centerX = squares[1].getX();
        int centerY = squares[1].getY();

        for (int i = 0; i < squares.length; i++) {
            int x = squares[i].getX();
            int y = squares[i].getY();

            int newX = centerX + (y - centerY);
            int newY = centerY - (x - centerX);

            if (!game.isValidPosition(newX, newY)) {
                return false;
            }
        }

        for (int i = 0; i < squares.length; i++) {
            int x = squares[i].getX();
            int y = squares[i].getY();

            int newX = centerX + (y - centerY);
            int newY = centerY - (x - centerX);

            squares[i].setX(newX);
            squares[i].setY(newY);
        }

        return true;
    }
    
}
