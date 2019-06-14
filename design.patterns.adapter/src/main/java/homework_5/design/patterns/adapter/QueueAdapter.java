package homework_5.design.patterns.adapter;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * The Class QueueAdapter adapts ArrayList.
 *
 * @param <T> the generic type
 */
public class QueueAdapter<T> implements Queue<T> {

  /** The list. */
  private ArrayList<T> list;

  /**
   * Instantiates a new queue adapter.
   */
  public QueueAdapter() {
    list = new ArrayList<>();
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.adapter.Queue#add(java.lang.Object)
   */
  public boolean add(T t) {
    if (t == null) {
      throw new IllegalArgumentException("Cannot add null to queue");
    }
    list.add(t);
    return true;
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.adapter.Queue#remove()
   */
  public T remove() {
    if (this.list.isEmpty()) {
      throw new NoSuchElementException("Queue empty");
    }
    T t = list.get(0);
    list.remove(0);
    return t;
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.adapter.Queue#peek()
   */
  public T peek() {
    if (this.list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

}
