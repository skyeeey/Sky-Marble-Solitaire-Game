package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MockModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test class for the Marble Solitaire Controller Impl.
 */
public class MarbleSolitaireControllerImplTest {

  MarbleSolitaireModel model = new EnglishSolitaireModel();
  Appendable appendable = new StringBuilder();
  MarbleSolitaireTextView textView = new MarbleSolitaireTextView(model, appendable);


  @Test
  public void testIOECompleteRenderBoard() {
    MarbleSolitaireTextView textView1 = new MarbleSolitaireTextView(model, new MockAppendable());
    assertThrows(IOException.class, () -> textView1.renderBoard());
  }

  @Test
  public void testIOECompleteRenderMessage() {
    MarbleSolitaireModelState model1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView textView1 = new MarbleSolitaireTextView(model1, new MockAppendable());
    assertThrows(IOException.class, () -> textView1.renderMessage("hulu"));
  }

  @Test
  public void testSmallQPlayGame() {
    Readable readable = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", appendable.toString());
  }

  @Test
  public void testQPlayGame() {
    Readable readable = new StringReader("2 4 4 4 Q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
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
            "    O O O\n"
            +
            "Score: 32\n"
            +
            "    O O O\n"
            +
            "    O _ O\n"
            +
            "O O O _ O O O\n"
            +
            "O O O O O O O\n"
            +
            "O O O O O O O\n"
            +
            "    O O O\n"
            +
            "    O O O\n"
            +
            "Score: 31\n"
            +
            "Game quit!\n"
            +
            "State of game when quit:\n"
            +
            "    O O O\n"
            +
            "    O _ O\n"
            +
            "O O O _ O O O\n"
            +
            "O O O O O O O\n"
            +
            "O O O O O O O\n"
            +
            "    O O O\n"
            +
            "    O O O\n"
            +
            "Score: 31", appendable.toString());
  }

