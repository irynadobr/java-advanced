package com.oktenwebjavaadvanced.service;

import com.oktenwebjavaadvanced.dao.ComputerDao;
import com.oktenwebjavaadvanced.entity.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
class ComputerServiceImpl implements ComputerService {
@Autowired
    private ComputerDao computerDao;

    @Override
    public List<Computer> getAllComputers() {
        return computerDao.findAll();
    }

    @Override
    public Computer createComputer(Computer computer) {
        return computerDao.saveAndFlush(computer);
    }

    @Override
    public Computer updateComputer(int id, Computer computer) {
        computer.setId(id);
        if (!computerDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        return computerDao.saveAndFlush(computer);
    }

    @Override
    public void deleteComputer(int id) {
        if (!computerDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        computerDao.deleteById(id);
    }
}
