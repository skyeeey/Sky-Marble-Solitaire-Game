package cs3500.marblesolitaire.model.hw02;


import java.util.Objects;


public class Player {
  private String value;

  private Player(String value) {
    this.value = Objects.requireNonNull(value);

  }

  @Override
  public String toString() {
    return this.value;
  }

  static Player X = new Player("X");
  static Player O = new Player("O");
  static Player Empty = new Player(" ");
}
