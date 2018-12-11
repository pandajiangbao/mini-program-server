package com.panda.springboot01helloworld.service.impl;

import com.panda.springboot01helloworld.dao.PandaDao;
import com.panda.springboot01helloworld.entity.Panda;
import com.panda.springboot01helloworld.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author panda
 * @date 2018-12-10 1:33
 */
@Service
public class PandaServiceImpi implements PandaService {
    @Autowired
    private PandaDao pandaDao;
    @Override
    public List<Panda> getPandaList() {
        return pandaDao.selectAll();
    }

    @Override
    public Panda getPandaById(Integer id) {
        return pandaDao.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public boolean addPanda(Panda panda) {
        if (panda.getTitle()!=null&&!"".equals(panda.getTitle())){
            panda.setDate(new Date());
            try {
                int result =pandaDao.insert(panda);
                if (result>0){
                    return true;
                }else {
                    throw new RuntimeException("插入熊猫信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入熊猫信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("熊猫信息不能为空");
        }
    }

    @Override
    public boolean updatePandaById(Panda panda) {
        if (panda.getId()!=null&&panda.getId()>0){
            panda.setDate(new Date());
            try {
                int result =pandaDao.updateByPrimaryKey(panda);
                if (result>0){
                    return true;
                }else {
                    throw new RuntimeException("更新熊猫信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新熊猫信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("熊猫信息不能为空");
        }
    }

    @Override
    public boolean deletePandaById(Integer id) {
        if (id>0){
            try {
                int result =pandaDao.deleteByPrimaryKey(id);
                if (result>0){
                    return true;
                }else {
                    throw new RuntimeException("删除熊猫信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除熊猫信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("熊猫id不能为空");
        }
    }
}
