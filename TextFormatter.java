import java.io.BufferedReader;
import java.util.Scanner;

class TextFormatter {
  private final int maxLineLength;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
      + "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
      + "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
      + "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
      + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
      + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
      + "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // Ausgabe
  public void print(String aText) {
    String formattedString = "";

    Scanner sc = new Scanner(aText);
    int currentLineLength = 0;

    while (sc.hasNext()) {
      String word = sc.next();
      if (currentLineLength + word.length() >= maxLineLength) {
        formattedString += "  -" + currentLineLength + "\n";
        currentLineLength = 0;
      }

      formattedString += word +  " ";
      currentLineLength += word.length() + 1; // Plus one for added space after every word
    }
    sc.close();

    System.out.println(formattedString);
  }
}