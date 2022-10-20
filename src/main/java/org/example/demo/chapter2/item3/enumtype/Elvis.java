package org.example.demo.chapter2.item3.enumtype;

// Enum singleton - the preferred approach (Page 18)
public enum Elvis {
    INSTANCE;

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        var elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}
