package com.oktenwebjavaadvanced.service;

import com.oktenwebjavaadvanced.entity.Computer;

import java.util.List;

public interface ComputerService {

    List<Computer> getAllComputers();

    Computer createComputer(Computer computer);

    Computer updateComputer(int id, Computer computer);

    void deleteComputer(int id);
}
