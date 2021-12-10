package herancafigura;
/**
 *
 * @author Leo
 */
public class HerancaFigura {

    public static void main(String[] args){
        Quadrado quadrado = new Quadrado();
        quadrado.Draw();

        Triangulo triangulo = new Triangulo();
        triangulo.Draw();
        
        Circulo circulo = new Circulo();
        circulo.Draw();   
        
        Losango losango = new Losango();
        losango.Draw();
        
        PassaParametroPorHeranca(losango);
    }

    public static void PassaParametroPorHeranca(Figura fig) 
    {
        fig.DrawShape();
    }    
}
    

