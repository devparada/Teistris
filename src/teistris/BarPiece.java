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
public class BarPiece extends Piece {
    
    public BarPiece(Game game) {
        this.game = game;

        squares = new Square[4];

        squares[0] = new Square(Game.MAX_X / 2, 0, Color.YELLOW, game);
        squares[1] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.YELLOW, game);
        squares[2] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE * 2,
                Color.YELLOW, game);
        squares[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE * 3, Color.YELLOW, game);
    }
    
}
