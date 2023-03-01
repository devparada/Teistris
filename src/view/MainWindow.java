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
package view;

import java.awt.KeyboardFocusManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

import model.Game;
import model.KeyDispatcher;

/**
 * Clase que implementa a ventá principal do xogo do Tetris
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Timer de Swing que é unha conta atras
     */
    private Timer timer;

    /**
     * Contador do timer
     */
    private Integer counter;

    /**
     * Referenza ao obxecto do xogo actual
     */
    private Game game;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        game = null;
        counter = 1000;
        initComponents();
    }

    /**
     * Obtén o valor da variable counter
     *
     * @return Devolve o valor da variable counter
     */
    public Integer getCounter() {
        return counter;
    }

    /**
     * Modifica o valor da variable counter
     *
     * @param counter O valor da variable counter
     */
    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    /**
     * Obtén o valor da variable timer
     *
     * @return Devolve o valor da variable timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * Modifica o valor da variable timer
     *
     * @param timer O valor da variable timer
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * Pinta un cadrado no panel de cadrados
     *
     * @param lblSquare Etiqueta co cadrado que se quere pintar no panel
     */
    public void drawSquare(JLabel lblSquare) {
        jPnlGame.add(lblSquare);
        jPnlGame.repaint();
    }

    /**
     * Borra un cadrado do panel de cadrados
     *
     * @param lblSquare Etiqueta co cadrado que se quere borrar do panel
     */
    public void deleteSquare(JLabel lblSquare) {
        jPnlGame.remove(lblSquare);
        jPnlGame.repaint();
    }

    /**
     * Actualiza na ventá o número de liñas que van feitas no xogo
     *
     * @param numberOfLines Número de liñas feitas no xogo
     */
    public void showNumberOfLines(int numberOfLines) {
        counter = counter / 2;
        jLblNumberTimer.setText(counter.toString());

        jLblNumberOfLines.setText(String.valueOf(numberOfLines));
    }

    /**
     * Mostra unha mensaxe informando ao usuario do final do xogo
     */
    public void showGameOver() {
        game = null;
        JOptionPane.showMessageDialog(this, "Fin do xogo");
    }

    /**
     * Inicia un novo xogo
     */
    private void startGame() {
        // Condición if para eliminar timers antiguos que podan seguir funcionando
        if (timer != null) {
            timer.stop();
        }

        // Limpamos todo o que puidese haber pintado no panel do xogo
        jPnlGame.removeAll();
        // Creamos un novo obxecto xogo
        game = new Game(this);
        // Desactivamos o botón de pausa
        jTglBtnPause.setSelected(false);
        // Establecemos o número de liñas que se mostran na ventá a cero
        jLblNumberOfLines.setText("0");

        // Establecemos o timer na ventá ao valor de counter
        jLblNumberTimer.setText(counter.toString());

        // Establece o Listener na clase KeyDispatcher e se capturan allí as teclas
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyDispatcher(game));

        // 1000 milesegundos son 1 segundo e o timer ten o listener que é unha lambda
        timer = new Timer(counter, (ActionEvent ae) -> {

            // Si game é null (é cando remata unha partida) o é pausada a partida
            if (game == null || game.isPaused()) {
                timer.stop();
            } else {
                // Move a peza cara abaixo
                game.movePieceDown();
            }
            // Inicia o timer en caso de que o xogo sexa pausado
            timer.start();
        });
        // Inicia o timer por primeira vez (é necesario)
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDlgCredits = new javax.swing.JDialog();
        jPnlCredits = new javax.swing.JPanel();
        jLblCreditsTitle = new javax.swing.JLabel();
        jLblCredits1 = new javax.swing.JLabel();
        jLblCredits2 = new javax.swing.JLabel();
        jLblCredits3 = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JButton();
        JPnlMain = new javax.swing.JPanel();
        jPnlGame = new javax.swing.JPanel();
        jBtnRotate = new javax.swing.JButton();
        jBtnRight = new javax.swing.JButton();
        jBtnLeft = new javax.swing.JButton();
        jBtnDown = new javax.swing.JButton();
        Separator = new javax.swing.JSeparator();
        jLblTimer = new javax.swing.JLabel();
        jLblNumberTimer = new javax.swing.JLabel();
        jLblLines = new javax.swing.JLabel();
        jBtnToCredits = new javax.swing.JButton();
        jLblNumberOfLines = new javax.swing.JLabel();
        jBtnNewGame = new javax.swing.JButton();
        jTglBtnPause = new javax.swing.JToggleButton();

        jDlgCredits.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDlgCredits.setTitle("Credits");
        jDlgCredits.setLocation(new java.awt.Point(0, 0));
        jDlgCredits.setMinimumSize(new java.awt.Dimension(310, 216));
        jDlgCredits.setName(""); // NOI18N
        jDlgCredits.setPreferredSize(new java.awt.Dimension(310, 216));
        jDlgCredits.setResizable(false);

        jPnlCredits.setMinimumSize(new java.awt.Dimension(310, 216));
        jPnlCredits.setName(""); // NOI18N
        jPnlCredits.setPreferredSize(new java.awt.Dimension(310, 216));

        jLblCreditsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCreditsTitle.setText("Teistris de :");
        jLblCreditsTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLblCredits1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCredits1.setText("- Alejandro Martínez Domínguez");
        jLblCredits1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLblCredits2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCredits2.setText("- Bilo Alejandro Martins González");
        jLblCredits2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLblCredits2.setMaximumSize(new java.awt.Dimension(190, 14));
        jLblCredits2.setMinimumSize(new java.awt.Dimension(190, 14));

        jLblCredits3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCredits3.setText("- Raúl Parada de la Fuente");
        jLblCredits3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jBtnBack.setText("Atras");
        jBtnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlCreditsLayout = new javax.swing.GroupLayout(jPnlCredits);
        jPnlCredits.setLayout(jPnlCreditsLayout);
        jPnlCreditsLayout.setHorizontalGroup(
            jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCreditsLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCreditsLayout.createSequentialGroup()
                        .addComponent(jBtnBack)
                        .addGap(69, 69, 69))
                    .addComponent(jLblCreditsTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblCredits1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblCredits2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblCredits3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPnlCreditsLayout.setVerticalGroup(
            jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCreditsLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLblCreditsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits3)
                .addGap(18, 18, 18)
                .addComponent(jBtnBack)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDlgCreditsLayout = new javax.swing.GroupLayout(jDlgCredits.getContentPane());
        jDlgCredits.getContentPane().setLayout(jDlgCreditsLayout);
        jDlgCreditsLayout.setHorizontalGroup(
            jDlgCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgCreditsLayout.createSequentialGroup()
                .addComponent(jPnlCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDlgCreditsLayout.setVerticalGroup(
            jDlgCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgCreditsLayout.createSequentialGroup()
                .addComponent(jPnlCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDlgCredits.getAccessibleContext().setAccessibleName("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teistris");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(370, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(370, 600));
        setResizable(false);

        JPnlMain.setMinimumSize(new java.awt.Dimension(370, 600));
        JPnlMain.setPreferredSize(new java.awt.Dimension(370, 600));

        jPnlGame.setBackground(java.awt.Color.white);
        jPnlGame.setPreferredSize(new java.awt.Dimension(200, 400));

        javax.swing.GroupLayout jPnlGameLayout = new javax.swing.GroupLayout(jPnlGame);
        jPnlGame.setLayout(jPnlGameLayout);
        jPnlGameLayout.setHorizontalGroup(
            jPnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPnlGameLayout.setVerticalGroup(
            jPnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jBtnRotate.setText("Rotar");
        jBtnRotate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRotateActionPerformed(evt);
            }
        });

        jBtnRight.setText("Dereita");
        jBtnRight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRightActionPerformed(evt);
            }
        });

        jBtnLeft.setText("Esquerda");
        jBtnLeft.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLeftActionPerformed(evt);
            }
        });

        jBtnDown.setText("Abaixo");
        jBtnDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDownActionPerformed(evt);
            }
        });

        Separator.setBackground(java.awt.Color.black);
        Separator.setForeground(java.awt.Color.black);
        Separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Separator.setAlignmentX(1.0F);
        Separator.setAlignmentY(1.0F);
        Separator.setPreferredSize(new java.awt.Dimension(0, 0));

        jLblTimer.setText("Timer:");

        jLblNumberTimer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLblLines.setText("Liñas:");
        jLblLines.setMaximumSize(new java.awt.Dimension(26, 15));
        jLblLines.setMinimumSize(new java.awt.Dimension(26, 15));

        jBtnToCredits.setText("Creditos");
        jBtnToCredits.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnToCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToCreditsActionPerformed(evt);
            }
        });

        jLblNumberOfLines.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jBtnNewGame.setText("Nova partida");
        jBtnNewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNewGameActionPerformed(evt);
            }
        });

        jTglBtnPause.setText("Pausa");
        jTglBtnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTglBtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTglBtnPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPnlMainLayout = new javax.swing.GroupLayout(JPnlMain);
        JPnlMain.setLayout(JPnlMainLayout);
        JPnlMainLayout.setHorizontalGroup(
            JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addComponent(jBtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jTglBtnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnToCredits)
                            .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JPnlMainLayout.createSequentialGroup()
                                    .addComponent(jLblLines, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(JPnlMainLayout.createSequentialGroup()
                                    .addComponent(jLblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLblNumberTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(16, 16, 16))
        );
        JPnlMainLayout.setVerticalGroup(
            JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Separator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPnlMainLayout.createSequentialGroup()
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPnlMainLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBtnRight)
                                    .addComponent(jBtnLeft)))
                            .addGroup(JPnlMainLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jBtnDown))
                            .addComponent(jBtnRotate)))
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jBtnNewGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTglBtnPause)
                        .addGap(28, 28, 28)
                        .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblTimer)
                            .addComponent(jLblNumberTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnToCredits)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNewGameActionPerformed
        // Ao picar no botón de "Nova partida", invocamos ao método privado 
        // que inicia un novo xogo
        startGame();
    }//GEN-LAST:event_jBtnNewGameActionPerformed

    private void jTglBtnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTglBtnPauseActionPerformed
        // Ao picar no botón de "Pausa", chamamos ao obxecto xogo para 
        // establecer o atributo de pausa no estado do botón
        if (game != null) {
            game.setPaused(jTglBtnPause.isSelected());
        }
    }//GEN-LAST:event_jTglBtnPauseActionPerformed

    private void jBtnRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRotateActionPerformed
        // Ao picar no botón de "Rotar", chamamos ao obxecto xogo para que 
        // rote a peza actual
        jPnlGame.requestFocus();
        if (game != null) {
            game.rotatePiece();
        }
    }//GEN-LAST:event_jBtnRotateActionPerformed

    private void jBtnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLeftActionPerformed
        // Ao picar no botón de "Esquerda", chamamos ao obxecto xogo para que
        // se mova a peza actual á esquerda
        if (game != null) {
            game.movePieceLeft();
        }
    }//GEN-LAST:event_jBtnLeftActionPerformed

    private void jBtnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRightActionPerformed
        // Ao picar no botón de "Dereita", chamamos ao obxecto xogo para que
        // se mova a peza actual á dereita
        if (game != null) {
            game.movePieceRight();
        }
    }//GEN-LAST:event_jBtnRightActionPerformed

    private void jBtnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDownActionPerformed
        // Ao picar no botón de "Abaixo", chamamos ao obxecto xogo para que
        // se mova a peza actual cara abaixo
        if (game != null) {
            game.movePieceDown();
        }
    }//GEN-LAST:event_jBtnDownActionPerformed

    private void jBtnToCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToCreditsActionPerformed
        if (game != null) {
            game.setPaused(true);
        }
        jDlgCredits.setVisible(true);
    }//GEN-LAST:event_jBtnToCreditsActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        if (game != null) {
            game.setPaused(false);
        }
        jDlgCredits.setVisible(false);
    }//GEN-LAST:event_jBtnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPnlMain;
    private javax.swing.JSeparator Separator;
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnDown;
    private javax.swing.JButton jBtnLeft;
    private javax.swing.JButton jBtnNewGame;
    private javax.swing.JButton jBtnRight;
    private javax.swing.JButton jBtnRotate;
    private javax.swing.JButton jBtnToCredits;
    private javax.swing.JDialog jDlgCredits;
    private javax.swing.JLabel jLblCredits1;
    private javax.swing.JLabel jLblCredits2;
    private javax.swing.JLabel jLblCredits3;
    private javax.swing.JLabel jLblCreditsTitle;
    private javax.swing.JLabel jLblLines;
    private javax.swing.JLabel jLblNumberOfLines;
    private javax.swing.JLabel jLblNumberTimer;
    private javax.swing.JLabel jLblTimer;
    private javax.swing.JPanel jPnlCredits;
    private javax.swing.JPanel jPnlGame;
    private javax.swing.JToggleButton jTglBtnPause;
    // End of variables declaration//GEN-END:variables
}
