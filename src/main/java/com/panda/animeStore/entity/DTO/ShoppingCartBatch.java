package com.panda.animeStore.entity.DTO;

import com.panda.animeStore.entity.VO.ShoppingCartVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-04 23:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartBatch {
    private List<ShoppingCartVO> shoppingCartVOList;
}
