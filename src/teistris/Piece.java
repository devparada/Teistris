/*
 * Copyright (C) 2019 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received squares0 copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package teistris;

import java.awt.Color;

/**
 * Clase que implementa squares0 peza cadrada do xogo do Tetris
 *
 * @author Bilo Alejandro Martins González y Raúl Parada de la Fuente
 */
public class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    private Game game;

    /**
     * Referenzas aos catro cadrados que forman squares0 peza
     */
    private Square[] squares;

    public Square[] getSquares() {
        return squares;
    }

    /**
     * Construtor da clase, que crea os catro cadrados que forman squares0 peza
     */
    public Piece(Game game) {
        this.game = game;
        
        squares = new Square[4];
        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
        squares[1] = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                Color.BLUE, game);
        squares[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);
    }

    /**
     * Este método recibe os datos do atributo game
     *
     * @return Devolve os datos do atributo game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Este método modifica os datos do atributo game
     *
     * @param game valor que sobreescribe o valor actual
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Move squares ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {
        if (game.isValidPosition(squares[1].getX() + Game.SQUARE_SIDE, squares[1].getY())) {
            for (Square sq : squares) {
                sq.setX(sq.getX() + Game.SQUARE_SIDE);
            }
            return true;
        }
        return false;
    }

    /**
     * Move squares ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {
        if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY())) {
            for (Square sq : squares) {
                sq.setX(sq.getX() - Game.SQUARE_SIDE);
            }
            return true;
        }
        return false;
    }

    /**
     * Move squares ficha squares0 abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {
        if (game.isValidPosition(squares[3].getX(), squares[3].getY() + Game.SQUARE_SIDE)) {
            for (Square sq : squares) {
                sq.setY(sq.getY() + Game.SQUARE_SIDE);
            }
            return true;
        }
        return false;
    }

    /**
     * Rota squares ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }

}
