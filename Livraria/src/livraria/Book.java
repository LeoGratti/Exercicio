package livraria;

public class Book {    
    private String title;
    private Author author;
    private Publisher publisher;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Author getAuthor(Author author){
        return author;        
    }
    
    public void setAuthor(Author author){
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }     
}
