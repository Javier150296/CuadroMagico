/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author JAVIER1
 */
public class TextNumbers extends JTextField {
     private Integer xM;
    private Integer yM;

    public Integer getxM() {
        return xM;
    }

    public void setxM(Integer xM) {
        this.xM = xM;
    }

    public Integer getyM() {
        return yM;
    }

    public void setyM(Integer yM) {
        this.yM = yM;
    }
    
    
    public TextNumbers(Integer x, Integer y){
        super("");
        this.xM=x;
        this.yM=y;
        super.setFont(new Font("Courier new", Font.BOLD, 24));
        super.setHorizontalAlignment(SwingConstants.CENTER);
        super.setForeground(Color.BLACK);
        super.setBackground(Color.YELLOW);
    }
}
