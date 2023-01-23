package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * The main class of the game.
 */


public final class MarbleSolitaire {

  /**
   * The constructor of main class.
   *
   * @param args enter the String args.
   */
  public static void main(String[] args) {

    TriangleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model);
    MarbleSolitaireController hi = new MarbleSolitaireControllerImpl(model,
            view, new InputStreamReader(System.in));
    hi.playGame();
  }

}
