package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import homework_5.design.patterns.observer.ConcreteSubject;
import homework_5.design.patterns.observer.Observer;
import homework_5.design.patterns.observer.ObserverThree;

/**
 * The Class ObserverThreeTest.
 */
public class ObserverThreeTest {
  
  private Observer observerThree;
  
  private ConcreteSubject subject;

  /**
   * Test update changed notify once.
   */
  @Test
  public void testUpdateChangedNotifyOnce() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerThree = new ObserverThree(subject, out);
    subject.attach(observerThree);
    subject.setState("hi");
    subject.notifyObservers();
    assertEquals("ih", out.toString());
  }

  /**
   * Test update no notify.
   */
  @Test
  public void testUpdateNoNotify() {
    subject = new ConcreteSubject();
    StringBuffer out = new StringBuffer();
    observerThree = new ObserverThree(subject, out);
    subject.attach(observerThree);
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
    observerThree = new ObserverThree(subject, out);
    subject.attach(observerThree);
    subject.setState("hi");
    subject.notifyObservers();
    subject.setState("hi are you her");
    subject.notifyObservers();
    subject.setState("This is unit testing");
    subject.notifyObservers();
    assertEquals("ihreh uoy era ihgnitset tinu si sihT",out.toString());
  }

}
