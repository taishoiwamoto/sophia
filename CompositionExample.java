class CompositionExample {
    public static void main(String[] args) {
      // Construct Coffee & Tea objects that have a Beverage objet embedded in them.
      // There's nothing unusual about the constructor calls.
      Coffee darkRoastCoffee = new Coffee("dark roast", 20, false, 2.59);
      Tea blackTea = new Tea("black", 16, false, 2.00);
      // Print out information about the drinks using their toString() methods
      System.out.println(darkRoastCoffee);
      System.out.println(blackTea);
    }
  }