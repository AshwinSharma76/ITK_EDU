import java.util.*;
import java.util.stream.Collectors;



class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}

public class StreamMain {
    public static void main(String[] args) {
       List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        
        Map<String,Double> totalCost =orders.stream().collect(
          Collectors.groupingBy(
            Order::getProduct,
            Collectors.summingDouble(Order::getCost)
            )
          );
          
          totalCost.entrySet().stream().
          sorted(
            (e1,e2)->Double.compare(e1.getValue(),e2.getValue())
            ).limit(3)
          .forEach(entry ->
                        System.out.println(entry.getKey() + " → " + entry.getValue())
                );
        
    }
}
