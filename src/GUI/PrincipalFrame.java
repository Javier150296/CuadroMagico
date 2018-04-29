/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Listeners.EncabezadoListener;
import Objects.MagicSquare;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JAVIER1
 */
public class PrincipalFrame extends JFrame{
    private Encabezado pnlEncabezado;
    private PanelText panelText;
    private MagicSquare square;
    private JPanel pnlSur;
    private JButton btnLimpiar;
    private JButton btnVerificar;
    private JButton btnSalir;
    
    public PrincipalFrame(){
        super("Cuadro Mágico");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(320,120);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        
        square = new MagicSquare(3);
        pnlEncabezado = new Encabezado();
        panelText= new PanelText();
        pnlSur = new JPanel();
        btnLimpiar = new JButton("Limpiar");
        btnVerificar = new JButton("Verificar");
        btnSalir = new JButton("Salir");
        pnlSur.setLayout(new FlowLayout());
        pnlSur.setBackground(Color.WHITE);
        pnlSur.add(btnLimpiar);
        pnlSur.add(btnVerificar);
        pnlSur.add(btnSalir);
        btnVerificar.setEnabled(false);
        btnLimpiar.setEnabled(false);
        
        pnlEncabezado.setListener(new EncabezadoListener() {
            @Override
            public void OnClickAceptar(Integer dim) {
                panelText.removeAll();
                PrincipalFrame.this.square= new MagicSquare(dim);
                panelText.drawText(square);
                if(dim*30>320){
                    PrincipalFrame.this.setSize(dim*30, dim*30+120);
                }else{
                    PrincipalFrame.this.setSize(320,dim*30+120 );
                }
                PrincipalFrame.this.repaint();
                btnVerificar.setEnabled(true);
                btnLimpiar.setEnabled(true);
            }
        });
        
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelText.removeAll();
                PrincipalFrame.this.square= new MagicSquare(square.getDimension());
                panelText.drawText(square);
                PrincipalFrame.this.repaint();
            }
        });
        
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!panelText.isEmpty(square)){
                    panelText.extraerCuadro(square);
                    if(PrincipalFrame.this.square.buscarRepetidos()){
                        JOptionPane.showMessageDialog(null, "No se pueden repetir números", "Incorrecto", JOptionPane.ERROR_MESSAGE); 
                    }else if(!PrincipalFrame.this.square.sumaColumnas()){
                        JOptionPane.showMessageDialog(null, "Las sumas en columnas no es igual", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                    }else if(!PrincipalFrame.this.square.sumaRenglones()){
                        JOptionPane.showMessageDialog(null, "Las sumas en renglones no es igual", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                    }else if(!PrincipalFrame.this.square.sumaDiagonales()){
                        JOptionPane.showMessageDialog(null, "Las sumas en diagonales no es igual", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                    }else{
                        new WinFrame();
                        PrincipalFrame.this.setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Hay campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(panelText, BorderLayout.CENTER);
        super.add(pnlSur, BorderLayout.SOUTH);
        super.setVisible(true);
    }
                
}
