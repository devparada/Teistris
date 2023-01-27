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
package model;

import java.util.HashMap;
import teistris.BarPiece;
import teistris.LPiece;
import view.MainWindow;
import teistris.SquarePiece;
import teistris.TPiece;

/**
 * Clase que implementa o comportamento do xogo do Tetris
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Game {

    HashMap<String, Square> groundSquares;

    /**
     * Constante que define o tamaño en pixels do lado dun cadrado
     */
    public final static int SQUARE_SIDE = 20;
    /**
     * Constante que define o valor máximo da coordenada x no panel de cadrados
     */
    public final static int MAX_X = 160;
    /**
     * Constante que define o valor máximo da coordenada y no panel de cadrados
     */
    public final static int MAX_Y = 200;

    /**
     * Referenza á peza actual do xogo, que é a única que se pode mover
     */
    private Piece currentPiece;

    /**
     * Referenza á ventá principal do xogo
     */
    private MainWindow mainWindow;

    /**
     * Flag que indica se o xogo está en pausa ou non
     */
    private boolean paused = false;

    /**
     * Número de liñas feitas no xogo
     */
    private int numberOfLines = 0;

    /**
     * @return Referenza á ventá principal do xogo
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * @param mainWindow Ventá principal do xogo a establecer
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * @return O estado de pausa do xogo
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * @param paused O estado de pausa a establecer
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * @return Número de liñas feitas no xogo
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * @param numberOfLines O número de liñas feitas no xogo
     */
    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    /**
     * Construtor da clase, que crea unha primeira peza
     *
     * @param mainWindow Referenza á ventá principal do xogo
     */
    public Game(MainWindow mainWindow) {
        groundSquares = new HashMap();
        this.mainWindow = mainWindow;
        this.createNewPiece();
    }

    /**
     * Move a ficha actual á dereita, se o xogo non está pausado
     */
    public void movePieceRight() {
        if (!paused) {
            currentPiece.moveRight();
        }
    }

    /**
     * Move a ficha actual á esquerda, se o xogo non está pausado
     */
    public void movePieceLeft() {
        if (!paused) {
            currentPiece.moveLeft();
        }
    }

    /**
     * Rota a ficha actual, se o xogo non está pausado
     */
    public void rotatePiece() {
        if (!paused) {
            currentPiece.rotate();
        }
    }

    /**
     * Move a peza actual abaixo, se o xogo non está pausado Se a peza choca con
     * algo e xa non pode baixar, pasa a formar parte do chan e créase unha nova
     * peza
     */
    public void movePieceDown() {
        if ((!paused) && (!currentPiece.moveDown())) {
            this.addPieceToGround();
            this.createNewPiece();
            if (this.hitPieceTheGround()) {
                this.mainWindow.showGameOver();
            }
        }
    }

    /**
     * Método que permite saber se unha posición x,y é válida para un cadrado
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true se esa posición é válida, se non false
     */
    public boolean isValidPosition(int x, int y) {
        if ((x == MAX_X) || (x < 0) || (y == MAX_Y) || groundSquares.containsKey(x + "," + y)) {
            return false;
        }
        return true;
    }

    /**
     * Crea unha nova peza e a establece como peza actual do xogo
     */
    private void createNewPiece() {
        int pieceType = new java.util.Random().nextInt(4);

        switch(pieceType){
            case 0:
                SquarePiece square = new SquarePiece(this);
                currentPiece = square;
                break;
            case 1:
                LPiece l = new LPiece(this);
                currentPiece = l;
                break;
            case 2:
                BarPiece bar = new BarPiece(this);
                currentPiece = bar;
                break;
            case 3:
                TPiece t = new TPiece(this);
                currentPiece = t;
                break;
        }
    }

    /**
     * Engade unha peza ao chan
     */
    private void addPieceToGround() {
        // Engadimos os cadrados da peza ao chan
        for (Square s : currentPiece.getSquares()) {
            groundSquares.put(s.getCoordinates(), s);
        }
        // Chamamos ao método que borra as liñas do chan que estean completas
        this.deleteCompletedLines();
    }

    /**
     * Se os cadrados que están forman unha liña completa, bórranse eses
     * cadrados do chan e súmase unha nova liña no número de liñas realizadas
     */
    private void deleteCompletedLines() {

        for (int x = 0; x < MAX_Y; x = (x + SQUARE_SIDE)) {
            int line = 0;
            for (int y = 0; y <= MAX_X; y = (y + SQUARE_SIDE)) {
                String coordinates = y + "," + x;
                if (groundSquares.containsKey(coordinates)) {
                    line = (line + SQUARE_SIDE);
                }
            }
            if (line == MAX_X) {
                deleteLine(x);
            }

        }
    }

    /**
     * Borra todos os cadrados que se atopan na liña indicada pola coordenada y,
     * e baixa todos os cadrados que estean situados por enriba unha posición
     * cara abaixo
     *
     * @param y Coordenada y da liña a borrar
     */
    private void deleteLine(int y) {
        // Borra os cadrados cando coinciden unha liña completa
        for (int x = 0; x < MAX_X; x += SQUARE_SIDE) {
            Square deletedSquare = groundSquares.remove(x + "," + y);
            mainWindow.deleteSquare(deletedSquare.getLblSquare());
        }
        // Move os cadrados cando se borra unha fila nunha posicion y máis
        for (int j = y - SQUARE_SIDE; j >= 0; j -= SQUARE_SIDE) {
            for (int x = 0; x < MAX_X; x += SQUARE_SIDE) {
                if (groundSquares.containsKey(x + "," + j)) {
                    // Move as pezas cara unha fila abaixo
                    Square moveSquare = groundSquares.remove(x + "," + j);
                    moveSquare.setY(j + SQUARE_SIDE);
                    // Se engade as novas coordenadas no array groundSquares
                    groundSquares.put(moveSquare.getCoordinates(), moveSquare);
                }
            }
        }
    }

    /**
     * Comproba se a peza actual choca cos cadrados do chan
     *
     * @return true se a peza actual choca cos cadrados do chan; se non false
     */
    private boolean hitPieceTheGround() {
        for (Square s : currentPiece.getSquares()) {
            if (groundSquares.containsKey(s.getCoordinates())) {
                return true;
            }
        }
        return false;
    }

}
