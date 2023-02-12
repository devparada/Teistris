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
 * Esta clase implementa a peza BarPiece, é subclase de Piece e sobreescribe o
 * método rotate
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class BarPiece extends Piece {

    /**
     * Constructor da clase BarPiece
     *
     * @param game
     */
    public BarPiece(Game game) {
        this.game = game;

        squares = new Square[4];

        squares[0] = new Square(Game.MAX_X / 2, 0, Color.YELLOW, game);
        squares[1] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.YELLOW, game);
        squares[2] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE * 2,
                Color.YELLOW, game);
        squares[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE * 3, Color.YELLOW, game);
    }

    /**
     * Rota a peza BarPiece
     *
     * @return Devolve true o false se a peza pode rotar o non
     */
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
