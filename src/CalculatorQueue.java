import java.util.Queue;

class CalculatorQueue {
   private Queue<Integer> q;

    public CalculatorQueue(){
        q = new Queue<integer>();
    }

   public void MC(){
       while( !q.empty() ) q.remove();
   }

   public void MR(int ans){
        q.enqueue(ans);
   }
}