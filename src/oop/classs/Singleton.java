package oop.classs;

class Singleton {
    private static Singleton instance;
    private Singleton() {} // no one outside can call new Singleton()
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}