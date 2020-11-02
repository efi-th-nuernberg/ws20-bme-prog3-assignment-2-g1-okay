import java.io.BufferedReader;
import java.util.ArrayList;

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

    String[] words = aText.split("\\b");
    int currentLineLength = 0;

    for(int i = 0; i < words.length; i++) {
      String word = words[i];
      if (currentLineLength + word.length() > maxLineLength) {
        formattedString += "\n";
        currentLineLength = 0;
      }

      // Don't put whitespaces at the front of a new line
      if(!(currentLineLength == 0 && word.trim().length() == 0)) {
        formattedString += word;
        currentLineLength += word.length(); 
      }
    }

    // Finally print the formatted text
    System.out.println(formattedString);
  }

  public void printRight(String aText) {
    ArrayList<String> lines = new ArrayList<String>();
    String currentLine = "";
    String[] words = aText.split("\\b");

    for(int i = 0; i < words.length; i++) {
      String word = words[i];
      if (currentLine.length() + word.length() > maxLineLength) {
        // Handle linebreak
        currentLine = fillWithSpaces(currentLine.trim());
        lines.add(currentLine);

        currentLine = "";
      }

      currentLine += word;
      
    }
    // Don't forget the final line
    currentLine = fillWithSpaces(currentLine);
    lines.add(currentLine);

    printLines(lines);
  }

  // Adds spaces in front of String so all lines have the same length
  private String fillWithSpaces(String line) {
    while(line.length() < 30) {
      line = " " + line;
    }
    return line;
  }

  // Print out the given ArrayList line by line
  private void printLines(ArrayList<String> text) {
    for (String line : text) {
      System.out.println(line);
    }
  }
}