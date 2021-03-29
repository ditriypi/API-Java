package API;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

public class OrderTest {
    @Test
    public void createNewOrder() throws JsonProcessingException {
        Order order = new Order();
        order.setId(2);
        order.setPetId(2);
        order.setQuantity(5);
        order.setStatus("avalable");
        order.setComplete(true);
        OrderRequestFactory orderFact = new OrderRequestFactory(order);
        orderFact.placeOrder();


    }
    @Test
    public void findOrder() throws JsonProcessingException {
        Order order = new Order();
        order.setId(2);
        order.setPetId(2);
        order.setQuantity(5);
        order.setStatus("avalable");
        order.setComplete(true);
        OrderRequestFactory orderFact = new OrderRequestFactory(order);
        orderFact.placeOrder();
        orderFact.findOrderByid(2);

    }
    @Test
    public void deleteOrder() throws JsonProcessingException {
        Order order = new Order();
        order.setId(2);
        order.setPetId(2);
        order.setQuantity(5);
        order.setStatus("avalable");
        order.setComplete(true);
        OrderRequestFactory orderFact = new OrderRequestFactory(order);
        orderFact.placeOrder();
        orderFact.deleteOrderByid(2);

    }


}