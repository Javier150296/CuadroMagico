/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Listeners.EncabezadoListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author JAVIER1
 */
public class Encabezado extends JPanel{
    private JRadioButton rBtn3;
    private JRadioButton rBtn4;
    private JRadioButton rBtn5;
    private JRadioButton rBtnNxN;
    private ButtonGroup btnGrpSelect;
    private JButton aceptar;
    private EncabezadoListener listener;
    
    public Encabezado(){
        super();
        super.setBackground(Color.ORANGE);
        super.setLayout(new FlowLayout());
        
        rBtn3 = new JRadioButton("3x3");
        rBtn3.setBackground(Color.ORANGE);
        rBtn4 = new JRadioButton("4x4");
        rBtn4.setBackground(Color.ORANGE);
        rBtn5 = new JRadioButton("5x5");
        rBtn5.setBackground(Color.ORANGE);
        rBtnNxN = new JRadioButton("NxN");
        rBtnNxN.setBackground(Color.ORANGE);
        btnGrpSelect = new ButtonGroup();
        btnGrpSelect.add(rBtn3);
        btnGrpSelect.add(rBtn4);
        btnGrpSelect.add(rBtn5);
        btnGrpSelect.add(rBtnNxN);
        aceptar = new JButton("Aceptar");
        rBtn3.setSelected(true);
        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rBtn3.isSelected())
                    listener.OnClickAceptar(3);
                else if( rBtn4.isSelected())
                    listener.OnClickAceptar(4);
                else if( rBtn5.isSelected())
                    listener.OnClickAceptar(5);
                else if( rBtnNxN.isSelected()){
                    String entrada=JOptionPane.showInputDialog(null, "Ingresa la dimensión del cuadro","NxN",JOptionPane.QUESTION_MESSAGE);
                    if(entrada!=null){
                        entrada=Character.toString(entrada.charAt(0));
                        listener.OnClickAceptar(Integer.parseInt(entrada));
                    }
                }
            }
        });
        
        super.add(rBtn3);
        super.add(rBtn4);
        super.add(rBtn5);
        super.add(rBtnNxN);
        super.add(aceptar);
    }
    
    public void setListener(EncabezadoListener listener){
        this.listener=listener;
    }
}
