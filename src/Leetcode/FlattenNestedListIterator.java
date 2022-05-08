package src.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> list;
    int listIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>(nestedList.size() * 3);
        listIndex = 0;
        searchAdd(nestedList);
    }

    private void searchAdd(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInt : nestedList) {
            if (nestedInt.isInteger())
                list.add(nestedInt.getInteger());
            else
                searchAdd(nestedInt.getList());
        }
    }

    @Override
    public Integer next() {
        return list.get(listIndex++);
    }

    @Override
    public boolean hasNext() {
        return listIndex < list.size();
    }
}
