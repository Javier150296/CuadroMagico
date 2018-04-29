/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author JAVIER1
 */
public class MagicSquare {
    private Integer matriz[][];
    private Integer dimension;
    
     public MagicSquare(Integer n){
        this.matriz = new Integer [n][n];
        this.dimension=n;
    }
    public MagicSquare(){
        this.matriz = new Integer [3][3];
        this.dimension=3;
    }
    
    public Integer[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Integer[][] matriz) {
        this.matriz = matriz;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }
    
    public void setElementoMatriz(Integer posx, Integer posy, Integer elemento){
        this.matriz[posy][posx]=elemento;
    }
    
    public boolean sumaRenglones(){
        boolean res=true;
        int sum;
        int check=0;
        for(int i=0;i<dimension;i++){
            sum=0;
            for(int j=0;j<dimension; j++){
                sum+=matriz[j][i];
            }
            if(i==0){
                check=sum;
            }else{
                if(check != sum){
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
    
    public boolean sumaColumnas(){
        boolean res=true;
        int sum;
        int check=0;
        for(int i=0;i<dimension;i++){
            sum=0;
            for(int j=0;j<dimension; j++){
                sum+=matriz[i][j];
            }
            if(i==0){
                check=sum;
            }else{
                if(check != sum){
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
    
    public boolean sumaDiagonales(){
        boolean res=true;
        int sum=0;
        int check;
        
        for(int i=0;i<dimension;i++){
                sum+=matriz[i][i];
        }
        check=sum;
        sum=0;
        int j=0;
        for(int i=dimension-1;i>=0;i--){
            sum+=matriz[i][j];
            ++j;
        }
        
        if(check != sum)
            res=false;
        
        return res;
    }
    
    
    public boolean buscarRepetidos(){
        Integer reales[]=new Integer[dimension*dimension];
        Integer numeros[]=new Integer[dimension*dimension];
        int k=0;
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                reales[k]=matriz[i][j];
                numeros[k]=k+1;
                k++;
            }
        }
        boolean encontrado=false;
        int iter;
        int cont;
        for (int x=0;x<numeros.length;x++) {
            encontrado = false;
            iter = 0; // Iterador
            cont = 0;
            while ((!encontrado) && (iter < reales.length)) {
                if (reales[iter] == numeros[x])
                    cont++;
                iter++;
            }
            if(cont>1){
                encontrado=true;
                break;
            }
        }
        return encontrado;
    }
}
