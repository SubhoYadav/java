import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
  static ArrayList<Character> findOrder(String[] words, int N, int K) {
    ArrayList<Character> order = new ArrayList<Character>();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<K; i++) {
      adj.add(new ArrayList<Integer>());
    }

    // create a directed graph using the order
    for (int i=0; i<N-1; i++) {
      String w1 = words[i];
      String w2 = words[i+1];

      int n = (w1.length() > w2.length()) ? w2.length() : w1.length();

      for(int j=0; j<n; j++) {
        if (w1.charAt(j) != w2.charAt(j)) {
          adj.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
          break;
        }
      }
    }

    // Toposort the above graph to find the alien order

    // find indegree
    int indegree[] = new int[K];
    for (int i=0; i<K; i++) {
      for (int adjNode : adj.get(i)) {
        indegree[adjNode]++;
      }
    }

    // push the node with indegree 0 into a queue
    Queue<Integer> q = new LinkedList<>();
    for (int i=0; i<K; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    // start disconnecting the nodes
    while(!q.isEmpty()) {
      int node = q.remove();
      order.add((char)(node + 97));

      for (int adjNode : adj.get(node)) {
        indegree[adjNode]--;
        if (indegree[adjNode] == 0) {
          q.add(adjNode);
        }
      }

    }
    return order;
  }
  public static void main(String[] args) {
    String words[] = {"baa", "abcd", "abca", "cab", "cad"};
    // N words and K starting alphabets
    int N = words.length, K = 4;

    ArrayList<Character> order = findOrder(words, N, K);
    System.out.println("Alien Order: " + order);

    // cases when the dictionary is wrong!
    /*
     * something like :
     * abcd
     * abc
     * shorter string comes after the longer string
     */
    
     /**
      * Something like cyclic dependency as
      * abc
      * bat
      * ade
      * The order indicates that a comes before b and also b comes before a which leads to a cycle
      */

      /**
       * In the above cases, the topo sort will not be possible and all the nodes will not be present in the topo sort
       */
  }
}
