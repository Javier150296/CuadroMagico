/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JAVIER1
 */
public class WinFrame extends JFrame{
    private JLabel lblImg;
    private JPanel pnlBtns;
    private JButton btnNuevo;
    private JButton btnSalir;
    private JLabel lblWin;
    
    
    public WinFrame(){
        super("Ganador");
        super.setSize(130,250);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        
        lblWin = new JLabel(" Correcto!");
        lblWin.setFont(new Font("Courier new", Font.BOLD, 20));
        lblImg = new JLabel();
        cargarIcono("/images/001-cup.png", lblImg);
        pnlBtns = new JPanel();
        btnNuevo = new JButton("Nuevo Juego");
        btnSalir = new JButton("Salir");
        pnlBtns.setLayout(new BorderLayout());
        pnlBtns.add(btnNuevo, BorderLayout.NORTH);
        pnlBtns.add(btnSalir, BorderLayout.SOUTH);
        
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrincipalFrame();
                WinFrame.this.setVisible(false);
            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        super.add(lblWin, BorderLayout.NORTH);
        super.add(lblImg, BorderLayout.CENTER);
        super.add(pnlBtns, BorderLayout.SOUTH);
        super.setVisible(true);
    }
    private void cargarIcono(String path, JLabel lbl){
        URL url = System.class.getResource(path);
        ImageIcon im =new ImageIcon(url);
        lbl.setIcon(im);
    }
}
