package com.panda.animeStore.controller;

import com.panda.animeStore.entity.Admin;
import com.panda.animeStore.entity.VO.AdminVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.service.AdminService;
import com.panda.animeStore.util.MD5crypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panda
 * @date 2019-03-22 19:30
 */
@RestController
@Api(value = "AdminApi", description = "管理员相关接口")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "管理员登陆", notes = "登陆成功后返回Token")
    @PostMapping("/admins/login")
    public AdminVO adminLogin(@RequestBody Admin admin) throws Exception {
        if(StringUtils.isEmpty(admin.getAdminName())||StringUtils.isEmpty(admin.getPassword())){
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
        return adminService.validateLogin(admin.getAdminName(), MD5crypt.getMD5Str(admin.getPassword()));
    }


}
