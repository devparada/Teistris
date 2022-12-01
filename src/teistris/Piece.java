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
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package teistris;

import java.awt.Color;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Bilo Alejandro Martins González y Raúl Parada de la Fuente
 */
public class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    private Game game;

    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    private Square a, b, c, d;

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     */
    public Piece(Game game) {
        this.game = game;

        a = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
        b = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
        c = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                Color.BLUE, game);
        d = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);
    }

    /**
     * Este método recibe os datos do atributo game
     * @return Devolve os datos do atributo game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Este método modifica os datos do atributo game
     * @param game valor que sobreescribe o valor actual
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     * Este método recibe os datos do atributo game
     * @return Devolve os datos do atributo game
     */
    public Square getA() {
        return a;
    }

    /**
     * Este método modifica os datos do atributo a
     * @param a valor que sobreescribe o valor actual
     */
    public void setA(Square a) {
        this.a = a;
    }
    
    /**
     * Este método recibe os datos do atributo b
     * @return Devolve os datos do atributo b
     */
    public Square getB() {
        return b;
    }
    
    /**
     * Este método modifica os datos do atributo b
     * @param b valor que sobreescribe o valor actual
     */
    public void setB(Square b) {
        this.b = b;
    }

        /**
     * Este método recibe os datos do atributo c
     * @return Devolve os datos do atributo c
     */
    public Square getC() {
        return c;
    }
    
    /**
     * Este método modifica os datos do atributo c
     * @param c valor que sobreescribe o valor actual
     */
    public void setC(Square c) {
        this.c = c;
    }
    
    /**
     * Este método recibe os datos do atributo d
     * @return Devolve os datos do atributo d
     */
    public Square getD() {
        return d;
    }

        /**
     * Este método modifica os datos do atributo d
     * @param d valor que sobreescribe o valor actual
     */
    public void setD(Square d) {
        this.d = d;
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {

        if (game.isValidPosition(b.getX() + Game.SQUARE_SIDE, b.getY())) {
            a.setX(a.getX() + Game.SQUARE_SIDE);
            b.setX(b.getX() + Game.SQUARE_SIDE);
            c.setX(c.getX() + Game.SQUARE_SIDE);
            d.setX(d.getX() + Game.SQUARE_SIDE);
            return true;
        }
        return false;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {

        if (game.isValidPosition(a.getX() - Game.SQUARE_SIDE, a.getY())) {
            a.setX(a.getX() - Game.SQUARE_SIDE);
            b.setX(b.getX() - Game.SQUARE_SIDE);
            c.setX(c.getX() - Game.SQUARE_SIDE);
            d.setX(d.getX() - Game.SQUARE_SIDE);
            return true;
        }
        return false;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {

        if (game.isValidPosition(d.getX(), d.getY() + Game.SQUARE_SIDE)) {
            a.setY(a.getY() + Game.SQUARE_SIDE);
            b.setY(b.getY() + Game.SQUARE_SIDE);
            c.setY(c.getY() + Game.SQUARE_SIDE);
            d.setY(d.getY() + Game.SQUARE_SIDE);
            return true;
        }
        return false;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }

}
