package com.example.Cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    public List<Emp> lst=new ArrayList<Emp>(Arrays.asList(
            new Emp(1,"java","1000"),new Emp(2,"php","1000"),new Emp(3,"dot","1000")
    ));

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @Cacheable(value = "myemp", key="#id")
    public Emp getId(@PathVariable int id){
        System.out.println("1 st hit getId");
        return lst.get(id);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @CachePut(value = "myemp", key="#id")
    public void update(@PathVariable int id,@RequestBody Emp emp){
        System.out.println("1 st hit update");
        lst.add(emp);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @CacheEvict(value = "myemp", key="#id")
    public void delete(@PathVariable int id){
        System.out.println("1 st hit delete");
        lst.removeIf(e->e.id==id);
    }

}
