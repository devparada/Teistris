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
    private Double counter;
    /**
     * Referenza ao obxecto do xogo actual
     */
    private Game game;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        game = null;
        counter = 1000.0;
        initComponents();
    }

    /**
     * Obtén o valor da variable counter
     *
     * @return Devolve o valor da variable counter
     */
    public double getCounter() {
        return counter;
    }

    /**
     * Modifica o valor da variable counter
     *
     * @param counter O valor da variable counter
     */
    public void setCounter(Double counter) {
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
        // Cada 5 líneas resta 5 milisegundos ao counter
        if (numberOfLines % 3 == 0) {
            counter = counter / 1.10;
        }
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
            // Se establece outra vez o valor a 1000 por si o usuario volve a xogar
            counter = 1000.0;
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

        // Establece o Listener na clase KeyDispatcher e se capturan allí as teclas
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyDispatcher(game));

        // 1000 milesegundos son 1 segundo e o timer ten o listener que é unha lambda
        timer = new Timer(counter.intValue(), (ActionEvent ae) -> {

            // Se cambia o valor do delay do timer (cada canto actua)
            timer.setDelay(counter.intValue());

            // Si game non é null e non está pausada a partida
            if (game != null && !game.isPaused()) {
                // Move a peza cara abaixo
                game.movePieceDown();
            }
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
        jBtPhotoCredits = new javax.swing.JButton();
        JPnlMain = new javax.swing.JPanel();
        jPnlGame = new javax.swing.JPanel();
        jBtnRotate = new javax.swing.JButton();
        jBtnRight = new javax.swing.JButton();
        jBtnLeft = new javax.swing.JButton();
        jBtnDown = new javax.swing.JButton();
        jLblLines = new javax.swing.JLabel();
        jLblNumberOfLines = new javax.swing.JLabel();
        jTglBtnPause = new javax.swing.JToggleButton();
        jBtnNovaPartida = new javax.swing.JButton();
        jMnbBarra = new javax.swing.JMenuBar();
        jMnAyuda = new javax.swing.JMenu();
        jMnICreditos = new javax.swing.JMenuItem();

        jDlgCredits.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDlgCredits.setTitle("Credits");
        jDlgCredits.setBackground(new java.awt.Color(39, 39, 39));
        jDlgCredits.setMinimumSize(new java.awt.Dimension(434, 394));
        jDlgCredits.setModal(true);
        jDlgCredits.setName(""); // NOI18N
        jDlgCredits.setPreferredSize(new java.awt.Dimension(434, 394));
        jDlgCredits.setResizable(false);

        jPnlCredits.setBackground(new java.awt.Color(39, 39, 39));
        jPnlCredits.setForeground(new java.awt.Color(39, 39, 39));
        jPnlCredits.setMinimumSize(new java.awt.Dimension(434, 394));
        jPnlCredits.setPreferredSize(new java.awt.Dimension(434, 394));

        jLblCreditsTitle.setBackground(new java.awt.Color(39, 39, 39));
        jLblCreditsTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLblCreditsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCreditsTitle.setText("Teistris de :");
        jLblCreditsTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLblCreditsTitle.setOpaque(true);

        jLblCredits1.setBackground(new java.awt.Color(39, 39, 39));
        jLblCredits1.setForeground(new java.awt.Color(255, 255, 255));
        jLblCredits1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCredits1.setText("- Alejandro Martínez Domínguez");
        jLblCredits1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLblCredits1.setOpaque(true);

        jLblCredits2.setBackground(new java.awt.Color(39, 39, 39));
        jLblCredits2.setForeground(new java.awt.Color(255, 255, 255));
        jLblCredits2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCredits2.setText("- Bilo Alejandro Martins González");
        jLblCredits2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLblCredits2.setMaximumSize(new java.awt.Dimension(190, 14));
        jLblCredits2.setMinimumSize(new java.awt.Dimension(190, 14));
        jLblCredits2.setOpaque(true);

        jLblCredits3.setBackground(new java.awt.Color(0, 0, 0));
        jLblCredits3.setForeground(new java.awt.Color(255, 255, 255));
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

        jBtPhotoCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/creditos.png"))); // NOI18N
        jBtPhotoCredits.setText("jButton1");

        javax.swing.GroupLayout jPnlCreditsLayout = new javax.swing.GroupLayout(jPnlCredits);
        jPnlCredits.setLayout(jPnlCreditsLayout);
        jPnlCreditsLayout.setHorizontalGroup(
            jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCreditsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnBack)
                .addGap(180, 180, 180))
            .addGroup(jPnlCreditsLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblCreditsTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblCredits1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblCredits2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblCredits3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(jPnlCreditsLayout.createSequentialGroup()
                .addComponent(jBtPhotoCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPnlCreditsLayout.setVerticalGroup(
            jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCreditsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLblCreditsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPhotoCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDlgCreditsLayout = new javax.swing.GroupLayout(jDlgCredits.getContentPane());
        jDlgCredits.getContentPane().setLayout(jDlgCreditsLayout);
        jDlgCreditsLayout.setHorizontalGroup(
            jDlgCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgCreditsLayout.createSequentialGroup()
                .addComponent(jPnlCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jDlgCreditsLayout.setVerticalGroup(
            jDlgCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDlgCredits.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teistris");
        setLocation(new java.awt.Point(0, 0));
        setName(""); // NOI18N
        setResizable(false);

        JPnlMain.setBackground(new java.awt.Color(39, 39, 39));
        JPnlMain.setForeground(new java.awt.Color(51, 51, 55));
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

        jLblLines.setBackground(new java.awt.Color(39, 39, 39));
        jLblLines.setForeground(new java.awt.Color(255, 255, 255));
        jLblLines.setText("Liñas:");
        jLblLines.setMaximumSize(new java.awt.Dimension(26, 15));
        jLblLines.setMinimumSize(new java.awt.Dimension(26, 15));

        jLblNumberOfLines.setBackground(new java.awt.Color(39, 39, 39));
        jLblNumberOfLines.setForeground(new java.awt.Color(255, 255, 255));
        jLblNumberOfLines.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jTglBtnPause.setForeground(new java.awt.Color(39, 39, 39));
        jTglBtnPause.setText("Pausa");
        jTglBtnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTglBtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTglBtnPauseActionPerformed(evt);
            }
        });

        jBtnNovaPartida.setForeground(new java.awt.Color(39, 39, 39));
        jBtnNovaPartida.setText("Nova partida");
        jBtnNovaPartida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnNovaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovaPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPnlMainLayout = new javax.swing.GroupLayout(JPnlMain);
        JPnlMain.setLayout(JPnlMainLayout);
        JPnlMainLayout.setHorizontalGroup(
            JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnlMainLayout.createSequentialGroup()
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jBtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jBtnLeft)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(JPnlMainLayout.createSequentialGroup()
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLblLines, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jBtnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPnlMainLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPnlMainLayout.createSequentialGroup()
                                .addComponent(jBtnNovaPartida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTglBtnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPnlMainLayout.setVerticalGroup(
            JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnlMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTglBtnPause)
                    .addComponent(jBtnNovaPartida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRotate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRight)
                    .addComponent(jBtnLeft))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDown)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMnAyuda.setText("Ayuda");

        jMnICreditos.setText("Créditos");
        jMnICreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnICreditosActionPerformed(evt);
            }
        });
        jMnAyuda.add(jMnICreditos);

        jMnbBarra.add(jMnAyuda);

        setJMenuBar(jMnbBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRotateActionPerformed
        // Ao picar no botón de "Rotar", chamamos ao obxecto xogo para que 
        // rote a peza actual
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

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        if (game != null) {
            game.setPaused(false);
        }
        jDlgCredits.setVisible(false);
    }//GEN-LAST:event_jBtnBackActionPerformed

    private void jMnICreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnICreditosActionPerformed
        if (game != null) {
            game.setPaused(true);
        }
        jDlgCredits.setVisible(true);
    }//GEN-LAST:event_jMnICreditosActionPerformed

    private void jBtnNovaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovaPartidaActionPerformed
        // Ao picar no botón de "Nova partida", invocamos ao método privado 
        // que inicia un novo xogo
        startGame();
    }//GEN-LAST:event_jBtnNovaPartidaActionPerformed

    private void jTglBtnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTglBtnPauseActionPerformed
        // Ao picar no botón de "Pausa", chamamos ao obxecto xogo para 
        // establecer o atributo de pausa no estado do botón
        if (game != null) {
            game.setPaused(jTglBtnPause.isSelected());
        }
    }//GEN-LAST:event_jTglBtnPauseActionPerformed

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
    private javax.swing.JButton jBtPhotoCredits;
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnDown;
    private javax.swing.JButton jBtnLeft;
    private javax.swing.JButton jBtnNovaPartida;
    private javax.swing.JButton jBtnRight;
    private javax.swing.JButton jBtnRotate;
    private javax.swing.JDialog jDlgCredits;
    private javax.swing.JLabel jLblCredits1;
    private javax.swing.JLabel jLblCredits2;
    private javax.swing.JLabel jLblCredits3;
    private javax.swing.JLabel jLblCreditsTitle;
    private javax.swing.JLabel jLblLines;
    private javax.swing.JLabel jLblNumberOfLines;
    private javax.swing.JMenu jMnAyuda;
    private javax.swing.JMenuItem jMnICreditos;
    private javax.swing.JMenuBar jMnbBarra;
    private javax.swing.JPanel jPnlCredits;
    private javax.swing.JPanel jPnlGame;
    private javax.swing.JToggleButton jTglBtnPause;
    // End of variables declaration//GEN-END:variables
}
