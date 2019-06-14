package tests;

import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;
import org.junit.Test;
import homework_5.design.patterns.adapter.Queue;
import homework_5.design.patterns.adapter.QueueAdapter;

/**
 * The Class QueueAdapterTest has tests for class QueueAdapter.
 */
public class QueueAdapterTest {
  
  Queue<Integer> queue;
  
  /**
   * Test add and peek one element queue.
   */
  @Test
  public void testAddAndPeekOneElementQueue() {
    queue = new QueueAdapter<>();
    queue.add(12);
    assertEquals(Integer.valueOf(12), queue.peek());
  }

  
  /**
   * Test adding same values.
   */
  @Test
  public void testSameValues() {
    queue = new QueueAdapter<>();
    queue.add(12);
    queue.add(12);
    assertEquals(Integer.valueOf(12), queue.peek());
    assertEquals(Integer.valueOf(12), queue.remove());
    assertEquals(Integer.valueOf(12), queue.remove());
  }
  
  /**
   * Test add null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNull() {
    queue = new QueueAdapter<>();
    queue.add(null);
  }
  
  
  /**
   * Test add higher number of elements.
   */
  @Test
  public void testAddHigherNumberOfElements() {
    queue = new QueueAdapter<>();
    for(int i = 0 ; i < 9999 ; i++ ) {
      queue.add(i);
    }
    assertEquals(Integer.valueOf(0), queue.peek());
  }
  
  
  /**
   * Test remove from empty queue.
   */
  @Test(expected = NoSuchElementException.class)
  public void testRemoveFromEmpty() {
    queue = new QueueAdapter<>();
    queue.remove();
  }
  
  /**
   * Test remove from one element.
   */
  @Test
  public void testRemoveFromOneElement() {
    queue = new QueueAdapter<>();
    queue.add(12);
    assertEquals(Integer.valueOf(12) , queue.remove());
  }
  
  
  /**
   * Test remove from more than one element.
   */
  @Test
  public void testRemoveFromMoreThanOneElement() {
    queue = new QueueAdapter<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    assertEquals(Integer.valueOf(1) , queue.remove());

  }
  
  
  /**
   * Test remove from higher number of elements.
   */
  @Test
  public void testRemoveFromHigherNumberOfElements() {
    queue = new QueueAdapter<>();
    for(int i = 0 ; i < 9999 ; i++ ) {
      queue.add(i);
    }
    assertEquals(Integer.valueOf(0), queue.remove());
  }
  
  /**
   * Test peek empty queue.
   */
  @Test
  public void testPeekEmptyQueue() {
    queue = new QueueAdapter<>();
    assertEquals(null, queue.peek());
  }
  
  
  /**
   * Test peek higher number of elements.
   */
  @Test
  public void testPeekHigherNumberOfElements() {
    queue = new QueueAdapter<>();
    for(int i = 0 ; i > -9999 ; i-- ) {
      queue.add(i); 
    }
    assertEquals(Integer.valueOf(0), queue.remove());
    assertEquals(Integer.valueOf(-1), queue.remove());
    assertEquals(Integer.valueOf(-2), queue.remove());
  }
  
  
  
  
  
}
