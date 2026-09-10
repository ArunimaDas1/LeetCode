import java.util.Map;
import java.util.TreeMap;

import org.w3c.dom.Node;

public class TopVTree(Node root) {
    <Queue> q= new queue<>():
    Map<Integer,Integer> map= new TreeMap<>();

    q.add(new pair(root, 0));
    while(!q.isEmpty()){
        pair currPair = q.poll();
        Node curr= currPair.node;
        int currHD= currPair.hd;

        if(!map.containsKey(currHD)){
            map.put(currHD, curr);
        }

        if(curr.left!= null){
            q.add(new pair(curr.left,currHD-1));

        }

        if(curr.right!= null){
            q.add(new pair(curr.right, currHD+1));
        }
    }
     for (int val : m.values()) {
            System.out.print(val + " ");

}
