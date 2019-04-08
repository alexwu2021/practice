package Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealDeckInIncreasingOrder {

    /** passed oj
     *
     *
     * In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
     *
     * Initially, all the cards start face down (unrevealed) in one deck.
     *
     * Now, you do the following steps repeatedly, until all cards are revealed:
     *
     * Take the top card of the deck, reveal it, and take it out of the deck.
     * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
     * If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
     *
     * Return an ordering of the deck that would reveal the cards in increasing order.
     *
     * The first entry in the answer is considered to be the top of the deck.
     *
     *
     *
     * Example 1:
     *
     * Input: [17,13,11,2,3,5,7]
     * Output: [2,13,3,11,5,17,7]
     *
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; ++i) q.offer(i);

        int [] res = new int[n];
        int j = 0;
        while(!q.isEmpty() && j < n){
            // at each iteration, we set one up
            // but the element to set up is dynamically decided by the index queue
            // where deck is the dispenser
            res[q.poll()] = deck[j++];

            //simulate the operation: put the second card to bottom
            q.offer(q.poll());
        }
        return res;
    }
}
