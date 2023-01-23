package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TriangleSolitaireModelTest extends AbstractSolitaireModelTest {

  @Override
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalid() {

    TriangleSolitaireModel emptyTriangle = new TriangleSolitaireModel();

    //test if on the board, the space going to is empty, and the thing you call on is a marble
    AbstractSolitaireModel const2 = new TriangleSolitaireModel(0, 0);
    AbstractSolitaireModel const3 = new TriangleSolitaireModel(5);
    AbstractSolitaireModel const4 = new TriangleSolitaireModel(5, 0, 0);

    //invalid
    emptyTriangle.move(0, 0, 1, 0);
    const2.move(-1, 2, 1, 2);
    const2.move(1, -1, 1, 1);
    const2.move(0, 2, -2, 2);
    const2.move(0, 0, 0, -2);

    //empty
    const2.move(1, 1, 1, 3);
    const2.move(5, 1, 5, 3);
    const2.move(4, 0, 5, 0);
    const2.move(5, 0, 4, 0);
    const2.move(5, 0, 3, 0);
    const2.move(3, 3, 4, 0);

    //invalid
    const3.move(-1, 2, 1, 2);
    const3.move(1, -1, 1, 1);
    const3.move(0, 2, -2, 2);
    const3.move(0, 0, 0, -2);

    //empty
    const3.move(1, 1, 1, 3);
    const3.move(5, 1, 5, 3);
    const3.move(4, 0, 5, 0);
    const3.move(5, 0, 3, 0);
    const3.move(3, 3, 4, 0);

    //invalid
    const4.move(-1, 2, 1, 2);
    const4.move(1, -1, 1, 1);
    const4.move(0, 2, -2, 2);
    const4.move(0, 0, 0, -2);

    //empty
    const4.move(1, 1, 1, 3);
    const4.move(5, 1, 5, 3);
    const4.move(4, 0, 5, 0);
    const4.move(5, 0, 3, 0);
    const4.move(3, 3, 4, 0);

    //test the chess only moves 2 or 4 spaces
    const2.move(2, 0, 5, 0);
    const2.move(2, 0, 2, 1);
    const2.move(2, 0, 4, 1);
    const2.move(2, 0, 5, 5);


  }

  @Test
  public void testMoveValid() {

    AbstractSolitaireModel const2 = new TriangleSolitaireModel(0, 0);
    AbstractSolitaireModel const3 = new TriangleSolitaireModel(5);
    AbstractSolitaireModel const4 = new TriangleSolitaireModel(5, 0, 0);

    // move diagonally
    const2.move(2, 0, 0, 0);

    const3.move(2, 0, 0, 0);

    const4.move(2, 0, 0, 0);
  }

  @Override
  @Test
  public void testIsGameOver() {
    AbstractSolitaireModel const2 = new TriangleSolitaireModel();

    const2.move(2, 0, 0, 0);
    const2.move(2, 2, 2, 0);
    const2.move(4, 3, 3, 2);
    const2.move(2, 0, 2, 2);
    const2.move(3, 0, 3, 2);
    const2.move(4, 1, 4, 3);
    const2.move(4, 3, 2, 1);
    const2.move(2, 2, 2, 0);
    const2.move(4, 4, 3, 3);
    const2.move(1, 1, 2, 2);
    assertEquals(true, const2.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    AbstractSolitaireModel const2 = new TriangleSolitaireModel(5);
    AbstractSolitaireModel const3 = new TriangleSolitaireModel(6);
    AbstractSolitaireModel const4 = new TriangleSolitaireModel(7);

    assertEquals(5, const2.getBoardSize());
    assertEquals(6, const3.getBoardSize());
    assertEquals(7, const4.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    AbstractSolitaireModel const2 = new TriangleSolitaireModel(5);
    AbstractSolitaireModel const3 = new TriangleSolitaireModel(6);
    AbstractSolitaireModel const4 = new TriangleSolitaireModel(7);

    assertTrue(const2.getSlotAt(0, 1)
            == MarbleSolitaireModelState.SlotState.Invalid);
    assertTrue(const2.getSlotAt(4, 4)
            == MarbleSolitaireModelState.SlotState.Marble);
    assertTrue(const3.getSlotAt(1, 2)
            == MarbleSolitaireModelState.SlotState.Invalid);
    assertTrue(const3.getSlotAt(5, 5)
            == MarbleSolitaireModelState.SlotState.Marble);
    assertTrue(const4.getSlotAt(2, 3)
            == MarbleSolitaireModelState.SlotState.Invalid);
    assertTrue(const4.getSlotAt(6, 6)
            == MarbleSolitaireModelState.SlotState.Marble);
  }


  @Test
  public void testGetScore() {
    AbstractSolitaireModel const2 = new TriangleSolitaireModel(3, 3);
    assertEquals(104, const2.getScore());
  }
}