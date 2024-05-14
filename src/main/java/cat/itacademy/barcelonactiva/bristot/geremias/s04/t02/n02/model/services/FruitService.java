package cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.exceptions.FruitAlreadyExistException;
import cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.domain.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit add(Fruit fruit){
        for (Fruit existingFruit : fruitRepository.findAll()) {
            if (existingFruit.getName().equalsIgnoreCase(fruit.getName())) {
                throw new FruitAlreadyExistException("Cannot add " + fruit.getName() + " for it already exists");
            }
        }
        return fruitRepository.save(fruit);
    }

    public Fruit update(Fruit fruit){
        Optional<Fruit> oldFruit = fruitRepository.findById(fruit.getId());
        if(oldFruit.isPresent()) {
            Fruit newFruit = oldFruit.get();
            newFruit.setName(fruit.getName());
            newFruit.setQuantityKilos(fruit.getQuantityKilos());
            return fruitRepository.save(newFruit);
        } else {
            throw new FruitNotFoundException("Fruit with Id " + fruit.getId() + " not found");
        }
    }

    public void delete(int id){
        Fruit fruitFound = fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with Id " + id + " not found"));
        fruitRepository.deleteById(fruitFound.getId());
    }

    public Fruit getOne(int id){
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with Id " + id + " not found"));
    }

    public List<Fruit> getAll(){
        return fruitRepository.findAll();    }
}
