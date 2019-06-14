package homework_5.design.patterns.observer;

public interface Subject {
  
  public void attach(Observer observer);
  
  public void detach(Observer observer);
  
  public void notifyObservers();
  
}
