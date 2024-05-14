package cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.services.FruitService;
import cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.domain.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController{

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.add(fruit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> update(@RequestBody Fruit fruit) {
        Fruit modifiedFruit = fruitService.update(fruit);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        fruitService.delete(id);
        return ResponseEntity.ok("Fruit with id " + id + " deleted");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable("id") int id) {
        Fruit fruit = fruitService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(fruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll() {
        List<Fruit> allFruits = fruitService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(allFruits);
    }
}
