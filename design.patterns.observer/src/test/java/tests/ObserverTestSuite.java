package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import homework_5.design.patterns.observer.ConcreteSubject;
import homework_5.design.patterns.observer.ObserverOne;
import homework_5.design.patterns.observer.ObserverThree;
import homework_5.design.patterns.observer.ObserverTwo;

@RunWith(Suite.class)

@Suite.SuiteClasses({
  ObserverOneTest.class,
  ObserverTwoTest.class,
  ObserverThreeTest.class,
  ConcreteSubjectTest.class
})
public class ObserverTestSuite {

}
