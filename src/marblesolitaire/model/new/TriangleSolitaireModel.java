package cs3500.marblesolitaire.model.hw04;

/**
 * Represents the Triangle Solitaire Model class.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  /**
   * initialize the game board as arm thickness 5 with the empty slot at (0,0).
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
    this.board[0][0] = SlotState.Empty;
  }

  /**
   * initialize the board with a single parameter (dimensions)
   * that creates a game with the specified dimension
   * (number of slots in the bottom-most row) and the empty slot at (0,0).
   *
   * @param armThickness number of slots in the bottom-most row)
   * @throws IllegalArgumentException if the specified dimension is invalid (non-positive).
   */
  public TriangleSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, 0, 0);
  }

  /**
   * initialize the board with two parameters (row,col) that creates a 5-row game
   * with the empty slot at the specified position.
   *
   * @param row position x of the empty slot
   * @param col position y of the empty slot
   * @throws IllegalArgumentException if the specified position is invalid.
   */

  public TriangleSolitaireModel(int row, int col) throws IllegalArgumentException {
    this(5, 0, 0);
  }

  /**
   * initialize the board with three parameters (dimensions,row,col) that creates a game
   * with the specified dimension and an empty slot at the specified row and column.
   *
   * @param armThickness number of slots in the bottom-most row)
   * @param row          position x of the empty slot
   * @param col          position y of the empty slot
   * @throws IllegalArgumentException if the specified dimension is invalid (non-positive)
   *                                  or the specified position is invalid.
   */
  public TriangleSolitaireModel(int armThickness, int row, int col)
          throws IllegalArgumentException {
    super(armThickness, row, col);
    if (armThickness < 1) {
      throw new IllegalArgumentException("Dimension or the specified position is invalid");
    }
  }

  @Override
  public boolean invalidCase(int i, int j) {
    return i < j;
  }

  @Override
  public int getBoardSize() {
    return armThickness;
  }

  //move(): delete diagonal case, change marble skipped cases.
  @Override
  public String canMoveAll(int fromRow, int fromCol, int toRow, int toCol) {
    //make sure if the chess only moves 2 or 4 spaces
    if (((fromCol == toCol)
            && Math.abs(fromRow - toRow) != 2)
            || ((fromRow == toRow)
            && Math.abs(fromCol - toCol) != 2)
            || ((fromCol != toCol && fromRow != toRow)
            && ((Math.abs(fromRow - toCol) != 2)
            && Math.abs(fromCol - toCol) != 2))) {
      return "moves badly";
    }
    //to check if the one jumped by is a marble
    if (((fromRow == toRow
            && fromCol - toCol == 2) && this.board[toRow][fromCol - 1] != SlotState.Marble)
            || ((fromRow == toRow
            && fromCol - toCol == -2) && this.board[fromRow][fromCol + 1] != SlotState.Marble)
            || ((fromCol == toCol
            && fromRow - toRow == 2) && this.board[fromRow - 1][fromCol] != SlotState.Marble)
            || ((fromCol == toCol
            && fromRow - toRow == -2) && this.board[fromRow + 1][fromCol] != SlotState.Marble)
            || (fromRow - toRow == 2 && fromCol - toCol == 2
            && this.board[fromRow - 1][fromCol - 1] != SlotState.Marble)
            || (fromRow - toRow == 2 && fromCol + toCol == 2
            && this.board[fromRow - 1][fromCol + 1] != SlotState.Marble)
            || (fromRow + toRow == 2 && fromCol + toCol == 2
            && this.board[fromRow + 1][fromCol + 1] != SlotState.Marble)
            || (fromRow + toRow == 2 && fromCol - toCol == 2
            && this.board[fromRow + 1][fromCol - 1] != SlotState.Marble)) {
      return "jumped by slot is not a marble";
    } else {
      return "true";
    }
  }

  //check diagonal
  @Override
  public boolean isGameOver() {
    if (currentScore <= 1) {
      return true;
    } else {
      for (int i = 0; i <= this.getBoardSize() - 1; i++) {
        for (int j = 0; j <= this.getBoardSize() - 1; j++) {
          if (this.canMoveAll(i, j, i + 2, j).equals("true")
                  || (this.canMoveAll(i, j, i - 2, j).equals("true"))
                  || (this.canMoveAll(i, j, i, j - 2).equals("true"))
                  || (this.canMoveAll(i, j, i, j + 2).equals("true"))
                  || (this.canMoveAll(i, j, i - 2, j - 2).equals("true"))
                  || (this.canMoveAll(i, j, i + 2, j + 2).equals("true"))
                  || (this.canMoveAll(i, j, i - 2, j + 2).equals("true"))
                  || (this.canMoveAll(i, j, i + 2, j - 2).equals("true"))) {
            return false;
          }
        }
      }
    }
    return true;
  }
}