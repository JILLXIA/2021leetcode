package ByteDance.FlattenNestedListIterator341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
 *
 * Implement the NestedIterator class:
 *
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * Your code will be tested with the following pseudocode:
 */
class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList();
    int position = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattern(nestedList);
    }

    public void flattern(List<NestedInteger> nestedList){
        for(int i = 0;i<nestedList.size();i++){
            if(nestedList.get(i).isInteger()){
                list.add(nestedList.get(i).getInteger());
            } else {
                flattern(nestedList.get(i).getList());
            }
        }
    }
    @Override
    public Integer next() {
        if(position >= list.size()){
            return -1;
        }
        Integer result = list.get(position);
        position++;
        return result;
    }

    @Override
    public boolean hasNext() {
        if(position >= list.size()){
            return false;
        }
        return true;
    }
}

interface NestedInteger {
// @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
// @return the single integer that this NestedInteger holds, if it holds a single integer
// Return null if this NestedInteger holds a nested list
    public Integer getInteger();
// @return the nested list that this NestedInteger holds, if it holds a nested list
 // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}