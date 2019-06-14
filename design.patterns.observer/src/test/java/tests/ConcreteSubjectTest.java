package tests;

import org.junit.Test;
import homework_5.design.patterns.observer.ConcreteSubject;
import homework_5.design.patterns.observer.Observer;
import homework_5.design.patterns.observer.ObserverOne;
import homework_5.design.patterns.observer.Subject;

// TODO: Auto-generated Javadoc
/**
 * The Class ConcreteSubjectTest.
 */
public class ConcreteSubjectTest {
  
  /** The subject. */
  Subject subject;
  
  /**
   * Test attach null observers.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAttachNullObservers() {
    subject = new ConcreteSubject();
    subject.attach(null);
  }

  
  /**
   * Test set null state.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetNullState() {
    subject = new ConcreteSubject();
    ((ConcreteSubject)subject).setState(null);
  }
  
  /**
   * Detach null observers.
   */
  @Test(expected = IllegalArgumentException.class)
  public void detachNullObservers() {
    subject = new ConcreteSubject();
    subject.detach(null);
  }
  
  /**
   * Test attach duplicate observer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAttachDuplicateObserver() {
    subject = new ConcreteSubject();
    Observer observer = new ObserverOne((ConcreteSubject)subject , new StringBuffer());
    subject.attach(observer);
    subject.attach(observer);
  }
  
  /**
   * Test detach non existing observer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDetachNonExistingObserver() {
    subject = new ConcreteSubject();
    Observer observer = new ObserverOne((ConcreteSubject)subject , new StringBuffer());
    subject.detach(observer);
  }
  
  /**
   * Test detach existing observer.
   */
  @Test
  public void testDetachExistingObserver() {
    subject = new ConcreteSubject();
    Observer observer = new ObserverOne((ConcreteSubject)subject , new StringBuffer());
    subject.attach(observer);
    subject.detach(observer);
    assert true;
  }
  
}
