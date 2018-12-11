package com.panda.springboot01helloworld.service;

import com.panda.springboot01helloworld.entity.Panda;

import java.util.List;

/**
 * @author panda
 * @date 2018-12-10 1:30
 */
public interface PandaService {
    List<Panda> getPandaList();
    Panda getPandaById(Integer id);
    boolean addPanda(Panda panda);
    boolean updatePandaById(Panda panda);
    boolean deletePandaById(Integer id);
}
