package com.example.jpa.config;

import com.example.jpa.entities.*;
import com.example.jpa.entities.enuns.OrderStatus;
import com.example.jpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile(value = "dev")
public class testconfig implements CommandLineRunner {

    @Autowired
    public OrderItemRepository orderItemRepository;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CategoryRespository categoryRespository;


    @Override
    public void run(String... args)  {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");


        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");

        User u1 = new User(null, "maria lucia", "maria@gmail.com", "998877", "1236" );
        User u2 = new User(null, "lucia", "lulu@gmail.com", "99889877", "4455" );

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAYD, u2);


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
        productRepository.saveAll(Arrays.asList(p1,p2,p3));
        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));
        categoryRespository.saveAll(Arrays.asList(cat1,cat2));



    }
}
