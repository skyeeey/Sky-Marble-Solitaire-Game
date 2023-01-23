package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the visualization of the game.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private final MarbleSolitaireModelState model;
  private final Appendable appendable;


  /**
   * Constructor for a visualization of game without knowing the output.
   *
   * @param model enter the modelState of the game
   * @throws IllegalArgumentException if model is equal to null.
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("the model is null");
    }
    this.model = model;
    this.appendable = System.out;
  }

  /**
   * Constructor for a visualization of game given the output.
   *
   * @param model      enter the modelState of the game
   * @param appendable the output stream
   * @throws IllegalArgumentException if appendable is equal to null.
   * @throws IllegalArgumentException if model is equal to null.
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable appendable) {
    if (appendable == null) {
      throw new IllegalArgumentException("Appendable object is null.");
    }
    if (model == null) {
      throw new IllegalArgumentException("Model object is null.");
    }
    this.model = model;
    this.appendable = appendable;
  }


  /**
   * Helper method for the toString method.
   *
   * @param slotState enter the slot state of a slot
   * @return the corresponding string with the slot state
   */
  public String toStringHelper(MarbleSolitaireModelState.SlotState slotState) {
    String value = "";
    if (slotState == MarbleSolitaireModelState.SlotState.Empty) {
      value = "_";
    } else if (slotState == MarbleSolitaireModelState.SlotState.Invalid) {
      value = " ";
    } else if (slotState == MarbleSolitaireModelState.SlotState.Marble) {
      value = "O";
    }
    return value;
  }

  /**
   * Method to visualize the game board/state.
   * @return the visualization of the game.
   */

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.model.getBoardSize(); i++) {
      for (int j = 0; j < this.model.getBoardSize(); j++) {
        sb.append(toStringHelper(model.getSlotAt(i, j)));
        if (((i < model.getBoardSize() - 1)
                && (j == model.getBoardSize() - 1))
                || ((model.getSlotAt(i, j + 1) == MarbleSolitaireModelState.SlotState.Invalid)
                && (model.getSlotAt(i, j) != MarbleSolitaireModelState.SlotState.Invalid))) {
          sb.append("\n");
          break;
        } else {
          sb.append(" ");
        }
      }
    }
    sb.delete(sb.length() - 1, sb.length());
    return sb.toString();
  }

  // transmits the state of the board produced by this view (exactly as before)
  // to the Appendable object provided through its constructor.
  @java.lang.Override
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString());
  }

  // transmit the given message to the Appendable object.
  @java.lang.Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}
