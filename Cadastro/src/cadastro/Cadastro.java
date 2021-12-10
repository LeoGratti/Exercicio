package cadastro;
/**
 *
 * @author Leo
 */
public class Cadastro {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa leonardo = new Pessoa();
        Pessoa leozim = new Pessoa();

        leonardo.setNome("Leonardo");
        leonardo.setEndereco("Avenida Amoreiras");
        leonardo.setIdade("14");

        leozim.setNome("Leozim");
        leozim.setEndereco("Avenida Barão de Itapura");
        leozim.setIdade("20");

        CRUDPessoas crud = new CRUDPessoas();

        crud.AdicionarPessoa(leonardo);
        crud.AdicionarPessoa(leozim);

        System.out.println(crud.GerarRelatorio()); 

        crud.RemoverPessoa(leonardo);

        System.out.println(crud.GerarRelatorio()); 

        leozim.setNome("Leozim");
        crud.AtualizarPessoa(leonardo);

        System.out.println(crud.GerarRelatorio());
    }    
}
