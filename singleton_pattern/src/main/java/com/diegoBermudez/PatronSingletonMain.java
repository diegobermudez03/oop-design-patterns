package com.diegoBermudez;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PatronSingletonMain {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        //Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonA = ParametrizacionSingleton.getInstance();
        //Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonB = ParametrizacionSingleton.getInstance();
        System.out.println(singletonA);
        System.out.println(singletonB);
        System.out.println("Igual referencia ==> " + (singletonA == singletonB));
        singletonA.setNombreAplicacion("Patron Creacional Singleton");
        singletonB.setNumeroVersion("2.0x");
        System.out.println("SingletonA ==> " + singletonA);
        System.out.println("SingletonB ==> " + singletonB);
        singletonA = null;
        singletonB = null;
        singletonA = ParametrizacionSingleton.getInstance();
        System.out.println("singletonA ==> " + singletonA);

        Thread t1 = new Thread(PatronSingletonMain::threadAction);

        Thread t2 = new Thread(PatronSingletonMain::threadAction);

        Thread t3 = new Thread(PatronSingletonMain::threadAction);

        t1.start();
        Thread.sleep((long) (Math.random()*1000));
        t2.start();
        Thread.sleep((long) (Math.random() * 1000));
        t3.start();
        Thread.sleep((long) (Math.random() * 1000));
        t1.join();
        t2.join();
        t3.join();

        System.out.println("--------------------------------------------------");
        System.out.println("After threads execution lets check the final value in the instances: ");
        System.out.println("SINGLETON A : " + singletonA.getNumeroVersion());
    }

    private static void threadAction(){
        System.out.println("From thread: " + Thread.currentThread().getName());
        var singleton = ParametrizacionSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ": The value it has right now (version) : " + singleton.getNumeroVersion() );
        lock.lock();
        singleton.setNumeroVersion(Integer.toString((int) (Math.random() * 100)));
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + ": The value I left : " + singleton.getNumeroVersion());
    }

}