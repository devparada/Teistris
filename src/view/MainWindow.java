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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import model.Game;

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
        if (game.getNumberOfLines() == numberOfLines) {
            counter = counter / 2;
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

        // 1000 milesegundos son 1 segundo e o timer ten o listener que é unha lambda
        timer = new Timer(counter, (ActionEvent ae) -> {

            /*
            É necesario está constante porque está dentro dunha lambda e nas lambda
            soamente se adminten variables que non cambie o seu valor (final).
            A variable counter cambia de valor antes de que se cree e está constante
            se crea e se elimina cada segundo no timer
             */
            final Integer counterText = counter;

            // Mostra o timer que queda na partida de forma actualizada
            jLblTimer.setText(counterText.toString());

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
        jLblCreditsTeistris = new javax.swing.JLabel();
        jLblCredits1 = new javax.swing.JLabel();
        jLblCredits2 = new javax.swing.JLabel();
        jLblCredits3 = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JButton();
        jLblTextCredits = new javax.swing.JLabel();
        jBtnToCredits = new javax.swing.JButton();
        jBtnNewGame = new javax.swing.JButton();
        jTglBtnPause = new javax.swing.JToggleButton();
        jPnlGame = new javax.swing.JPanel();
        jBtnRotate = new javax.swing.JButton();
        jBtnRight = new javax.swing.JButton();
        jBtnLeft = new javax.swing.JButton();
        jBtnDown = new javax.swing.JButton();
        jLblTxtTimer = new javax.swing.JLabel();
        jLblTimer = new javax.swing.JLabel();
        jLblLines = new javax.swing.JLabel();
        jLblNumberOfLines = new javax.swing.JLabel();

        jDlgCredits.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDlgCredits.setTitle("Credits");
        jDlgCredits.setLocation(new java.awt.Point(0, 0));
        jDlgCredits.setMinimumSize(new java.awt.Dimension(400, 300));
        jDlgCredits.setName(""); // NOI18N

        jPnlCredits.setMinimumSize(new java.awt.Dimension(0, 0));
        jPnlCredits.setName(""); // NOI18N

        jLblCreditsTeistris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCreditsTeistris.setText("Teistris de :");
        jLblCreditsTeistris.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
                .addGroup(jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCreditsLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblCreditsTeistris, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblCredits2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblCredits3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPnlCreditsLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jBtnBack)))
                .addGap(104, 104, 104))
        );
        jPnlCreditsLayout.setVerticalGroup(
            jPnlCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCreditsLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLblCreditsTeistris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCredits3)
                .addGap(18, 18, 18)
                .addComponent(jBtnBack)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout jDlgCreditsLayout = new javax.swing.GroupLayout(jDlgCredits.getContentPane());
        jDlgCredits.getContentPane().setLayout(jDlgCreditsLayout);
        jDlgCreditsLayout.setHorizontalGroup(
            jDlgCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDlgCreditsLayout.setVerticalGroup(
            jDlgCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDlgCredits.getAccessibleContext().setAccessibleName("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teistris");
        setLocation(new java.awt.Point(0, 0));
        setName(""); // NOI18N
        setResizable(false);

        jLblTextCredits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTextCredits.setText("Para ver os creditos do Teistris presione o botón Creditos:");

        jBtnToCredits.setText("Creditos");
        jBtnToCredits.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnToCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToCreditsActionPerformed(evt);
            }
        });

        jBtnNewGame.setText("Nova partida");
        jBtnNewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNewGameActionPerformed(evt);
            }
        });

        jTglBtnPause.setText("Pausa");
        jTglBtnPause.setToolTipText("");
        jTglBtnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTglBtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTglBtnPauseActionPerformed(evt);
            }
        });

        jPnlGame.setBackground(java.awt.Color.white);
        jPnlGame.setPreferredSize(new java.awt.Dimension(200, 300));

        javax.swing.GroupLayout jPnlGameLayout = new javax.swing.GroupLayout(jPnlGame);
        jPnlGame.setLayout(jPnlGameLayout);
        jPnlGameLayout.setHorizontalGroup(
            jPnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPnlGameLayout.setVerticalGroup(
            jPnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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

        jLblTxtTimer.setText("Timer:");

        jLblTimer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLblLines.setText("Liñas:");
        jLblLines.setMaximumSize(new java.awt.Dimension(26, 15));
        jLblLines.setMinimumSize(new java.awt.Dimension(26, 15));

        jLblNumberOfLines.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLblTextCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnToCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(95, 95, 95)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jBtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jBtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jBtnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLblLines, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLblTxtTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTglBtnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLblTextCredits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnToCredits)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnNewGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTglBtnPause)
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblTxtTimer)
                            .addComponent(jLblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jBtnLeft))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBtnDown))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jBtnRight))
                    .addComponent(jBtnRotate)))
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
        jDlgCredits.setVisible(true);
    }//GEN-LAST:event_jBtnToCreditsActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLblCreditsTeistris;
    private javax.swing.JLabel jLblLines;
    private javax.swing.JLabel jLblNumberOfLines;
    private javax.swing.JLabel jLblTextCredits;
    private javax.swing.JLabel jLblTimer;
    private javax.swing.JLabel jLblTxtTimer;
    private javax.swing.JPanel jPnlCredits;
    private javax.swing.JPanel jPnlGame;
    private javax.swing.JToggleButton jTglBtnPause;
    // End of variables declaration//GEN-END:variables
}
