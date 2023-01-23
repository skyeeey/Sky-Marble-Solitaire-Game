package cs3500.marblesolitaire.controller;


/**
 * Represents the controller of the game.
 */
public interface MarbleSolitaireController {
  /**
   * The method to run the game, throws exception when the user enters negative value/non-integer
   * and non q/invalid moves/doesn't add q at the end of their input.
   */
  void playGame();
}
