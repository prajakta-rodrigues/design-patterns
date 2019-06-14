# Design Patterns
This repository contains implementations of the following design patterns:
1. **Adapter Design pattern :** This implementation adapts a Queue based on the given interface Queue. 
2. **Iterator Design pattern :** A set of natural numbers can be represented compactly using an array of int values. The basic idea is to use the ith bit to indicate whether the number i is in the set. In Java, an int is represented
using 32 bits, so in this representation the set {0, 1, 4, 7, 31} can be represented by the binary number
10000000000000000000000010010011. For sets containing larger numbers, an array of ints can be used,
where the first element represents bits 0-31, the second represents bits 32-63, and so on given interfaces for Iterator and IBitVector.
3. **Observer Design pattern :** This implementation provides a way to create subjects and observers such that every change to the subject is notified to the observers who have subscribed to the subject


## Requirements:
JDK 1.8
Maven 3.6
Command Prompt/Any IDE

## Steps for running project:
1. Clone the project
2. Import each project as a Maven project
3. Build project using the command:
mvn clean install
4. Run tests using the command:
mvn tests
