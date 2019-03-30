package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.ProductMapper;
import com.panda.animeStore.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author panda
 * @date 2019-01-15 10:09 AM
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductByCategoryId(Integer categoryId) {
        return productMapper.selectByCategoryId(categoryId);
    }

    @Override
    public List<Product> getProductByQuery(String query) {
        return productMapper.selectByQuery(query);
    }

    @Override
    public List<Product> getAllProduct() {
        return productMapper.selectAll();
    }

    @Override
    public boolean addProduct(Product product) {
        String url = request.getScheme() +"://" + request.getServerName()
                + ":" +request.getServerPort();
        product.setImg(url+product.getImg());
        int result = productMapper.insertSelective(product);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public String saveProductImg(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
            throw new RuntimeException(BusinessError.FILE_EMPTY.getErrMsg());
        }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            throw new RuntimeException(BusinessError.FILE_FORMAT_ERROR.getErrMsg());
        }
        String root_fileName = multipartFile.getOriginalFilename();
        log.info("上传图片:name={},type={}", root_fileName, contentType);
        String filePath = "/Users/panda/Documents/projects/mini-program/mini-program-server/src/main/resources/static";
        String fileName = "/Img/" +UUID.randomUUID().toString() + ".jpg";

        log.info("图片保存路径:{}", filePath+fileName);
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

    @Override
    public boolean updateProductById(Integer id, Product product) {
        if (id != null) {
            product.setId(id);
            int result = productMapper.updateByPrimaryKeySelective(product);
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
    public boolean deleteProductById(Integer id) {
        if (id != null) {
            int result = productMapper.deleteByPrimaryKey(id);
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
    public boolean handleAmount(Integer id, Integer amount) {
        if (id != null && amount > 0) {
            int result = productMapper.handleAmount(id, amount);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException((BusinessError.STOCK_ERROR.getErrMsg()));
            }
        }
        throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
    }
}
