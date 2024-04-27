public class Tea {
    private Beverage beverage;
    private String teaType;
    private boolean iced;
      
    public Tea(String teaType, int size, boolean iced, double price) {
      // Construct the embedded Beverage object
      this.beverage = new Beverage("tea", size, price);
      this.teaType = teaType;
      this.iced = iced;
    }
      
    // The Tea class's getName() calls the embedded object's getName()
    public String getName() {
      return beverage.getName();
    }
    
    // The Tea class's getSize() calls the embedded object's getSize()   
    public int getSize() {
      return beverage.getSize();
    }
    
    // The Tea class's getPrice() calls the embedded object's getPrice()  
    public double getPrice() {
      return beverage.getPrice();
    }
      
    public String getTeaType() {
      return teaType;
    }
      
    public boolean isIced() {
      return iced;
    }
  
    public String toString() {
      // Note use of accessor methods that forward calls to get info from embedded object
      String item = teaType + " tea (" + getSize() + " oz.) " + beverage.PriceFormat.format(getPrice());
      if(iced) {
        return "iced " + item;
      }
      else {
        return "hot " + item;
      }
    }
  }