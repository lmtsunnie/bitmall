package com.sunnie.controller;

import com.sunnie.common.jedis.JedisClient;
import com.sunnie.pojo.TbAddress;
import com.sunnie.pojo.common.Result;
import com.sunnie.service.AddressService;
import com.sunnie.utils.IPInfoUtil;
import com.sunnie.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(description = "收货地址")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "/member/addressList", method = RequestMethod.POST)
    @ApiOperation(value = "获得所有收货地址")
    public Result<List<TbAddress>> addressList(@RequestBody TbAddress tbAddress) {

        List<TbAddress> list = addressService.getAddressList(tbAddress.getUserId());
        return new ResultUtil<List<TbAddress>>().setData(list);
    }

    @RequestMapping(value = "/member/address", method = RequestMethod.POST)
    @ApiOperation(value = "通过id获得收货地址")
    public Result<TbAddress> address(@RequestBody TbAddress tbAddress) {

        TbAddress address = addressService.getAddress(tbAddress.getAddressId());
        return new ResultUtil<TbAddress>().setData(address);
    }

    @RequestMapping(value = "/member/addAddress", method = RequestMethod.POST)
    @ApiOperation(value = "添加收货地址")
    public Result<Object> addAddress(@RequestBody TbAddress tbAddress, HttpServletRequest request) {

        //防炸库验证
        String ip = IPInfoUtil.getIpAddr(request);
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        String redisKey = "addAddress_" + ip;
        String temp = jedisClient.get(redisKey);
        if (StringUtils.isNotBlank(temp)) {
            return new ResultUtil<Object>().setErrorMsg("您提交的太频繁啦，请10秒后再试");
        }

        int result = addressService.addAddress(tbAddress);

        //记录缓存
        jedisClient.set(redisKey, "ADDED");
        jedisClient.expire(redisKey, 10);
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/member/updateAddress", method = RequestMethod.POST)
    @ApiOperation(value = "编辑收货地址")
    public Result<Object> updateAddress(@RequestBody TbAddress tbAddress) {

        int result = addressService.updateAddress(tbAddress);
        return new ResultUtil<Object>().setData(result);
    }

    @RequestMapping(value = "/member/delAddress", method = RequestMethod.POST)
    @ApiOperation(value = "删除收货地址")
    public Result<Object> delAddress(@RequestBody TbAddress tbAddress) {

        int result = addressService.delAddress(tbAddress);
        return new ResultUtil<Object>().setData(result);
    }
}
