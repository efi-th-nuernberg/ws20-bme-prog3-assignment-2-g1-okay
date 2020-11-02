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

    if (args.length == 0) {
      formatter.printLeft(text);
    } else {
      switch (args[0]) {
      case "left":
        formatter.printLeft(text);
        break;
      case "right":
        formatter.printRight(text);
        break;
      case "block":
        formatter.printBlock(text);
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
    ArrayList<String> lines = splitIntoLines(aText);
    printLines(lines);
  }

  public void printRight(String aText) {
    ArrayList<String> lines = new ArrayList<String>();
    for(String line : splitIntoLines(aText)) lines.add(makeRightJustified(line));
    printLines(lines);
  }

  public void printBlock(String aText) {
    ArrayList<String> lines = new ArrayList<String>();
    for(String line : splitIntoLines(aText)) lines.add(makeJustified(line));
    printLines(lines);
  }

  private ArrayList<String> splitIntoLines(String aText) {
    ArrayList<String> lines = new ArrayList<String>();
    String currentLine = "";
    String[] words = aText.split("\\b");

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (currentLine.length() + word.length() > maxLineLength) {
        // Handle linebreak
        lines.add(currentLine.trim());
        currentLine = "";
      }
      currentLine += word;
    }
    // Don't forget the final line
    lines.add(currentLine);

    return lines;
  }

  // Adds spaces in front of String until it has maxLineLength
  private String makeRightJustified(String line) {
    while (line.length() < maxLineLength) {
      line = " " + line;
    }
    return line;
  }

  // Adds spaces in between words until it has maxLineLength
  private String makeJustified(String line) {
    String[] words= line.trim().split("\\b");

    int lineLength = 0;
    for(String str : arr) length += str.lineLength();
    
    while(lineLength < maxLineLength)
    // Uneven indexes should always be whitespaces here
    // Might put the second condition inside the loop later...but also might not...
    for(int i = 1; i < words.length && lineLength < maxLineLength; i+=2){
      words[i] += " ";
      lineLength++;
    }

    // Hope toString does what I want here, if this is still here leter, it does :3
    return words.toString();
  }

  // Print out the given ArrayList line by line
  private void printLines(ArrayList<String> text) {
    for (String line : text) {
      System.out.println(line);
    }
  }
}