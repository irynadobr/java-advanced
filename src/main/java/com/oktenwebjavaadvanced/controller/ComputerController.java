package com.oktenwebjavaadvanced.controller;

import com.oktenwebjavaadvanced.entity.Computer;
import com.oktenwebjavaadvanced.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {

    @Autowired
   private ComputerService computerService;

    @GetMapping(value = "/computer")
    public List<Computer>getComputers(){
        return computerService.getAllComputers();
    }

    @PostMapping (value = "/computer")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer insertComputer (@RequestBody Computer computer) {
        return computerService.createComputer(computer);
    }

@PutMapping(value = "/computer/{id}")
@ResponseStatus(HttpStatus.ACCEPTED)
public Computer updateComputer (@PathVariable int id, @RequestBody Computer computer) {
        return computerService.updateComputer(id, computer);
}

@DeleteMapping(value = "/computer/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteComputer (@PathVariable int id) {
        computerService.deleteComputer(id);

}

}
