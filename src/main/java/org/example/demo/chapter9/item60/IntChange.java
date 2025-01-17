package org.example.demo.chapter9.item60;

class IntChange {
    public static void main(String[] args) {
        var itemsBought = 0;
        var funds = 100;
        for (var price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Cash left over: " + funds + " cents");
    }
}
