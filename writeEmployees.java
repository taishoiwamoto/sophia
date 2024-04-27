public static void writeEmployees(String csvFile, ArrayList<String> employees) {
    File outputFile = new File(csvFile);
    try {
      // Write to output file in APPEND mode
      Files.write(outputFile.toPath(), employees, StandardOpenOption.APPEND);
    }
    catch(IOException ex) {
      System.out.println("Error writing to file: " + ex.getMessage());
    }
  }
  