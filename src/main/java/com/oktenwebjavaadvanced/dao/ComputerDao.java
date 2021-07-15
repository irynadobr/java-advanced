package com.oktenwebjavaadvanced.dao;

import com.oktenwebjavaadvanced.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerDao extends JpaRepository<Computer, Integer> {

}
