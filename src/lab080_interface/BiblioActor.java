package lab080_interface;

public class BiblioActor {
    protected String biblioActorName;
    protected String bookISBN = "";

    // Конструктор
    public BiblioActor(String biblioActorName) {
        this.biblioActorName = biblioActorName;
    }
    // Сеттер
    public void setBookISBN (String bookISBN) {
        this.bookISBN = bookISBN;
    }
}
