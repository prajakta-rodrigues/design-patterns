package homework_5.design.patterns.adapter;

public interface Queue<T> {

  /**
   * add an element to the head of the queue
   * @param t
   * @return
   */
  boolean add(T t);
  
  /**
   * remove an element from the end of the queue. Returns null if queue is empty
   * @return
   */
  T remove();
  
  /**
   * returns the head of the queue. Returns null if queue is empty
   * @return
   */
  T peek();
  
}
