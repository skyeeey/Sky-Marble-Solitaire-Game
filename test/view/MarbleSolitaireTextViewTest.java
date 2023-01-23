package view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Represents the test class for View.
 */
public class MarbleSolitaireTextViewTest {

  EnglishSolitaireModel modelState;
  EnglishSolitaireModel armFive;

  @Before
  public void init() {
    modelState = new EnglishSolitaireModel();
    armFive = new EnglishSolitaireModel(5);
  }

  @Test
  public void testToString() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(modelState);

    assertEquals("    O O O\n"
            +
            "    O O O\n"
            +
            "O O O O O O O\n"
            +
            "O O O _ O O O\n"
            +
            "O O O O O O O\n"
            +
            "    O O O\n"
            +
            "    O O O", board.toString());
  }

  @Test
  public void testToStringArm5() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(armFive);
    assertEquals("        O O O O O\n"
            +
            "        O O O O O\n"
            +
            "        O O O O O\n"
            +
            "        O O O O O\n"
            +
            "O O O O O O O O O O O O O\n"
            +
            "O O O O O O O O O O O O O\n"
            +
            "O O O O O O _ O O O O O O\n"
            +
            "O O O O O O O O O O O O O\n"
            +
            "O O O O O O O O O O O O O\n"
            +
            "        O O O O O\n"
            +
            "        O O O O O\n"
            +
            "        O O O O O\n"
            +
            "        O O O O O", board.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModelState modelState1 = new EnglishSolitaireModel(3);
    Appendable one = new StringBuilder();
    MarbleSolitaireTextView textView1 = new MarbleSolitaireTextView(modelState1, one);
    textView1.renderBoard();
    assertEquals("    O O O\n"
            +
            "    O O O\n"
            +
            "O O O O O O O\n"
            +
            "O O O _ O O O\n"
            +
            "O O O O O O O\n"
            +
            "    O O O\n"
            +
            "    O O O", one.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModelState modelState1 = new EnglishSolitaireModel(3);
    Appendable one = new StringBuilder();
    MarbleSolitaireTextView textView1 = new MarbleSolitaireTextView(modelState1, one);
    textView1.renderMessage("hi");
    assertEquals("hi", one.toString());
  }


  @Test
  public void testToStringWin() {
    MarbleSolitaireTextView const2 = new MarbleSolitaireTextView(modelState);

    modelState.move(3, 5, 3, 3);
    modelState.move(1, 4, 3, 4);
    modelState.move(2, 6, 2, 4);
    modelState.move(4, 6, 2, 6);
    modelState.move(2, 3, 2, 5);
    modelState.move(2, 6, 2, 4);
    modelState.move(2, 1, 2, 3);
    modelState.move(0, 2, 2, 2);
    modelState.move(0, 4, 0, 2);
    modelState.move(3, 2, 1, 2);
    modelState.move(0, 2, 2, 2);
    modelState.move(5, 2, 3, 2);
    modelState.move(4, 0, 4, 2);
    modelState.move(2, 0, 4, 0);
    modelState.move(4, 3, 4, 1);
    modelState.move(4, 5, 4, 3);
    modelState.move(6, 4, 4, 4);
    modelState.move(6, 2, 6, 4);
    modelState.move(3, 4, 5, 4);
    modelState.move(6, 4, 4, 4);
    modelState.move(4, 0, 4, 2);
    modelState.move(3, 2, 1, 2);
    modelState.move(1, 2, 1, 4);
    modelState.move(1, 4, 3, 4);
    modelState.move(3, 4, 5, 4);
    modelState.move(5, 4, 5, 2);
    modelState.move(5, 2, 3, 2);
    modelState.move(3, 3, 1, 3);
    modelState.move(3, 1, 3, 3);
    modelState.move(4, 3, 2, 3);
    modelState.move(1, 3, 3, 3);

    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _", const2.toString());
  }
}