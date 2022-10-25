package org.example.demo.chapter2.item3.staticfactory;

// Singleton with static factory (Page 17)
class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        var elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}
