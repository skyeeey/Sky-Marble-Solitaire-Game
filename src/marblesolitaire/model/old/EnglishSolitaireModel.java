package cs3500.marblesolitaire.model.hw02;

//You need to write correct java docs for each interface, class, methods and tests,
//and also inline comments for complicated code.

//Points will be taken off for missing documentation.
//parameter or exception and return

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Represents a marble model.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * initialize the game board as arm thickness 3 with the empty slot at the center.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
    this.board[3][3] = SlotState.Empty;
  }

  /**
   * initialize the game board with arm thickness 3 and the empty slot at the position(sRow, sCol).
   *
   * @param sRow position x of the empty slot
   * @param sCol position y of the empty slot
   * @throws IllegalArgumentException if the empty cell position is invalid
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
    if (sRow < 0 || sCol < 0) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }
    this.board[sRow][sCol] = SlotState.Empty;
  }

  /**
   * initialize a game board with the empty slot at the center.
   *
   * @param armThickness the number of marbles in the top or bottom, left or right column.
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number.
   */

  public EnglishSolitaireModel(int armThickness) {
    this(armThickness, (armThickness * 3 - 2) / 2, (armThickness * 3 - 2) / 2);
    if (armThickness < 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("arm thickness cannot work");
    }
    this.board[getBoardSize() / 2][getBoardSize() / 2] = SlotState.Empty;
  }

  /**
   * initialize a board by taking in arm thickness and empty slot position.
   *
   * @param armThickness the number of marbles in the top row.
   * @param sRow         position x of the empty slot
   * @param sCol         position y of the empty slot
   */

  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("arm thickness is even");
    }
  }

  @Override
  public boolean invalidCase(int i, int j) {
    return (((j < armThickness - 1)
            || (j >= 2 * armThickness - 1))
            && (i < armThickness - 1)
            || (i >= 2 * armThickness - 1)
            && ((j < armThickness - 1)
            || (j >= 2 * armThickness - 1)));
  }
}




