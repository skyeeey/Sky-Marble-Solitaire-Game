package cs3500.marblesolitaire.model.hw04;

/**
 * Represents the European Solitaire Model class.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {


  //    private final int armThickness;
//    private final SlotState[][] board;
//    private int currentScore;
//
  public EuropeanSolitaireModel() {
    this(3, 3, 3);

    this.board[3][3] = SlotState.Empty;
  }

  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness, (armThickness * 3 - 2) / 2, (armThickness * 3 - 2) / 2);
    if (armThickness < 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("arm thickness cannot work");
    }
    this.board[getBoardSize() / 2][getBoardSize() / 2] = SlotState.Empty;
  }

  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
    if (sRow < 0 || sCol < 0) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }
    this.board[sRow][sCol] = SlotState.Empty;
  }


  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("arm thickness is even");
    }
  }

  @Override
  public boolean invalidCase(int i, int j) {
    return (((j < armThickness - 1 && i < armThickness - 1)
            || (j > 2 * armThickness - 2 && i < armThickness - 1)
            || (j < armThickness - 1 && i > 2 * armThickness - 2)
            || (j > 2 * armThickness - 2 && i > 2 * armThickness - 2)));

  }
}

