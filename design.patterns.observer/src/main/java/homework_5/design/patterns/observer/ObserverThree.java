package homework_5.design.patterns.observer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ObserverThree provides definition for methods of Subject.
 */
public class ObserverThree implements Observer {
  private static final Logger LOGGER = Logger.getLogger(ObserverThree.class.getName());

  private ConcreteSubject subject;
  
  private Appendable out;
  
  /**
   * Instantiates a new observer three.
   *
   * @param concreteSubject the concrete subject
   * @param appendable the appendable
   */
  public ObserverThree(ConcreteSubject concreteSubject, Appendable appendable) {
    this.subject = concreteSubject;
    this.out = appendable;
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.observer.Observer#update()
   */
  public void update() {
    StringBuilder changedState = new StringBuilder(this.subject.getState());
    try {
      this.out.append(changedState.reverse().toString());
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE , "Unable to output state" + e.toString());
    }
  }
}
