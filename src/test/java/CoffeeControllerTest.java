import api.coffee.Application;
import api.coffee.model.Coffee;
import api.coffee.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CoffeeControllerTest {

    private String resourceUrl;

    private UUID id;

    @Autowired
    TestRestTemplate restTemplate;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setup() {
        resourceUrl = "http://localhost:" + port + "/order";
    }


    @Test
    public void shouldPostCoffee() {
        Order order = new Order();
        ResponseEntity<Order> orderresponse = restTemplate.postForEntity(resourceUrl, order, Order.class);
        UUID id = orderresponse.getBody().getId();
        Coffee coffee = new Coffee();
        coffee.setType("latte");
        ResponseEntity<Coffee> coffeeresponse = restTemplate.postForEntity(resourceUrl + "/" + id + "/coffee", coffee, Coffee.class);
        assertThat(coffeeresponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println("*****Ramya****" + coffeeresponse.getBody().getId());
    }


//    @Test
//    public void shouldGetOrderedObject() {
//
//        ResponseEntity<Order> response  = restTemplate.getForEntity(resourceUrl + id, Order.class);
//        assertThat(response.equals(Order.class));
//
//    }
//
//    @Test
//    public void shouldCancelObject() {
//        Order order = new Order();
//        UUID id = UUID.randomUUID();
//        order.setId(id);
//        restTemplate.delete(resourceUrl + id, order);
//        ResponseEntity<Order> response  = restTemplate.getForEntity(resourceUrl + id, Order.class);
//        assertThat(response.equals(null));
//
//    }



}



