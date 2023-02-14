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
 * Esta clase implementa o constructor da clase Piece e é subclase de Piece
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class SquarePiece extends Piece {

    /**
     * Construtor da clase SquarePiece
     *
     * @param game
     */
    public SquarePiece(Game game) {
        this.game = game;

        squares = new Square[4];

        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
        squares[1] = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                Color.BLUE, game);
        squares[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);
    }

}
