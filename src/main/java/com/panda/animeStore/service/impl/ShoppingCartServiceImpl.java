package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.ShoppingCartVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.ShoppingCartMapper;
import com.panda.animeStore.service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-20 12:31
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public ShoppingCart getShoppingCartById(Integer id) {
        return shoppingCartMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShoppingCartVO> getShoppingCartVOListByUserId(Integer userId) {
        return shoppingCartMapper.selectVOByUserId(userId);
    }

    @Override
    public boolean addShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart oldShoppingCart  =shoppingCartMapper.selectByProductId(shoppingCart.getProductId());
        if (oldShoppingCart==null){
            int result = shoppingCartMapper.insertSelective(shoppingCart);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        }else {
            //旧数量总价加上新数量总价
            oldShoppingCart.setProductAmount(oldShoppingCart.getProductAmount()+shoppingCart.getProductAmount());
            oldShoppingCart.setPriceSum(oldShoppingCart.getPriceSum().add(shoppingCart.getPriceSum()));
            int result = shoppingCartMapper.updateByPrimaryKeySelective(oldShoppingCart);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        }
    }

    @Override
    public boolean updateShoppingCartById(Integer id, ShoppingCart shoppingCart) {
        if (id != null) {
            shoppingCart.setId(id);
            int result = shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean updateShoppingCartBatch(List<ShoppingCartVO> shoppingCartVOList) {
        for(ShoppingCartVO shoppingCartVO:shoppingCartVOList){
            ShoppingCart shoppingCart=convertFromShoppingCartVO(shoppingCartVO);
            if(!updateShoppingCartById(shoppingCart.getId(),shoppingCart)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean deleteShoppingCartById(Integer id) {
        if (id != null) {
            int result = shoppingCartMapper.deleteByPrimaryKey(id);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }
    private ShoppingCart convertFromShoppingCartVO(ShoppingCartVO shoppingCartVO){
        if(shoppingCartVO == null)
        {
            return null;
        }
        ShoppingCart shoppingCart=new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartVO,shoppingCart);
        return shoppingCart;
    }
}
