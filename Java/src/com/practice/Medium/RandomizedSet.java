package com.practice.Medium;

import java.util.LinkedHashSet;

/**
 * #380
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class RandomizedSet {
    java.util.Random _rand = new java.util.Random();
    LinkedHashSet<Integer> _lhs;
    public RandomizedSet() { _lhs = new LinkedHashSet<>(); }
    public boolean insert(int val) {
        if(_lhs.contains(val)) return false;
        _lhs.add(val);
        return true;
    }
    public boolean remove(int val) {
        if(!_lhs.contains(val)) return false;
        _lhs.remove(val);
        return true;
    }
    public int getRandom() {
        int index = _rand.nextInt(_lhs.size());
        return (int)(_lhs.toArray()[index]);
    }
}
