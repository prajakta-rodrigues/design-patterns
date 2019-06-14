package homework_5.design.patterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Class BitVector.
 */
public class BitVector implements IBitVector {
  
  private List<Integer> setOfNumbers;
  
  int size;

  /**
   * Instantiates a new bit vector.
   */
  public BitVector() {
    this.setOfNumbers = new ArrayList<>();
    this.size = 0;
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.iterator.IBitVector#get(int)
   */
  public boolean get(int i) {
    int listPosition = i / 32;
    int position = i % 32;

    if (listPosition > (this.setOfNumbers.size() - 1))
      return false;

    StringBuilder binaryNumber = new StringBuilder(Integer.toBinaryString(this.setOfNumbers.get(listPosition)));
    if (position < binaryNumber.length()) {
      return binaryNumber.reverse().charAt(position) == '1';
    }
    return false;


  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.iterator.IBitVector#set(int)
   */
  public void set(int i) {
    if(i < 0) {
      throw new IllegalArgumentException("Positive argument is required");
    }
    
    int listPosition = i / 32;
    int position = i % 32;


    if (listPosition > this.setOfNumbers.size()- 1 || listPosition == 0) {

      StringBuilder binaryNumber = new StringBuilder();
      for (int k = 0; k < 32; k++) {
        binaryNumber.append(0);
      }
      for (int j = this.setOfNumbers.size(); j <= listPosition; j++) {
        this.setOfNumbers.add(0);
      }
    }
    StringBuilder binaryNumber =
        new StringBuilder(convertToBinaryRep(this.setOfNumbers.get(listPosition)));
    if (binaryNumber.toString().charAt(31 - position) != '1') {
      binaryNumber.setCharAt(31 - position , '1');
      this.size++;
    }
    if(position % 31 == 0 && position != 0) {
      this.setOfNumbers.remove(listPosition);
      this.setOfNumbers.add(listPosition, Integer.parseInt("-" + binaryNumber.toString(), 2));
    }
    else {
      this.setOfNumbers.remove(listPosition);
      this.setOfNumbers.add(listPosition, Integer.parseInt(binaryNumber.toString(), 2));
    }
  }

  /**
   * Convert to binary representation of number.
   *
   * @param input the input
   * @return the string representation of binary number
   */
  private String convertToBinaryRep(Integer input) {
    char []binary = new char[32];


    char[] inputToBinary = Integer.toBinaryString(input).toCharArray();
    int j = inputToBinary.length - 1;
    for (int i = 31; i >= 0; i--) {
      if (j < 0) {
        binary[i] = '0';
      } else {
        binary[i] = inputToBinary[j--];
      }
    }

    return String.valueOf(binary);
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.iterator.IBitVector#clear(int)
   */
  public void clear(int i) {
    if(i < 0) {
      throw new IllegalArgumentException("Positive argument is required");
    }
    int listPosition = i / 32;
    int position = i % 32;

    if (listPosition > this.setOfNumbers.size() - 1) {
      return;
    }

    StringBuilder binaryNumber =
        new StringBuilder(convertToBinaryRep(this.setOfNumbers.get(listPosition)));
    if (binaryNumber.charAt(31 - position) == '1') {
      binaryNumber.setCharAt(31 - position, '0');
      this.setOfNumbers.remove(listPosition);
      this.setOfNumbers.add(listPosition, Integer.parseInt(binaryNumber.toString()));
      this.size--;
    }
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.iterator.IBitVector#copy(homework_5.design.patterns.iterator.IBitVector)
   */
  public void copy(IBitVector b) {

    if (null == b) {
      throw new IllegalArgumentException("Argument cannot be null");
    }
    Iterator<Integer> iterator = b.iterator();
    while (iterator.hasAnotherElement()) {
      this.set(iterator.nextElement());
    }
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.iterator.IBitVector#size()
   */
  public int size() {
    return this.size;
  }

  /* (non-Javadoc)
   * @see homework_5.design.patterns.iterator.IBitVector#iterator()
   */
  public Iterator<Integer> iterator() {
    return new BitVectorIterator(this);
  }

  /**
   * The Class BitVectorIterator.
   */
  private class BitVectorIterator implements Iterator<Integer> {
    
    /** The set of numbers. */
    List<Integer> setOfNumbers;
    
    /** The position. */
    int position = 31;
    
    /** The list position. */
    int listPosition = 0;

    /**
     * Instantiates a new bit vector iterator.
     *
     * @param bitVector the bit vector
     */
    public BitVectorIterator(BitVector bitVector) {
      this.setOfNumbers = bitVector.setOfNumbers;
    }

    /* (non-Javadoc)
     * @see homework_5.design.patterns.iterator.Iterator#hasAnotherElement()
     */
    public boolean hasAnotherElement() {
      int tempPosition = this.position;
      int tempListPosition = this.listPosition;
      StringBuilder currentNumber;
      for (int i = tempListPosition; i < this.setOfNumbers.size(); i++) {
        currentNumber = new StringBuilder(convertToBinaryRep(this.setOfNumbers.get(i)));
        for (int j = tempPosition; j >= 0; j--) {
          if (currentNumber.charAt(j) == '1') {
            return true;
          }
        }
        tempPosition = 31;
      }
      return false;
    }


    /* (non-Javadoc)
     * @see homework_5.design.patterns.iterator.Iterator#nextElement()
     */
    public Integer nextElement() {
      StringBuilder currentNumber;
      while (this.listPosition < this.setOfNumbers.size()) {
        currentNumber = new StringBuilder(convertToBinaryRep(this.setOfNumbers.get(this.listPosition)));
        while (this.position > 0) {
          if (currentNumber.charAt(this.position) == '1') {
            return (this.listPosition * 32) + (31 - this.position--);
          }
          this.position--;
        }
        this.position = 31;
        this.listPosition++;
      }
      throw new NoSuchElementException("No element found");
    }


  }



}
