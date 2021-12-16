/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difquadradomarcelo;

/**
 *
 * @author Leo
 */
public class DiferencaAreaQuadrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(1, 15, 20, 10);
        Retangulo r2 = new Retangulo(2, 10, 30, 10);

        if(r1.interceptaRetangulo(r2))
        {
            System.out.println("O retângulo 1 encontra o retângulo 2");
        }
        else
        {
            System.out.println("Não encontrou");
        }

        if(r1.diferencaRetangulos(r2) != -1)
        {
            System.out.println("A diferença é " + r1.diferencaRetangulos(r2));
        }

    }
    
    
}
