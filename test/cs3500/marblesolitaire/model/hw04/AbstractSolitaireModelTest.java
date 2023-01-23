package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AbstractSolitaireModelTest {

  /**
   * Testing Invalid moving cases while testing constructors.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalid() {
    AbstractSolitaireModel emptyEnglish = new EnglishSolitaireModel();
    AbstractSolitaireModel emptyEuropean = new EuropeanSolitaireModel();

    //test if on the board, the space going to is empty, and the thing you call on is a marble
    AbstractSolitaireModel const2 = new EnglishSolitaireModel(3, 3);
    AbstractSolitaireModel const3 = new EnglishSolitaireModel(3);
    AbstractSolitaireModel const4 = new EnglishSolitaireModel(3, 3, 3);
    AbstractSolitaireModel const5 = new EuropeanSolitaireModel(3, 3);
    AbstractSolitaireModel const6 = new EuropeanSolitaireModel(3);
    AbstractSolitaireModel const7 = new EuropeanSolitaireModel(3, 3, 3);
    //this.const [1][2] = MarbleSolitaireModelState.SlotState.Empty;

    //invalid
    emptyEnglish.move(0, 0, 1, 0);
    const2.move(-1, 2, 1, 2);
    const2.move(1, -1, 1, 1);
    const2.move(0, 2, -2, 2);
    const2.move(0, 0, 0, -2);

    emptyEuropean.move(0, 0, 1, 0);
    const5.move(-1, 2, 1, 2);
    const5.move(1, -1, 1, 1);
    const5.move(0, 2, -2, 2);
    const5.move(0, 0, 0, -2);

    //empty
    const2.move(1, 1, 1, 3);
    const2.move(5, 1, 5, 3);
    const2.move(4, 0, 5, 0);
    const2.move(5, 0, 4, 0);
    const2.move(5, 0, 3, 0);
    const2.move(3, 3, 4, 0);

    const5.move(1, 1, 1, 3);
    const5.move(5, 1, 5, 3);
    const5.move(4, 0, 5, 0);
    const5.move(5, 0, 4, 0);
    const5.move(5, 0, 3, 0);
    const5.move(3, 3, 4, 0);

    //invalid
    const3.move(-1, 2, 1, 2);
    const3.move(1, -1, 1, 1);
    const3.move(0, 2, -2, 2);
    const3.move(0, 0, 0, -2);

    const6.move(-1, 2, 1, 2);
    const6.move(1, -1, 1, 1);
    const6.move(0, 2, -2, 2);
    const6.move(0, 0, 0, -2);

    //empty
    const3.move(1, 1, 1, 3);
    const3.move(5, 1, 5, 3);
    const3.move(4, 0, 5, 0);
    const3.move(5, 0, 3, 0);
    const3.move(3, 3, 4, 0);

    const6.move(1, 1, 1, 3);
    const6.move(5, 1, 5, 3);
    const6.move(4, 0, 5, 0);
    const6.move(5, 0, 3, 0);
    const6.move(3, 3, 4, 0);

    //invalid
    const4.move(-1, 2, 1, 2);
    const4.move(1, -1, 1, 1);
    const4.move(0, 2, -2, 2);
    const4.move(0, 0, 0, -2);

    const7.move(-1, 2, 1, 2);
    const7.move(1, -1, 1, 1);
    const7.move(0, 2, -2, 2);
    const7.move(0, 0, 0, -2);

    //empty
    const4.move(1, 1, 1, 3);
    const4.move(5, 1, 5, 3);
    const4.move(4, 0, 5, 0);
    const4.move(5, 0, 3, 0);
    const4.move(3, 3, 4, 0);

    const7.move(1, 1, 1, 3);
    const7.move(5, 1, 5, 3);
    const7.move(4, 0, 5, 0);
    const7.move(5, 0, 3, 0);
    const7.move(3, 3, 4, 0);

    //test the chess only moves 2-spaces
    const2.move(2, 0, 6, 0);
    const2.move(2, 0, 2, 1);

    const5.move(2, 0, 6, 0);
    const5.move(2, 0, 2, 1);

    //not horizontal or vertical
    const2.move(2, 0, 4, 2);
    const3.move(2, 0, 6, 0);
    const3.move(2, 0, 2, 1);

    const5.move(2, 0, 4, 2);
    const6.move(2, 0, 6, 0);
    const6.move(2, 0, 2, 1);

    //not horizontal or vertical
    const3.move(2, 0, 4, 2);
    const4.move(2, 0, 6, 0);
    const4.move(2, 0, 2, 1);

    const6.move(2, 0, 4, 2);
    const6.move(2, 0, 6, 0);
    const7.move(2, 0, 2, 1);

    //not horizontal or vertical
    const4.move(2, 0, 4, 2);
    const7.move(2, 0, 4, 2);
  }

  @Test
  public void testIsGameOver() {
    //test if the user win
    AbstractSolitaireModel const2 = new EnglishSolitaireModel();
    AbstractSolitaireModel const3 = new EuropeanSolitaireModel();

    // win method from this website:
    // https://www.wikihow.com/Win-the-Peg-Solitaire-Game-(English-Board)
    // this method was concluded by another student Cole, I think we need a credit.
    const2.move(3, 5, 3, 3);
    const2.move(1, 4, 3, 4);
    const2.move(2, 6, 2, 4);
    const2.move(4, 6, 2, 6);
    const2.move(2, 3, 2, 5);
    const2.move(2, 6, 2, 4);
    const2.move(2, 1, 2, 3);
    const2.move(0, 2, 2, 2);
    const2.move(0, 4, 0, 2);
    const2.move(3, 2, 1, 2);
    const2.move(0, 2, 2, 2);
    const2.move(5, 2, 3, 2);
    const2.move(4, 0, 4, 2);
    const2.move(2, 0, 4, 0);
    const2.move(4, 3, 4, 1);
    const2.move(4, 5, 4, 3);
    const2.move(6, 4, 4, 4);
    const2.move(6, 2, 6, 4);
    const2.move(3, 4, 5, 4);
    const2.move(6, 4, 4, 4);
    const2.move(4, 0, 4, 2);
    const2.move(3, 2, 1, 2);
    const2.move(1, 2, 1, 4);
    const2.move(1, 4, 3, 4);
    const2.move(3, 4, 5, 4);
    const2.move(5, 4, 5, 2);
    const2.move(5, 2, 3, 2);
    const2.move(3, 3, 1, 3);
    const2.move(3, 1, 3, 3);
    const2.move(4, 3, 2, 3);
    const2.move(1, 3, 3, 3);

    const3.move(3, 5, 3, 3);
    const3.move(1, 4, 3, 4);
    const3.move(2, 6, 2, 4);
    const3.move(4, 6, 2, 6);
    const3.move(2, 3, 2, 5);
    const3.move(2, 6, 2, 4);
    const3.move(2, 1, 2, 3);
    const3.move(0, 2, 2, 2);
    const3.move(0, 4, 0, 2);
    const3.move(3, 2, 1, 2);
    const3.move(0, 2, 2, 2);
    const3.move(5, 2, 3, 2);
    const3.move(4, 0, 4, 2);
    const3.move(2, 0, 4, 0);
    const3.move(4, 3, 4, 1);
    const3.move(4, 5, 4, 3);
    const3.move(6, 4, 4, 4);
    const3.move(6, 2, 6, 4);
    const3.move(3, 4, 5, 4);
    const3.move(6, 4, 4, 4);
    const3.move(4, 0, 4, 2);
    const3.move(3, 2, 1, 2);
    const3.move(1, 2, 1, 4);
    const3.move(1, 4, 3, 4);
    const3.move(3, 4, 5, 4);
    const3.move(5, 4, 5, 2);
    const3.move(5, 2, 3, 2);
    const3.move(3, 3, 1, 3);
    const3.move(3, 1, 3, 3);
    const3.move(4, 3, 2, 3);
    const3.move(1, 3, 3, 3);

    assertTrue(const2.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    AbstractSolitaireModel const2 = new EnglishSolitaireModel(3);
    AbstractSolitaireModel const3 = new EnglishSolitaireModel(5);
    AbstractSolitaireModel const4 = new EnglishSolitaireModel(7);

    AbstractSolitaireModel const5 = new EuropeanSolitaireModel(3);
    AbstractSolitaireModel const6 = new EuropeanSolitaireModel(5);
    AbstractSolitaireModel const7 = new EuropeanSolitaireModel(7);

    assertEquals(7, const2.getBoardSize());
    assertEquals(13, const3.getBoardSize());
    assertEquals(19, const4.getBoardSize());

    assertEquals(7, const5.getBoardSize());
    assertEquals(13, const6.getBoardSize());
    assertEquals(19, const7.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    AbstractSolitaireModel const2 = new EnglishSolitaireModel(3, 3);
    AbstractSolitaireModel const3 = new EnglishSolitaireModel(5);
    AbstractSolitaireModel const4 = new EnglishSolitaireModel(7);
    AbstractSolitaireModel const5 = new EuropeanSolitaireModel(3, 3);
    AbstractSolitaireModel const6 = new EuropeanSolitaireModel(5);
    AbstractSolitaireModel const7 = new EuropeanSolitaireModel(7);

    assertSame(const2.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertSame(const3.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertSame(const3.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertSame(const4.getSlotAt(8, 8), MarbleSolitaireModelState.SlotState.Marble);
    assertSame(const4.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);

    assertSame(const5.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertSame(const6.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertSame(const6.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertSame(const7.getSlotAt(8, 8), MarbleSolitaireModelState.SlotState.Marble);
    assertSame(const7.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
  }

  @Test
  public void testGetScore() {
    AbstractSolitaireModel const2 = new EnglishSolitaireModel(3, 3);
    AbstractSolitaireModel const3 = new EuropeanSolitaireModel(3, 3);
    assertEquals(32, const2.getScore());
    assertEquals(32, const3.getScore());
  }
}


