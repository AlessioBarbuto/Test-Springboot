package com.example.casinodrools.entity;

/**
 * Is a representation of a Roulette Spin, the attribute "bet" could be "Dozen","Color" or "Number". The attribute probability
 * is the probability in % that a specified is winning.
 */
public class RouletteSpin {

    private String bet;
    private int probability;

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
