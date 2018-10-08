package com.springmysql.demo.repo;

import com.springmysql.demo.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
