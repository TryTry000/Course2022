package lab070_Nasled;
// Создайте пример наследования. Реализуйте класс Student и класс Aspirant, аспирант отличается от студента
// наличием некой научной работы.
//
// Класс Student содержит переменные: String firstName, lastName, group. А также double averageMark - среднюю оценку.
//
// Создайте переменную типа Student, которая ссылается на объект типа Aspirant.
// Создайте метод getScholarship() для класса Student, который возвращает сумму стипендии. Если средняя оценка студента
// равна 5 баллам, то сумма 100 р, иначе 80 р. Переопределить этот метод в классе Aspirant. Если средняя оценка
// аспиранта равна 5 баллам, то сумма 200 р, иначе 180 р.
//
// Создайте массив типа Student, содержащий объекты класса Student и Aspirant. Вызовите метод getScholarship() для
// каждого элемента массива.

// ================== Класс Student ====================================================================================
class Student {
    protected String studentStatus;
    protected String firstName;
    protected String lastName;
    protected Integer group;
    protected Double averageMark;
    protected Integer stipa;

    // Конструктор
    public Student (String firstName, String lastName, Integer group, Double averageMark) {
        this.studentStatus = "СТУДЕНТ";
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
        if ( averageMark == 5 ) { this.stipa = 100; } else this.stipa = 80;
    }

    // Геттер
       public Integer getStipa() { return this.stipa; }

    // Печать информации о Студенте
    public void printInfo () {
        System.out.format("-- %s --------------------%n", studentStatus);
        System.out.println(this.lastName + " " + this.firstName + "");
        System.out.format("Группа %s; Успеваемость %s;%n", this.group, this.averageMark);
    }
}

// ================== Класс Аспирант ===================================================================================
class Aspirant extends Student {
    protected String tema;     // Тема научной работы аспиранта
    // Конструктор
    public Aspirant (String firstName, String lastName, Integer group, Double averageMark, String tema) {
        super(firstName, lastName, group, averageMark);     // ибо родительский класс имеет конструктор
        this.studentStatus = "АСПИРАНТ";
        this.tema = tema;
        if ( averageMark == 5 ) { this.stipa = 200; } else this.stipa = 180;
    }
    // Геттеры
    public String getLastName() { return this.lastName; }
    public String getTema()     { return this.tema;     }
}

// ================== Корневой класс ===================================================================================
public class Main {
    public static void main (String[] args) {
        Student[] student = new Student[5];
        student[0] = new Student("Иванов", "Иван", 7, 4.9);
        student[1] = new Student("Петров", "Петр", 11, 5.0);
        student[2] = new Aspirant("Рудольф", "Хлебовводов", 6, 3.7, "Народу это не надо!");
        student[3] = new Student("Сидор", "Сидоров", 7, 4.1);
        student[4] = new Aspirant("Арон", "Фарфуркис", 6, 5.0, "Народ предпочитает открытые авто!");

        for (Student stdt : student) {
            stdt.printInfo();
            System.out.format("Стипа %s таньга.", stdt.getStipa());
            System.out.println();
        }

        Aspirant aspirant = (Aspirant) student[4];
        System.out.println("=================================");
        System.out.println("=== ТЕМЫ РАБОТ АСПИРАНТОВ =======");
        System.out.println("=== Восходящее преобразование ===");
        System.out.println("---------------------------------");
        System.out.format("Аспирант: %s%n",aspirant.getLastName());
        System.out.format("Тема: \"%s\"%n",aspirant.getTema());
        System.out.println("---------------------------------");
    }
}
