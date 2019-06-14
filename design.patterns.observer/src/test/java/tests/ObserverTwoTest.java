package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import homework_5.design.patterns.observer.ConcreteSubject;
import homework_5.design.patterns.observer.Observer;
import homework_5.design.patterns.observer.ObserverTwo;

/**
 * The Class ObserverTwoTest.
 */
public class ObserverTwoTest {
  
  private Observer observerTwo;
  
  private ConcreteSubject subject;
  
  /**
   * Test update changed notify once.
   */
  @Test
  public void testUpdateChangedNotifyOnce() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerTwo = new ObserverTwo(subject, out);
    subject.attach(observerTwo);
    subject.setState("hi");
    subject.notifyObservers();
    assertEquals("68 69" , out.toString());
  }
  
  /**
   * Test update no notify.
   */
  @Test
  public void testUpdateNoNotify() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerTwo = new ObserverTwo(subject, out);
    subject.attach(observerTwo);
    subject.setState("hi");
    assertEquals("" , out.toString());
  }
  
  /**
   * Test update changed notify more than once.
   */
  @Test
  public void testUpdateChangedNotifyMoreThanOnce() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerTwo = new ObserverTwo(subject, out);
    subject.attach(observerTwo);
    subject.setState("hi");
    subject.notifyObservers();
    subject.setState("hi are you her");
    subject.notifyObservers();
    subject.setState("This is unit testing");
    subject.notifyObservers();
    assertEquals("68 6968 69 20 61 72 65 20 79 6f 75 20 68 65 7254 68 69 73 "
        + "20 69 73 20 75 6e 69 74 20 74 65 73 74 69 6e 67" , out.toString());
  }
  
  
  
}
