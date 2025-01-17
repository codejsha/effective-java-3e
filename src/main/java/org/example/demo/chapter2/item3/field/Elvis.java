package org.example.demo.chapter2.item3.field;

// Singleton with public final field  (Page 17)
class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        var elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}
