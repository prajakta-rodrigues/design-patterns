package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import homework_5.design.patterns.iterator.BitVector;
import homework_5.design.patterns.iterator.IBitVector;

/**
 * The Class BitVectorTest tests methods provided by BitVector class.
 */
public class BitVectorTest {

  IBitVector bitVector;
  
  @Test
  public void testGetFromUnSetVector() {
    bitVector = new BitVector();
    assertEquals(false , bitVector.get(1));
  }

  @Test
  public void testGetFromSetPositionVector() {
    bitVector = new BitVector();
    bitVector.set(12);
    assertEquals(true , bitVector.get(12));
  }

  @Test
  public void testGetFromFirstPositionVector() {
    bitVector = new BitVector();
    bitVector.set(0);
    assertEquals(true , bitVector.get(0));
  }

  @Test
  public void testSetAndGetFromLargerThanThirtyTwoPositionElementVector() {
    bitVector = new BitVector();
    bitVector.set(33);
    assertEquals(true , bitVector.get(33));
  }
 
  @Test
  public void testSetAndGetFromMaxIntPositionElementVector() {
    bitVector = new BitVector();
    bitVector.set(Integer.MAX_VALUE);
    assertEquals(true , bitVector.get(Integer.MAX_VALUE));
  }

  @Test
  public void testSetAndGetFromSlightlyLesserLargerMaxIntPositionElementVector() {
    bitVector = new BitVector();
    bitVector.set(Integer.MAX_VALUE-1);
    assertEquals(true , bitVector.get(Integer.MAX_VALUE-1));
  }

  @Test
  public void testSetAndGetFromMidRangePositionElementVector() {
    bitVector = new BitVector();
    bitVector.set(Integer.MAX_VALUE/4);
    assertEquals(true , bitVector.get(Integer.MAX_VALUE/4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetAndGetFromNegativePositionElementVector() {
    bitVector = new BitVector();
    bitVector.set(-1);
  }

  @Test
  public void testSetDuplicateElement() {
    bitVector = new BitVector();
    bitVector.set(1);
    bitVector.set(1);
    assertEquals(1 , bitVector.size());
    
  }

  @Test
  public void testGetAndSetOne() {
    bitVector = new BitVector();
    bitVector.set(1);
    assertEquals(true , bitVector.get(1));
  }



  @Test
  public void testClearNotExisting() {
    bitVector = new BitVector();
    bitVector.set(2);
    bitVector.clear(1);
    assertEquals(1 , bitVector.size());

  }

  @Test
  public void testClearZero() {
    bitVector = new BitVector();
    bitVector.set(0);
    bitVector.clear(0);
    assertEquals(false , bitVector.get(0));
  }

  @Test
  public void testClearOne() {
    bitVector = new BitVector();
    bitVector.set(1);
    bitVector.clear(1);
    assertEquals(false , bitVector.get(1));
  }

  @Test
  public void testClearMaxIntegerValue() {
    bitVector = new BitVector();
    bitVector.set(Integer.MAX_VALUE);
    bitVector.clear(Integer.MAX_VALUE);
    assertEquals(false , bitVector.get(Integer.MAX_VALUE));
  }

  @Test
  public void testClearSlightlyLesserThanMaxIntegerValue() {
    bitVector = new BitVector();
    bitVector.set(Integer.MAX_VALUE-1);
    bitVector.clear(Integer.MAX_VALUE-1);
    assertEquals(false , bitVector.get(Integer.MAX_VALUE-1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testClearNegativeValue() {
    bitVector = new BitVector();
    bitVector.clear(-1);
  }

  @Test
  public void testClearMidRangeValue() {
    bitVector = new BitVector();
    bitVector.set(Integer.MAX_VALUE/2);
    bitVector.clear(Integer.MAX_VALUE/2);
    assertEquals(false , bitVector.get(Integer.MAX_VALUE/2));
  }

  @Test
  public void testCopySameVector() {
    bitVector = new BitVector();
    bitVector.set(32);
    bitVector.set(3);
    IBitVector bitVectorCopy = new BitVector();
    bitVectorCopy.set(32);
    bitVectorCopy.set(3);
    bitVector.copy(bitVectorCopy);
    assertEquals(2, bitVector.size());
  }

  @Test
  public void testCopyEmpty() {
    bitVector = new BitVector();
    bitVector.set(32);
    bitVector.set(3);
    IBitVector bitVectorCopy = new BitVector();
    bitVector.copy(bitVectorCopy);
    assertEquals(2, bitVector.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCopyNullVector() {
    bitVector = new BitVector();
    bitVector.set(32);
    bitVector.set(3);
    bitVector.copy(null);
  }

  @Test
  public void testCopyAllUnSetBitVector() {
    bitVector = new BitVector();
    bitVector.set(33);
    bitVector.set(2);
    IBitVector bitVectorCopy = new BitVector();
    bitVectorCopy.set(32);
    bitVectorCopy.set(3);
    bitVectorCopy.set(4);    
    bitVector.copy(bitVectorCopy);
    assertEquals(5, bitVector.size());
  }

  @Test
  public void testCopySomeUnsetBitVector() {
    bitVector = new BitVector();
    bitVector.set(33);
    bitVector.set(2);
    IBitVector bitVectorCopy = new BitVector();
    bitVectorCopy.set(33);
    bitVectorCopy.set(3);
    bitVector.copy(bitVectorCopy);
    assertEquals(3, bitVector.size());
  }

  @Test
  public void testEmptyVectorSize() {
    bitVector = new BitVector();
    assertEquals(0, bitVector.size());

  }

  @Test
  public void testOneElementSize() {
    bitVector = new BitVector();
    bitVector.set(2);
    assertEquals(1, bitVector.size());
  }

  @Test
  public void testMultipleElementsSize() {
    bitVector = new BitVector();
    bitVector.set(2);
    bitVector.set(3);
    bitVector.set(33);
    bitVector.set(32);
    assertEquals(4, bitVector.size());
  }


}
