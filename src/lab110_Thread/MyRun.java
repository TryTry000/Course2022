package lab110_Thread;
// Создать класс, реализующий интерфейс Runnable. Переопределить run() метод. Создать цикл for.
// В цикле распечатываем значения от 0 до 100 делящиеся на 10 без остатка. Используем статический
// метод Thread.sleep() чтобы сделать паузу. Создать три потока, выполняющих задачу распечатки значений.

// Варианты блокировки:
//  Потоки, вызывающие нестатические синхронизированные методы одного и того же класса,
//                                             будут блокировать друг друга только если они вызваны для одного объекта.
//  Потоки, вызывающие статические синхронизированные методы одного класса,
//                                             будут всегда блокировать друг друга.
//                                             Они блокируются по монитору Class объекта.
//  Статические синхронизированные и нестатические синхронизированные методы не будут блокировать друг друга никогда.
//  Для синхронизированных блоков нужно смотреть какой объект используется для синхронизации.
//  Блоки синхронизированные по одному объекту будут блокировать друг друга.


// Считаем-выводим
class MyTenth {
    void myCalc(String threadName) {
        for (int i = 0; i < 101; i++) {
            String strVal = Integer.toString(i);
            //System.out.print("Тред: " + threadName + ", i= " + strVal + ", разрядов в i =" + strVal.length());
            //System.out.println(", младший разряд: " + strVal.charAt(strVal.length()-1) );
            if (strVal.charAt(strVal.length()-1) == '0') {
                synchronized (this) { System.out.println("Тред: " + threadName + ", Кратность десяти: " + strVal); }
            }
        }
    }
}

class MyThread extends Thread {
    // Реализуем интерфейс
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            synchronized (this) { System.out.println(this.getName()); }
        } catch (Exception err0) {
            // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
            synchronized (this) {
                MyExc.echoExc2console2log(err0,"-7020: Сбой потока" + this.getName());}
        }
    }
}

class MyThreadRunnable implements Runnable {
    // Реализуем интерфейс
    @Override
    public void run() {
        try {
            MyTenth myTenth = new MyTenth();
            myTenth.myCalc(Thread.currentThread().getName());
            Thread.sleep(10);
            //System.out.println(Thread.currentThread().getName());
        }
        // Обработка исключений
        catch (Exception err0) {
            // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
            synchronized (MyThreadRunnable.this) {
                MyExc.echoExc2console2log(err0,"-7030: Сбой потока " + Thread.currentThread().getName());}
        }
    }
}

//Thread.currentThread().getName()

public class MyRun {
    public static void myRun() {
        //Создаём потоки
        MyThread aaa = new MyThread();
        MyThread bbb = new MyThread();
        aaa.setName("aaa"); aaa.start();
        bbb.setName("bbb"); bbb.start();

        try { Thread.sleep(3000); }
        // Обработка исключений
        catch (Exception err0) {
            // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
            MyExc.echoExc2console2log(err0, "-7040: Сбой потока" + Thread.currentThread().getName());
        }
        System.out.println("-----------------------");

        //Создаём потоки
        Thread ccc = new Thread( new MyThreadRunnable() );
        Thread ddd = new Thread( new MyThreadRunnable() );
        ccc.setName("ccc"); ccc.start();
        ddd.setName("ddd"); ddd.start();

        try { Thread.sleep(3000); }
        // Обработка исключений
        catch (Exception err0) {
            // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
            MyExc.echoExc2console2log(err0, "-7040: Сбой потока" + Thread.currentThread().getName());
        }
        //System.out.println("Основной поток");
        // MyTenth myTenth = new MyTenth();
        // myTenth.myCalc(Thread.currentThread().getName());
    }
}

/*
import java.awt.*;
import java.io.File;

    // Обработка исключений
    try { }
    catch (Exception err0) {
        // Ошибку - в консоль и лог. Второй параметр - шапка собщения об ошибке
        if (!MyExc.echoExc2console2log(err0, "-7020: Сбой консоли")) { return; }
    }
*/
