package myFW;
public class MyRun {
    public static void myRun() {

        try {
            System.out.println("Здесь - код программы.\n\u001B[33m" +
                    "CITO!!! ЭТО - НЕ ЛАБОРАТОРНАЯ!!!\n\u001B[31m" +
                    "НЕ ДЛЯ ПРОВЕРКИ!!! \u001B[32mСпасибо.\u001B[0m");
        }
        // Обработка исключений
        catch (Exception err0) {
            // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
            if (!MyExc.echoExc2console2log(err0, "-7040: Сбой такой-то: "))
            { }
        }
    }
}

/*
       try {
            System.out.println("Здесь - код программы");
        }
        // Обработка исключений
        catch (Exception err0) {
            // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
            if (!MyExc.echoExc2console2log(err0, "-7040: Сбой такой-то: "))
            { }
        }
*/