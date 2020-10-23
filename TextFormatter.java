import java.io.BufferedReader;
import java.util.ArrayList;
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
    
    if(args.length == 0){
      formatter.printLeft(text);
    } else {
      switch (args[0]) {
      case "left":
        formatter.printLeft(text);
        break;
      case "right":
        formatter.printRight(text);
        break;
      default:
        System.out.println("Faulty command line parameter.");
        break;
      }
    } 

  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // Ausgabe
  public void printLeft(String aText) {
    String formattedString = "";

    Scanner sc = new Scanner(aText);
    int currentLineLength = 0;

    while (sc.hasNext()) {
      String word = sc.next();
      if (currentLineLength + word.length() >= maxLineLength) {
        formattedString += "\n";
        currentLineLength = 0;
      }

      formattedString += word + " ";
      currentLineLength += word.length();
    }
    sc.close();

    System.out.println(formattedString);
  }

  public void printRight(String aText) {
    ArrayList<String> lines = new ArrayList<String>();
    String currentLine = "";

    Scanner sc = new Scanner(aText);
    int currentLineLength = 0;

    while (sc.hasNext()) {
      String word = sc.next();
      if (currentLineLength + word.length() >= maxLineLength) {
        // Handle linebreak
        currentLine = fillWithSpaces(currentLine);
        lines.add(currentLine);

        currentLine = "";
        currentLineLength = 0;
      }

      currentLine += " " + word;
      currentLineLength += word.length() + 1; // Plus one for added space after every word
    }
    // Don't forget the final line
    currentLine = fillWithSpaces(currentLine);
    lines.add(currentLine);

    sc.close();

    printLines(lines);
  }

  // Adds spaces in front of String so all lines have the same length
  private String fillWithSpaces(String s) {
    String temp = "";
    for (int i = 0; i < maxLineLength - s.length(); i++)
      temp += " ";
    temp += s;
    return temp;
  }

  // Print out the given ArrayList line by line
  private void printLines(ArrayList<String> text) {
    for (String line : text) {
      System.out.println(line);
    }
  }
}