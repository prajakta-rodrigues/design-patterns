package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import homework_5.design.patterns.observer.ConcreteSubject;
import homework_5.design.patterns.observer.Observer;
import homework_5.design.patterns.observer.ObserverOne;


/**
 * The Class ObserverOneTest.
 */
public class ObserverOneTest {

  private Observer observerOne;
  
  private ConcreteSubject subject;
  
  /**
   * Test update changed notify once.
   */
  @Test
  public void testUpdateChangedNotifyOnce() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerOne = new ObserverOne(subject, out);
    subject.attach(observerOne);
    subject.setState("hi");
    subject.notifyObservers();
    assertEquals("104 105", out.toString());
  }

  /**
   * Test update no notify.
   */
  @Test
  public void testUpdateNoNotify() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerOne = new ObserverOne(subject, out);
    subject.attach(observerOne);
    subject.setState("hi");
    assertEquals("", out.toString());
  }

  /**
   * Test update changed notify more than once.
   */
  @Test
  public void testUpdateChangedNotifyMoreThanOnce() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerOne = new ObserverOne(subject, out);
    subject.attach(observerOne);
    subject.setState("hi");
    subject.notifyObservers();
    subject.setState("hi are you her");
    subject.notifyObservers();
    subject.setState("This is unit testing");
    subject.notifyObservers();
    assertEquals(
        "104 105104 105 32 97 114 101 32 121 111 117 32 104 101 "
            + "11484 104 105 115 32 105 115 32 117 110 105 116 32 116 101 115 " + "116 105 110 103",
        out.toString());
  }


}
