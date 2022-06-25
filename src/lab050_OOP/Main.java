package lab050_OOP;

// 1. Создать класс Person, который содержит:
// - переменные fullName, age;
// - методы move() и talk(), в которых вывести на консоль сообщение "Такой-то  Person говорит".
// 2. Добавить два конструктора: Person() и Person(fullName, age).
// 3. Создать два объекта этого класса:  Person() и Person(fullName, age).

class FullName {
    String name = "Имярек";
    String fName = "неизвестно";
    String sName = "неизвестно";
}

class Person {
    // Объявление переменных (свойств, мать их так-перетак...)
    FullName fullName = new FullName();
    int age = 0;
    String age2print = "неизвестно";

    // Конструкторы (дабы не напрягать жизнерадостного юзера классов)
    // Неясный чувак
    Person() {
    }
    // Ясный чувак
    Person(String name, String fName, String sName, int age) {
        this.fullName.name = name;
        this.fullName.fName = fName;
        this.fullName.sName = sName;
        this.age = age;
        if (age != 0) {
            this.age2print = "" + age;
        }
    }

    // Методы
    void talk(String speach) {
        System.out.println("------------------------------------------");
        System.out.println("Имя: " + this.fullName.name);
        System.out.println("Отчество: " + this.fullName.fName);
        System.out.println("Фамилия: " + this.fullName.sName);
        System.out.println("Возраст: " + this.age2print);
        System.out.println("говорит: " + speach);
    }
    void move() {
        System.out.println("------------------------------------------");
        System.out.println("Не знаю, как \"Динамо\", но " +
                this.fullName.name + " бежит!");
    }
}

// Ну и, собственно, программа
public class Main {
        public static void main(String[] args) {
        Person unknownHero = new Person();
        Person knownIvan = new Person( "Иванов", "Иван", "Иваныч", 41);
        Person knownIsus = new Person( "Иисус", "Саваофыч", "Палестинский", 33);
        Person knownBatyr = new Person( "Батыр", "Ялумбекович", "Заалтайсий", 79);

        knownIsus.talk ( "Всем привет!");
        knownIvan.talk ( "Здрасьте!");
        knownBatyr.talk ( "Динамо бежит?");
        unknownHero.talk ( "Да, ответьте плз!");
        knownIsus.move ( );
        knownBatyr.talk ( "А все бегущие известны?");
        unknownHero.move ( );
    }
}

