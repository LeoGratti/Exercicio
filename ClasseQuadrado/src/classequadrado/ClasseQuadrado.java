package classequadrado;
/**
 *
 * @author Leo
 */
public class ClasseQuadrado {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(0, 0, 10, 5);
        Retangulo r2 = new Retangulo(1, 0, 9, 5);

        if(r1.interceptaRetangulo(r2))
        {
            System.out.println("O retângulo 1 está interceptando o retângulo 2");
        }
        else
        {
            System.out.println("Nada aconteceu");
        }
    }
}
    
    

