package org.example.demo.chapter2.item8;

// Well-behaved client of resource with cleaner safety-net (Page 33)
class Adult {
    public static void main(String[] args) {
        try (var myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
