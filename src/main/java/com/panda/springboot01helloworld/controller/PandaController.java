package com.panda.springboot01helloworld.controller;

import com.panda.springboot01helloworld.entity.Panda;
import com.panda.springboot01helloworld.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panda
 * @date 2018-12-02 13:31
 */
@RestController
public class PandaController {
    @Autowired
    private PandaService pandaService;

    @GetMapping("/pandas")
    public List<Panda> getPandaList() {
        List<Panda> pandaList= pandaService.getPandaList();
        pandaList.forEach(panda -> System.out.println("panda = " + panda));
        return pandaList;
    }

    @GetMapping("/panda")
    public Panda getPandaById(Integer id){
        Panda panda=pandaService.getPandaById(id);
        return  panda;
    }
}
