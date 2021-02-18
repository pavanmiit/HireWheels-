package com.upgrad.hirewheels;

import dao.UsersDao;
import entities.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import services.UserService;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UsersDao dto;

    @Autowired
    UserService servic;

    @Test
    public void testgetUser(){
        Users users = new Users(1,"pavan","kumar","pavanmiit","123456","abcd@gmail.com");
        dto.save(users);
        Users savedusers = servic.getUser("abc@gmail.com","123456");
        Assertions.assertNotNull(savedusers);
        Assertions.assertTrue(savedusers.getCustomerId() == 1);
        Assertions.assertEquals("pavan", savedusers.getFirstName());

    }




    @Test
    public void testcreateUser() throws Exception {
        Users users = new Users(1,"pavan","kumar");
        dto.save(users);
        Users savedusers = dto.findById(users.getCustomerId());
        Assertions.assertNotNull(savedusers);
        Assertions.assertTrue(savedusers.getCustomerId() != 0);
        Assertions.assertEquals("pavan", savedusers.getFirstName());
    }
}
