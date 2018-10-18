package com.springmysql.demo.controller;


import com.springmysql.demo.model.Stock;
import com.springmysql.demo.model.User;
import com.springmysql.demo.repo.StockRepository;
import com.springmysql.demo.repo.UserRepository;
import com.springmysql.demo.services.UserService;
import com.springmysql.demo.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("account")
public class Controller {

    public static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    StockRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        if(userService.find(newUser.getUsername()) != null) {
            logger.error("Username already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist"),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");

        return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        logger.info("user logged " + principal);
        return principal;
    }


//    @RequestMapping(value = "stocks", method = RequestMethod.GET)
//    public List<Stock> getAllStocks() {
//        System.out.println("Get all Stocks...");
//
//        List<Stock> stocks = new ArrayList<>();
//        repository.findAll().forEach(stocks::add);
//
//        return stocks;
//    }
//
//    @PostMapping(value = "register")
//    public User addUser(@RequestBody User user) {
//        User _user = userRepository.save(new User(user.getName(), user.getPassword(), user.getEmail()));
//        return _user;
//    }
//
//    @PostMapping(value = "create")
//    public Stock postStock(@RequestBody Stock stock) {
//
//        Stock _stock = (Stock) repository.save(new Stock(stock.getStock_name(), stock.getStock_price(), stock.getStock_field()));
//        return _stock;
//    }
//
//    @DeleteMapping("/stocks/{id}")
//    public ResponseEntity<String> deleteStock(@PathVariable("id") long id) {
//        System.out.println("Delete Stock with id = " + id + "...");
//
//        repository.deleteById(id);
//
//        return new ResponseEntity<String>("Customer has been deleted!", HttpStatus.OK);
//    }



}
