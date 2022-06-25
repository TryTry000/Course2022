package lab080_interface;
// Разработать иерархию работников библиотеки. Реализовать совмещение нескольких ролей в библиотеке в одном
// исполнителе через интерфейсы. Каждый объект в программе имеет определенный набор действий.

//  Часто программист, создающий объект, не представляет все ситуации, в которых тот будет использоваться. Также
//  программисту, использующему объект, часто неизвестны все его детали. Для передачи информации о том, что должен
//  уметь объект, используются интерфейсы. Примером интерфейсов в нашей библиотеке может служить понятие роли на
//  проекте. Каждая роль подразумевает набор определенных операций, которые должен "уметь" объект пользователь —
//  User в программе.

//  --- Функционал программы
//      Создайте иерархию "Пользователи библиотеки" со следующими интерфейсами:
//      Читатель – берет и возвращает книги.
//      Библиотекарь – заказывает книги.
//      Поставщик книг – приносит книги в библиотеку.
//      Администратор – находит и выдает книги и уведомляет о просрочках времени возврата.
//      В методе public static void main создайте 2-3 объекта, реализующих эти интерфейсы.

// ------------- Библиотекарь ------------------------------------------------------------------------------------------
class BiblioTekar extends BiblioActor implements Info {
    double actorGlasses; // диоптрии очков
    // Конструктор
    public BiblioTekar(String biblioActorName, double actorGlasses) {
        super(biblioActorName);
        this.actorGlasses = actorGlasses;
    }
    // Интерфейс
    public void Info2prn() {
        System.out.format("Фамилия: %s%nДиоптрии очков: %s%nКнига (ISBN-%s) заказана%n",
                           this.biblioActorName, this.actorGlasses, this.bookISBN);
    }
}
// ------------- Разносчик пиццы ---------------------------------------------------------------------------------------
class BiblioCourier extends BiblioActor implements Info {
    String actorPizza; // какую пиццу любит
    // Конструктор
    public BiblioCourier(String biblioActorName, String actorPizza) {
        super(biblioActorName);
        this.actorPizza = actorPizza;
    }
    // Интерфейс
    public void Info2prn() {
        System.out.format("Фамилия: %s%nЛюбимая пицца: %s%nКнигу (ISBN-%s) в библио-хранилище привёз%n",
                           this.biblioActorName, this.actorPizza, this.bookISBN);
    }
}
// ------------- Администратор библиотеки ------------------------------------------------------------------------------
class BiblioAdmin extends BiblioActor implements Info {
    String bookState = "выдана читателю";
    // Конструктор
    public BiblioAdmin(String biblioActorName, boolean timeOut) { // true - просрочена
        super(biblioActorName);
        if ( timeOut ) this.bookState = "просрочена!!! Кошмаррр!!!";
    }

    // Интерфейс
    public void Info2prn() {
        System.out.format("Фамилия: %s%nКнига %s%nКнига (ISBN-%s) %n",
                this.biblioActorName, this.bookState, this.bookISBN);
    }
    // Сеттер
    public void setBookState(boolean timeOut) {
        if ( timeOut ) { this.bookState = "просрочена!!! Кошмаррр!!!"; }
        else { this.bookState = "выдана читателю"; }
    }
}

// ------------- Читатель ----------------------------------------------------------------------------------------------
class BiblioUser extends BiblioActor implements Info {
    int actorID; // номер читательского билета
    // Конструктор
    public BiblioUser(String biblioActorName, int actorID) {
        super(biblioActorName);
        this.actorID = actorID;

    }
    // Интерфейс
    public void Info2prn() {
        System.out.format("Фамилия: %s%nЧитательский билет: %s%nКнига (ISBN-%s) взял почитать%n",
                this.biblioActorName, this.actorID, this.bookISBN);
    }
}

// ------------- Корневой класс ----------------------------------------------------------------------------------------
public class Main {
    // Реализация интерфейса как универсального метода с параметром
    public static void infoOut(Info info) { info.Info2prn(); }
    // начало программы
    public static void main(String[] args) {
        BiblioTekar   biblioTekar   = new BiblioTekar ("Иванова", 4.1);
        biblioTekar.setBookISBN("5-1234-0678-9");
        BiblioCourier biblioCourier = new BiblioCourier ("Алиман Куюк", "Маргарита");
        biblioCourier.setBookISBN("5-1234-0678-9");
        BiblioAdmin   biblioAdmin   = new BiblioAdmin ("Джапаридзе", false);
        biblioAdmin.setBookISBN("5-1234-0678-9");
        BiblioUser    biblioUser    = new BiblioUser ("Сидоров", 13131);
        biblioUser.setBookISBN("5-1234-0678-9");

        System.out.println();
        System.out.println("=====================================");
        System.out.println("=== КРУГОВОРОТ КНИГ В БИБЛИОТЕКЕ ====");
        System.out.println("=== (способ info.Info2prn(); ========");
        System.out.println("=====================================");
        Info info;
        System.out.println("---------------------");
        System.out.println("Библиотекарь");
        info = biblioTekar;
        info.Info2prn();
        System.out.println("---------------------");
        System.out.println("Курьер");
        info = biblioCourier;
        info.Info2prn();
        System.out.println("---------------------");
        System.out.println("Администратор библиотеки");
        info = biblioAdmin;
        info.Info2prn();
        System.out.println("---------------------");
        System.out.println("Читатель");
        info = biblioUser;
        info.Info2prn();
        System.out.println("---------------------");
        System.out.println("Администратор библиотеки");
        biblioAdmin.setBookState (true);
        info = biblioAdmin;
        info.Info2prn();

        System.out.println();
        System.out.println("=====================================");
        System.out.println("=== КРУГОВОРОТ КНИГ В БИБЛИОТЕКЕ ====");
        System.out.println("=infoOut(Info info){info.Info2prn();}");
        System.out.println("=====================================");
        System.out.println("---------------------");
        System.out.println("Читатель");
        infoOut(biblioUser);
        System.out.println("---------------------");
        System.out.println("Администратор библиотеки");
        infoOut(biblioAdmin);
    }
}
