package com.practice.Easy.Hard;

import java.util.*;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 */
public class ReconstructItinerary {

    class MyNode{
        String parent;
        List<Map<String, Integer>>children;

        public MyNode(String parent, String destination){
            this.parent = parent;
            children = new ArrayList<>();
            Map<String, Integer>tm = new TreeMap<>();
            tm.put(destination, 1);
            children.add(tm);
        }

        public void addChild(String child){
            for(Map<String, Integer>mp: this.children){
                if(!mp.containsKey(child)) continue;
                mp.put(child, mp.get(child) + 1);
            }
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> ret = new ArrayList<>();
        Map<String, MyNode>mp = new HashMap<>();
        MyNode myNode;
        for(List<String>ticket: tickets){
            if(!mp.containsKey(ticket.get(0))){
                myNode = new MyNode(ticket.get(0), ticket.get(1));
            } else {
                myNode = mp.get(ticket.get(0));
                myNode.addChild(ticket.get(1));
            }
            mp.put(ticket.get(0), myNode);
        }

        return ret;
    }
}
