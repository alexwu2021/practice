package Medium;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class TopKFrequentWords {

    /** passed oj, inspired by sequeira
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        if(words == null || words.length <= 0) return res;
        Map<String, Integer> count = new HashMap<>();
        for(String word : words) count.put(word, count.getOrDefault(word, 0) + 1);

        // break ties by key comparison
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) ->
                (a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));

        for(Map.Entry<String, Integer> entry: count.entrySet()) {
            pq.offer(entry);

            // k size maintenance, has to do it
            if(pq.size() > k) pq.poll();
        }
        while(!pq.isEmpty()) res.add(0, pq.poll().getKey());
        return res;
    }
}
