package jardimdeflores;

public class Flor {
    Petala petala1;
    Petala petala2;
    Petala petala3;
    Petala petala4;
    Petala petala5;
    
    //metodos para a petala 1
    public void setPetala1(Petala petala){
        this.petala1 = petala;
    }
    
    public boolean temPetala1(){
        if (petala1 == null){
            return false;
        }
        return true;
    }
    
    public Petala getPetala1(){
        return petala1;
    }
    
        //metodos para a petala 2
    public void setPetala2(Petala petala2){
        this.petala2 = petala2;
    }
    
    public boolean temPetala2(){
        if(petala2 == null){
            return false;
        }
        return true;
    }
    
    public Petala getPetala2(){
        return petala2;
    }
    
    //metodos para a petala 3
    public void setPetala3(Petala petala3){
        this.petala3 = petala3;
    }
    
    public boolean temPetala3(){
        if(petala3 == null){
            return false;
        }
        return true;
    }
    
    public Petala getPetala3(){
        return petala3;
    }
    
    //metodos para a petala 4
    public void setPetala4(Petala petala4){
        this.petala4 = petala4;
    }
    
    public boolean temPetala4(){
        if(petala4 == null){
            return false;
        }
        return true;
    }
    
    public Petala getPetala4(){
        return petala4;
    }
    
    //petala 5
    public void setPetala5(Petala petala){
        this.petala5 = petala;
    }
    
    public boolean temPetala5(){
        if (petala5 == null){
            return false;
        }
        return true;
    }
    
    public Petala getPetala5(){
        return petala5;
    }
}
