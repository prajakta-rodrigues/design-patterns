package homework_5.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ConcreteSubject provides definition for methods of subject.
 */
public class ConcreteSubject implements Subject {

  private String state;

  private List<Observer> observers;



  /**
   * Instantiates a new concrete subject.
   */
  public ConcreteSubject() {
    this.state = "";
    this.observers = new ArrayList<>();
  }

  /**
   * Gets the state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets the state.
   *
   * @param state the new state
   */
  public void setState(String state) {
    if (state == null) {
      throw new IllegalArgumentException("State cannot be null");
    }
    this.state = state;
  }

  /*
   * (non-Javadoc)
   * 
   * @see homework_5.design.patterns.observer.Subject#attach(homework_5.design.patterns.observer.
   * Observer)
   */
  public void attach(Observer observer) {
    if (null == observer) {
      throw new IllegalArgumentException("Observer cannot be null");
    }
    if (this.observers.contains(observer)) {
      throw new IllegalArgumentException("Duplicate Observer");
    }
    this.observers.add(observer);
  }

  /*
   * (non-Javadoc)
   * 
   * @see homework_5.design.patterns.observer.Subject#detach(homework_5.design.patterns.observer.
   * Observer)
   */
  public void detach(Observer observer) {
    if (null == observer) {
      throw new IllegalArgumentException("Observer cannot be null");
    }
    if (this.observers.contains(observer)) {

      this.observers.remove(observer);
    } else {
      throw new IllegalArgumentException("Observer not present");
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see homework_5.design.patterns.observer.Subject#notifyObservers()
   */
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update();
    }

  }
}

