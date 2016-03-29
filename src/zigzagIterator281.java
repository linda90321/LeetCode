import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].*/
public class zigzagIterator281 {
    /*
    Uses a linkedlist to store the iterators in different vectors. Every time we call next(), we pop an element from the list, and re-add it to the end to cycle through the lists.
    List:
    iterator()
    Returns an iterator over the elements in this list in proper sequence.
    */
    LinkedList<Iterator<Integer>> sum=new LinkedList<Iterator<Integer>>();
    public zigzagIterator281(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty()) sum.add(v1.iterator());
        if(!v2.isEmpty()) sum.add(v2.iterator());
    }

    public int next() {
       Iterator<Integer> temp=sum.remove();
       int res=temp.next();
       if(temp.hasNext())
       sum.add(temp);  
       return res;
    }

    public boolean hasNext() {
        return sum.size()!=0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
