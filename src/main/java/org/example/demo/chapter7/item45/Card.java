package org.example.demo.chapter7.item45;

import java.util.ArrayList;
import java.util.List;

// Generating the Cartesian product of two lists using iteration and streams (Page 209)
class Card {
    private static final List<Card> NEW_DECK = newDeck();
    private final Suit suit;
    private final Rank rank;
    private Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

    }

    // Iterative Cartesian product computation
    private static List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (var suit : Suit.values())
            for (var rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "S";
    }

    public enum Suit {SPADE, HEART, DIAMOND, CLUB}

    //    // Stream-based Cartesian product computation
    //    private static List<Card> newDeck() {
    //        return Stream.of(Suit.values())
    //                .flatMap(suit ->
    //                        Stream.of(Rank.values())
    //                                .map(rank -> new Card(suit, rank)))
    //                .collect(toList());
    //    }

    public enum Rank {
        ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
}