  @Test
  public void testNoWhiteSpacePlayGame() {
    Readable readable = new StringReader("6444 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n"
            +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testTwoStringPlayGame() {
    Readable readable = new StringReader("o q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "It's not an integer or 'Q'/'q'. Please re-enter.Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testQBetweenIntPlayGame() {
    Readable readable = new StringReader("2 4 q 4 4");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testMoreThan4IntValidPlayGame() {
    Readable readable = new StringReader("1 2 4 3 4 7 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testMoreThan4IntValidHindPlayGame() {
    Readable readable = new StringReader("2 4 4 4 6 6 4 6 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", appendable.toString());
  }

  @Test
  public void testNoSuchElementValidPlayGame() {
    Readable readable = new StringReader("2 4 4 4");
    MarbleSolitaireController controllerNSEE =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    assertThrows(IllegalStateException.class, controllerNSEE::playGame);
  }

  @Test
  public void testNoSuchElementBlankPlayGame() {
    Readable readable = new StringReader("");
    MarbleSolitaireController controllerNSEE =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    assertThrows(IllegalStateException.class, controllerNSEE::playGame);
  }

  @Test
  public void testStringBetweenIntPlayGame() {
    Readable readable = new StringReader("2 4 4 o 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "It's not an integer or 'Q'/'q'. Please re-enter.    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", appendable.toString());
  }

  @Test
  public void testNonIntNonQWithValidInputPlayGame() {
    Readable readable = new StringReader("2 4 & 4 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "It's not an integer or 'Q'/'q'. Please re-enter.    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", appendable.toString());
  }

  @Test
  public void testOnlyNonIntNonQPlayGame() {
    Readable readable = new StringReader("& q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "It's not an integer or 'Q'/'q'. Please re-enter.Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testOneNegativeIntPlayGame() {
    Readable readable = new StringReader("-4 6 4 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Enter a negative value. Please re-enter.Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testFourNegIntPlayGame() {
    Readable readable = new StringReader("-2 -2 -4 -4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Enter a negative value. Please re-enter.Enter a negative value. Please re-enter.Enter a negative value. Please re-enter.Enter a negative value. Please re-enter.Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testNotOnBoardInvalidMovePlayGame() {
    Readable readable = new StringReader("20 20 22 20 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testGoToNonEmptyInvalidMovePlayGame() {
    Readable readable = new StringReader("4 6 6 6 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testCallOnNonMarbleInvalidMovePlayGame() {
    Readable readable = new StringReader("3 3 5 3 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testMovesMoreThanTwoSpacesInvalidMovePlayGame() {
    Readable readable = new StringReader("4 6 7 6 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testJumpDiagonallyInvalidMovePlayGame() {
    Readable readable = new StringReader("4 6 3 7 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testJumpByNonMarbleInvalidMovePlayGame() {
    Readable readable = new StringReader("4 3 2 3 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testWinGameOverPlayGame() {
    Readable readable = new StringReader("4 6 4 4\n" +
            "  2 5 4 5\n" +
            "  3 7 3 5\n" +
            "  5 7 3 7\n" +
            "  3 4 3 6\n" +
            "  3 7 3 5\n" +
            "  3 2 3 4\n" +
            "  1 3 3 3\n" +
            "  1 5 1 3\n" +
            "  4 3 2 3\n" +
            "  1 3 3 3\n" +
            "  6 3 4 3\n" +
            "  5 1 5 3\n" +
            "  3 1 5 1\n" +
            "  5 4 5 2\n" +
            "  5 6 5 4\n" +
            "  7 5 5 5\n" +
            "  7 3 7 5\n" +
            "  4 5 6 5\n" +
            "  7 5 5 5\n" +
            "  5 1 5 3\n" +
            "  4 3 2 3\n" +
            "  2 3 2 5\n" +
            "  2 5 4 5\n" +
            "  4 5 6 5\n" +
            "  6 5 6 3\n" +
            "  6 3 4 3\n" +
            "  4 4 2 4\n" +
            "  4 2 4 4\n" +
            "\t4 4 6 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O O _ _\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O O _ O\n" +
            "O O O O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O _ _ O O\n" +
            "O O O O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O _ O _ _\n" +
            "O O O O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O _ _ O O _ _\n" +
            "O O O O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O _ _\n" +
            "    O O _\n" +
            "O _ _ O O _ _\n" +
            "O O _ O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O _ O O _ _\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O _ _\n" +
            "O O _ O O O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O _ _\n" +
            "_ _ O O O O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O _ _\n" +
            "O _ O O O O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O _ _\n" +
            "O O _ _ O O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O _ _\n" +
            "O O _ O _ _ _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O _ _\n" +
            "O O _ O O _ _\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O _ _\n" +
            "O O _ O O _ _\n" +
            "    _ O _\n" +
            "    _ _ O\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O _ _ _\n" +
            "O O _ O _ _ _\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O _ _ _\n" +
            "O O _ O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O _ _ _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    O O _\n" +
            "_ _ _ O O _ _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ O O _ _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "    _ O O\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ O _ O _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ O O O _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2", appendable.toString());
  }

  @Test
  public void testNoLegalMovesGameOverPlayGame() {
    Readable readable = new StringReader("2 5 4 5 \n q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", appendable.toString());
  }

  @Test
  public void testChangeNewLinePlayGame() {
    Readable readable = new StringReader("2 4 \n 4 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model, textView, readable);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", appendable.toString());
  }

  @Test
  public void testMockModelValid() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readable1 = new StringReader("2 4 4 4 Q");
    MarbleSolitaireView textView = new MarbleSolitaireTextView(model);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mockModel, textView, readable1);
    controller.playGame();
    assertEquals("", appendable.toString());
  }

  @Test
  public void testMockModelLetters() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readable = new StringReader("a b c d 6 Q");
    MarbleSolitaireView textView = new MarbleSolitaireTextView(model);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mockModel, textView, readable);
    controller.playGame();
    assertEquals("", appendable.toString());
  }

  @Test
  public void testMockModelSymbols() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readable = new StringReader("a b c d Q");
    MarbleSolitaireView textView = new MarbleSolitaireTextView(model);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mockModel, textView, readable);
    controller.playGame();
    assertEquals("", appendable.toString());
  }

  @Test
  public void testMockModelNeg() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readable = new StringReader("a b c d Q");
    MarbleSolitaireView textView = new MarbleSolitaireTextView(model);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mockModel, textView, readable);
    controller.playGame();
    assertEquals("", appendable.toString());
  }


  @Test
  public void testMockModelLettersConstNulls() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readable = new StringReader("a b c d Q");
    MarbleSolitaireView textView = new MarbleSolitaireTextView(model);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mockModel, textView, readable);
    controller.playGame();
    assertEquals("", appendable.toString());
  }
}




