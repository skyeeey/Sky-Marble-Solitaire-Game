package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected final int armThickness;
  protected final MarbleSolitaireModelState.SlotState[][] board;
  protected int currentScore;

  /** initialize a board by taking in arm thickness and empty slot position.
   * @param armThickness the number of marbles in the top row.
   * @param sRow         position x of the empty slot
   * @param sCol         position y of the empty slot
   */

  public AbstractSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException{
    this.armThickness = armThickness;
    try {
      this.board = new SlotState[getBoardSize()][getBoardSize()];
    } catch (NegativeArraySizeException e) {
      throw new IllegalArgumentException("arm thickness is negative.");
    }
    this.fill(armThickness);

    if (sRow > getBoardSize() - 1|| sCol > getBoardSize() - 1 || (sRow < 0 || sCol < 0)) {
      throw new IllegalArgumentException("Proposed empty space is not on the board");
    }

    if (this.board[sRow][sCol] == MarbleSolitaireModelState.SlotState.Invalid) {
      throw new IllegalArgumentException("Proposed empty space is invalid");
    }
    this.currentScore = (armThickness * (armThickness - 1) * 4)
            + (armThickness * armThickness) - 1;

    this.board[sRow][sCol] = MarbleSolitaireModelState.SlotState.Empty;
  }

//get Score two for loops local variable currentScore



  public abstract boolean invalidCase(int i, int j);


  private void fill(int armThickness) {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.invalidCase(i, j)) {
          this.board[i][j] = SlotState.Invalid;
        } else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
  }


  public String canMove(int fromRow, int fromCol, int toRow, int toCol) {
    // make sure it's on the board
    if (fromRow < 0
            || fromCol < 0
            || toRow < 0
            || toCol < 0
            || fromRow > getBoardSize() - 1
            || fromCol > getBoardSize() - 1
            || toRow > getBoardSize() - 1
            || toCol > getBoardSize() - 1) {
      return "not on the board";
    }
    //make sure the one going to is empty
    if (this.getSlotAt(toRow, toCol) != SlotState.Empty) {
      return "going to a non-empty space";
    }
    //make sure the thing you call on is a marble
    if (this.board[fromRow][fromCol] != SlotState.Marble) {
      return "call on a non-marble";
    } else {
      return canMoveAll(fromRow, fromCol, toRow, toCol);
    }
  }

  public String canMoveAll(int fromRow, int fromCol, int toRow, int toCol) {
    //make sure if the chess only moves 2-spaces
    if (((fromCol == toCol)
            && Math.abs(fromRow - toRow) != 2)
            || ((fromRow == toRow)
            && Math.abs(fromCol - toCol) != 2)) {
      return "not moving 2 spaces";
    }
    //to check if it doesn't jump diagonally
    if (!(fromRow == toRow
            && (Math.abs(fromCol - toCol)) == 2)
            && !(fromCol == toCol && (Math.abs(fromRow - toRow)) == 2)) {
      return "cannot jump diagonally";
    }
    //to check if the one jumped by is a marble
    if (((fromRow == toRow
            && fromCol - toCol == 2) && this.board[toRow][fromCol - 1] != SlotState.Marble)
            || ((fromRow == toRow
            && fromCol - toCol == -2) && this.board[fromRow][fromCol + 1] != SlotState.Marble)
            || ((fromCol == toCol
            && fromRow - toRow == 2) && this.board[fromRow - 1][fromCol] != SlotState.Marble)
            || ((fromCol == toCol
            && fromRow - toRow == -2) && this.board[fromRow + 1][fromCol] != SlotState.Marble)) {
      return "jumped by slot is not a marble";
    } else {
      return "true";
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    // exceptions in canMove
    if (!(this.canMove(fromRow, fromCol, toRow, toCol).equals("true"))) {
      throw new IllegalArgumentException(this.canMove(fromRow, fromCol, toRow, toCol));
    }
    if ((this.canMove(fromRow, fromCol, toRow, toCol).equals("true"))) {
      this.currentScore = currentScore - 1;
      this.board[fromRow][fromCol] = SlotState.Empty;
      this.board[toRow][toCol] = SlotState.Marble;
      if (fromCol + 2 == toCol) {
        this.board[fromRow][fromCol + 1] = SlotState.Empty;
      } else if (fromCol - 2 == toCol) {
        this.board[fromRow][fromCol - 1] = SlotState.Empty;
      } else if (fromRow - 2 == toRow) {
        this.board[fromRow - 1][fromCol] = SlotState.Empty;
      } else if (fromRow + 2 == toRow) {
        this.board[fromRow + 1][fromCol] = SlotState.Empty;
      }
    }
  }


  //check when the chess cannot move
  //case1: win
  //case2: no more legal move
  @Override
  public boolean isGameOver() {
    if (currentScore <= 1) {
      return true;
    } else {
      for (int i = 0; i <= this.getBoardSize() - 1; i++) {
        for (int j = 0; j <= this.getBoardSize() - 1; j++) {
          if (this.canMove(i, j, i + 2, j).equals("true")
                  || (this.canMove(i, j, i - 2, j).equals("true"))
                  || (this.canMove(i, j, i, j - 2).equals("true"))
                  || (this.canMove(i, j, i, j + 2).equals("true"))) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return armThickness * 3 - 2;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row >= board.length || col >= board.length) {
      throw new IllegalArgumentException("not on the board");
    } else {
      return this.board[row][col];
    }
  }

  // change to for loops
  @Override
  public int getScore() {
    return currentScore;
  }
}

