package org.example.demo.chapter2.item8;

import java.lang.ref.Cleaner;

// An autocloseable class using a cleaner as a safety net (Page 32)
class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();
    // The state of this room, shared with our cleanable
    private final State state;
    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        private int numJunkPiles; // Number of junk piles in this room

        private State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }
}
