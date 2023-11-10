package ru.mirea.task10;

import java.util.ArrayList;
import java.util.List;

public class List1 {
    private List<CardNode> cards;

    public List1() {
        cards = new ArrayList<>();
    }

    public void addCard() {
        CardNode cardNode = new CardNode();
        cardNode.readAttributes();
        cards.add(cardNode);
    }

    public void removeCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayCard(int index) {
        if (index >= 0 && index < cards.size()) {
            CardNode cardNode = cards.get(index);
            cardNode.displayAttributes();
        } else {
            System.out.println("Invalid index");
        }
    }

    public void clearCards() {
        cards.clear();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
