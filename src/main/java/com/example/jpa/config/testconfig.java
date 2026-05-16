package com.example.jpa.config;

import com.example.jpa.entities.Order;
import com.example.jpa.entities.User;
import com.example.jpa.entities.enuns.OrderStatus;
import com.example.jpa.repository.OrderRepository;
import com.example.jpa.repository.UserRepository;
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
    public UserRepository userRepository;

    @Autowired
    public OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "maria lucia", "maria@gmail.com", "998877", "1236" );
        User u2 = new User(null, "lucia", "lulu@gmail.com", "99889877", "4455" );

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAYD, u2);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));




    }
}
