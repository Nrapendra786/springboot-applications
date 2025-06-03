package com.techwaala.crud_demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/crud-demo")
@Slf4j
@AllArgsConstructor
public class CrudDemoController {

    private CrudDemoRepository crudDemoRepository;

    @GetMapping("/{id}")
    ResponseEntity<CrudDemo> findOne(@PathVariable("id") Long id) {
        CrudDemo crudDemo = crudDemoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                        "crud_demo id is not found with id = " + id));
        return new ResponseEntity<>(crudDemo, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    ResponseEntity<CrudDemo> findByName(@PathVariable("name") String name) {
        CrudDemo crudDemo = crudDemoRepository.findCrudDemoByName(name)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                        "crud_demo name is not found with id = " + name));
        return new ResponseEntity<>(crudDemo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Optional<CrudDemo>> update(@RequestBody CrudDemo crudDemo) {
        try {
            Long id = crudDemo.getId();
            crudDemoRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                                 "crud_demo name is not found"));
            crudDemoRepository.save(crudDemo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<CrudDemo>> delete(@PathVariable("id") Long id) {
        try {
            CrudDemo crudDemo = crudDemoRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND,
                            "crud_demo id is not found with id = " + id));
            crudDemoRepository.delete(crudDemo);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            throw new NotFoundException(HttpStatus.NOT_FOUND,"crud_demo id is not found with id = " + id);
        }
    }

    @PostMapping("/")
    ResponseEntity<CrudDemo> create(@RequestBody CrudDemo crudDemo) {
        try {
            CrudDemo _crudDemo = crudDemoRepository.save(crudDemo);
            return new ResponseEntity<>(_crudDemo, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
