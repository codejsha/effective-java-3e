package org.example.demo.chapter9.item60;

class Change {
    // Broken - uses floating point for monetary calculation!
    public static void main(String[] args) {
        var funds = 1.00;
        var itemsBought = 0;
        for (var price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }
}
