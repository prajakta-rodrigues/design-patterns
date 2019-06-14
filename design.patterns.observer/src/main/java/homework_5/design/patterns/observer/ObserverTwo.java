package homework_5.design.patterns.observer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ObserverTwo provides definition for methods of Subject.
 */
public class ObserverTwo implements Observer {
  private static final Logger LOGGER = Logger.getLogger(ObserverTwo.class.getName());

  private ConcreteSubject subject;
  
  private Appendable out;
  
  /**
   * Instantiates a new observer two.
   *
   * @param concreteSubject the concrete subject
   * @param appendable the appendable
   */
  public ObserverTwo(ConcreteSubject concreteSubject, Appendable appendable) {
    this.subject = concreteSubject;
    this.out = appendable;
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.observer.Observer#update()
   */
  public void update(){
    String changedState = this.subject.getState();
    String encodedState = getStringAsHexValues(changedState);
    try {
      this.out.append(encodedState);
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE , "Unable to output state" + e.toString());
    }
  }


  /**
   * Gets the string as hex values.
   *
   * @param changedState the changed state
   * @return the string as hex values
   */
  private String getStringAsHexValues(String changedState) {
    StringBuilder output = new StringBuilder();
    for(char c: changedState.toCharArray()) {
      output.append(Integer.toHexString((int)c) + " ");
    }
    output.deleteCharAt(output.length() - 1);
    return output.toString();
  }
}
