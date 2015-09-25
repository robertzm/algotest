/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        int cur = 0;
        if(node == null){
            return null;
        }else{
            nodes.add(node);
        }
        while(cur < nodes.size()){
            UndirectedGraphNode tmp = nodes.get(cur);
            for(UndirectedGraphNode n : tmp.neighbors){
                if(!nodes.contains(n)){
                    nodes.add(n);
                }
            }
            cur++;
        }
        List<UndirectedGraphNode> newNodes = new ArrayList<>();
        for(UndirectedGraphNode n : nodes){
            newNodes.add(new UndirectedGraphNode(n.label));
        }
        for(int i = 0; i < nodes.size(); i ++){
            UndirectedGraphNode tmp = newNodes.get(i);
            for(UndirectedGraphNode n : nodes.get(i).neighbors){
                tmp.neighbors.add(newNodes.get(nodes.indexOf(n)));
            }
        }
        return newNodes.get(0);
        
    }
}