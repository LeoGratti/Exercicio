package jardimdeflores;

public class Principal {
    
    public static void main(String[] args){     
          
        //8 petalas
        Petala p1 = new Petala();
        p1.setCorPetala("Amarelo");
                
        Petala p2 = new Petala();
        p2.setCorPetala("Laranja");   
        
        Petala p3 = new Petala();
        p3.setCorPetala("Branco"); 
        
        Petala p4 = new Petala();
        p4.setCorPetala("Azul"); 
        
        Petala p5 = new Petala();
        p5.setCorPetala("Verde"); 
        
        Petala p6 = new Petala();
        p6.setCorPetala("Verde"); 
        
        Petala p7 = new Petala();
        p7.setCorPetala ("Roxo"); 
        
        Petala p8 = new Petala();
        p8.setCorPetala("Rosa"); 
        
        //4 flores
        Flor margarida = new Flor();
        margarida.setPetala1(p1);
        
        Flor CopoDeLeite = new Flor();
        CopoDeLeite.setPetala2(p2);
        
        Flor Girassol = new Flor();
        Girassol.setPetala3 (p3);
        
        Flor Tulipa = new Flor();
        Tulipa.setPetala4(p4);
        
        //Petala petalaAtual = margarida.getPetala1();
           
        //2 jardins
        Jardim j1 = new Jardim();
        j1.setFlor1(margarida);
        j1.setFlor2(CopoDeLeite);
        
        Jardim j2 = new Jardim();
        j2.setFlor1(Girassol);
        j2.setFlor2(Tulipa);
        
        //1 praça
        Pracinha pracinha = new Pracinha(); 
        pracinha.setJ1(j1);
        
        System.out.println("Pracinha com dois jardins: "); 
        System.out.println("Primeiro jardim com as flores: "+margarida.getPetala1().getCorPetala()
        + " e " + p8.getCorPetala() + ", "+ CopoDeLeite.getPetala2().getCorPetala() + " e " +p3.getCorPetala());
        System.out.println("Segundo jardim com as flores: "+Girassol.getPetala3().getCorPetala() + " e " 
        + p5.getCorPetala() + ", "+ Tulipa.getPetala4().getCorPetala()+ " e " +p7.getCorPetala());
    }
}
