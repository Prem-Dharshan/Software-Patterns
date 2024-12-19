package Singleton;

public enum  EnumSingleton {

    INSTANCE; // Singleton instance

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }

    public static void main(String[] args) {

        EnumSingleton singleton = EnumSingleton.INSTANCE;

        singleton.setValue("Hello, Singleton!");

        System.out.println("Singleton Value: " + singleton.getValue());

        singleton.doSomething();

        System.out.println("Are both instances the same? " + (singleton == EnumSingleton.INSTANCE));
    }
}
