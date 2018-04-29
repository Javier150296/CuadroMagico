/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.MagicSquare;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author JAVIER1
 */
public class PanelText extends JPanel{
    
    public PanelText(){
        super();
        super.setBackground(Color.WHITE);
        super.setLayout(null);
    }
    
    public void drawText(MagicSquare magic){
        for(int i=0; i<magic.getDimension(); i++){
            for(int j=0; j<magic.getDimension(); j++){
                TextNumbers campo = new TextNumbers(j,i);
                campo.setBounds(i*31, j*31, 30, 30);
                super.add(campo);
            }
        }
    }
    
    public boolean isEmpty(MagicSquare magic){
        TextNumbers aux;
        boolean result=false;
        for(int i=0; i<magic.getDimension(); i++){
            for(int j=0; j<magic.getDimension(); j++){
                aux=(TextNumbers)this.getComponentAt(i*31, j*31);
                if(aux.getText()==null || "".equals(aux.getText())){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
    
    public void extraerCuadro(MagicSquare magic){
        for(int i=0; i<magic.getDimension(); i++){
            for(int j=0; j<magic.getDimension(); j++){
                extraer((TextNumbers) this.getComponentAt(i*31, j*31),magic);
            }
        }
    }
    
    private void extraer(TextNumbers elemento, MagicSquare magic){
        magic.setElementoMatriz(elemento.getxM(), elemento.getyM(), Integer.valueOf(elemento.getText()));
    }
}
