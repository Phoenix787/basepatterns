package com.example.basepatterns.behavioral.strategy.app02;

import com.example.basepatterns.behavioral.strategy.app02.order.Order;
import com.example.basepatterns.behavioral.strategy.app02.strategies.PayByCreditCard;
import com.example.basepatterns.behavioral.strategy.app02.strategies.PayByPayPal;
import com.example.basepatterns.behavioral.strategy.app02.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static Map<Integer, Integer> priceInOrder = new HashMap<>(); //это прайс
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceInOrder.put(1, 2200);
        priceInOrder.put(2, 1850);
        priceInOrder.put(3, 1100);
        priceInOrder.put(4, 890);
    }
    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do{
                System.out.print("Select a product:\n" +
                        "1 - Mother board\n" +
                        "2 - CPU\n" +
                        "3 - HDD\n" +
                        "4 - Memory\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceInOrder.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(count * cost);
                System.out.print("You wish to continue selection? Y/N: ");
                continueChoice = reader.readLine();
            }while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Select a Payment Method\n" +
                        "1 - PayPal\n" +
                        "2 - Credit Card\n");
                String paymentMethod = reader.readLine();

                // Клиент создаёт различные стратегии на основании
                // пользовательских данных, конфигурации и прочих параметров.

                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else if (paymentMethod.equals("2")) {
                    strategy = new PayByCreditCard();
                }
                // Объект заказа делегирует сбор платёжных данны стратегии, т.к.
                // только стратегии знают какие данные им нужны для
                // приёма оплаты.
                order.processOrder(strategy);
            }
            System.out.print("Pay " + Order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("p")){
                //и наконец стратегия запускает прием платежа
                if (strategy.pay(Order.getTotalCost())) {
                    System.out.println("Payment has succeeded");
                } else {
                    System.out.println("FAIL! Check your data");
                }
                order.setClosed();
            }
        }

    }
}
