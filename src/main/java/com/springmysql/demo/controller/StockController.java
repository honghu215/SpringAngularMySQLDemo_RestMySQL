package com.springmysql.demo.controller;


import com.springmysql.demo.model.Stock;
import com.springmysql.demo.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class StockController {

    @Autowired
    StockRepository repository;

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public List<Stock> getAllStocks() {
        System.out.println("Get all Stocks...");

        List<Stock> stocks = new ArrayList<>();
        repository.findAll().forEach(stocks::add);

        return stocks;
    }

    @PostMapping(value = "/stocks/create")
    public Stock postStock(@RequestBody Stock stock) {

        Stock _stock = (Stock) repository.save(new Stock(stock.getStock_name(), stock.getStock_price(), stock.getStock_field()));
        return _stock;
    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable("id") long id) {
        System.out.println("Delete Stock with id = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<String>("Customer has been deleted!", HttpStatus.OK);
    }
}
