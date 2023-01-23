package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  private final MarbleSolitaireModelState model;
  private final Appendable appendable;

  /**
   * Constructor for a visualization of game without knowing the output.
   *
   * @param model enter the modelState of the game
   * @throws IllegalArgumentException if model is equal to null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model);
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
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable appendable) {
    super(model, appendable);
    if (appendable == null) {
      throw new IllegalArgumentException("Appendable object is null.");
    }
    if (model == null) {
      throw new IllegalArgumentException("Model object is null.");
    }
    this.model = model;
    this.appendable = appendable;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    //append space
    for (int i = 0; i < this.model.getBoardSize(); i++) {
      int lineNumber = i + 1;
      for (int j = 0; j < this.model.getBoardSize() - lineNumber; j++) {
        sb.append(" ");
      }
      //append space between marbles
      for (int j = 0; j < lineNumber; j++) {
        if ((j != i) && (model.getSlotAt(i, j) != MarbleSolitaireModelState.SlotState.Invalid)
                && (model.getSlotAt(i, j + 1) != MarbleSolitaireModelState.SlotState.Invalid)) {
          sb.append(toStringHelper(model.getSlotAt(i, j)));
          sb.append(" ");
        } else {
          sb.append(toStringHelper(model.getSlotAt(i, j)));
        }
      }
      // start new line when i
      for (int j = 0; j < lineNumber; j++) {
        if (i == j) {
          sb.append("\n");
        }
      }
    }
    return sb.toString();
  }
}
