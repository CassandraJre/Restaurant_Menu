
public class Customer extends Person{
    private String orderType;
    private String onlineOrder;
    private int ticketNumber;
    private int pizzaNumber;
    private String pizzaType;
    private String pizzaSize;
    private double pizzaPrice;
    private String cuttingStyle;
    private int drinks;
    private String allergies;
    private double tip;

    //Customer constructor
    public Customer(String firstName, String lastName, String phoneNumber,
                    String orderType, String onlineOrder, int ticketNumber, int pizzaNumber,
                    String pizzaType, String pizzaSize, double pizzaPrice, String cuttingStyle,
                    int drinks, String allergies, double tip) {
       super(firstName, lastName, phoneNumber);
        this.orderType = orderType;
        this.onlineOrder = onlineOrder;
        this.ticketNumber = ticketNumber;
        this.pizzaNumber = pizzaNumber;
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.pizzaPrice = pizzaPrice;
        this.cuttingStyle = cuttingStyle;
        this.drinks = drinks;
        this.allergies = allergies;
        this.tip = tip;
    }

    //Getters for all the variables
    public String getOrderType() { 
        return orderType; 
    }
    public String getOnlineOrder() { 
        return onlineOrder; 
    }
    public int getTicketNumber() { 
        return ticketNumber; 
    }
    public int getPizzaNumber() { 
        return pizzaNumber; 
    }
    public String getPizzaType() { 
        return pizzaType; 
    }
    public String getPizzaSize() {
         return pizzaSize; 
        }
    public double getPizzaPrice() { 
        return pizzaPrice; 
    }
    public String getCuttingStyle() {
         return cuttingStyle; 
        }
    public int getDrinks() { 
        return drinks; 
    }
    public String getAllergies() { 
        return allergies; 
    }
    public double getTip() { 
        return tip; 
    }
}




