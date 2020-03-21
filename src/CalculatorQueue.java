import java.util.Queue;
import java.util.LinkedList;

class CalculatorQueue {
   private LinkedList<Integer> q;

    public CalculatorQueue(){
        q = new LinkedList<Integer>();
    }

   public void MC(){
       while( q.size() > 0 ) {
           int temp = q.remove();
       };
   }

   public void MR(int ans){
        q.add(ans);
   }
}