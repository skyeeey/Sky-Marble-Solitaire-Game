package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Represents the implementation of controller of the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable myInputStream;
  private boolean myQuitState;

  /**
   * Constructor of controller impl class.
   *
   * @param model model of the game
   * @param view  view of the game
   * @param in    input stream of the game
   * @throws IllegalArgumentException when model/view/readable is null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable in) {

    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Model, view, or readable is null.");
    }
    this.model = model;
    this.view = view;
    this.myInputStream = Objects.requireNonNull(in);
    this.myQuitState = true;
  }

  /**
   * Render board method with try catch statement.
   *
   * @throws IllegalStateException if unable to successfully read input or transmit output
   */

  private void completeRenderBoard() {
    try {
      view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException("unable to successfully read input or transmit output");
    }
  }

  /**
   * Render message method with try catch statement.
   *
   * @param message message we want the program to write
   * @throws IllegalStateException if unable to successfully read input or transmit output
   */

  private void completeRenderMessage(String message) {
    try {
      view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("unable to successfully read input or transmit output");
    }
  }

  /**
   * Helper method for users to quit the game.
   */
  private void quitGame() {
    myQuitState = false;
    this.completeRenderMessage("Game quit!\n");
    this.completeRenderMessage("State of game when quit:\n");
    this.completeRenderBoard();
    this.completeRenderMessage("\nScore: " + model.getScore());
  }

  /**
   * Helper for running the game with a while loop that check if the user enters correct and valid
   * 4-int values in the input stream:
   * if correct, run the move method on the current board and throws an illegal argument exception
   * when the user enters a invalid move;
   * if incorrect, throw different illegal argument exceptions at cases
   * when user enter negative values, non-integer or non q values.
   *
   * @param scanner scanner to read input
   */

  private void playScannerHelper(Scanner scanner) {
    ArrayList<Integer> input = new ArrayList<>();

    while (input.size() < 4) {
      String next = scanner.next();
      try {
        int h = Integer.parseInt(next);
        if (h > 0) {
          input.add(h);
        } else {
          this.completeRenderMessage("Enter a negative value. Please re-enter.");
        }
      } catch (NumberFormatException e) {
        if (next.equals("q") || next.equals("Q")) {
          this.quitGame();
          return;
        } else {
          this.completeRenderMessage("It's not an integer or 'Q'/'q'. Please re-enter.");
        }
      }
    }
    if (input.size() == 4 && this.myQuitState) {
      try {
        if (this.myQuitState && model.getScore() > 1) {
          model.move(input.get(0) - 1, input.get(1) - 1,
                  input.get(2) - 1, input.get(3) - 1);
        }
      } catch (IllegalArgumentException e) {
        this.completeRenderMessage("Invalid move. Play again.");
      }
    }
  }

  @Override
  public void playGame() {
    Scanner scanner = new Scanner(this.myInputStream);
    try {
      while (!this.model.isGameOver()) {
        if (!myQuitState) {
          return;
        }
        this.completeRenderBoard();
        this.completeRenderMessage("\nScore: " + model.getScore() + "\n");
        this.playScannerHelper(scanner);
      }
      this.completeRenderMessage("Game over!\n");
      this.completeRenderBoard();
      this.completeRenderMessage("\nScore: " + model.getScore());
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("should add a Q at the end of this line");
    }
  }

}