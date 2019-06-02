package com.sunnie.controller;


import com.sunnie.pojo.common.DataTablesResult;
import com.sunnie.pojo.common.Result;
import com.sunnie.service.ThanksService;
import com.sunnie.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunnie
 */
@RestController
@Api(description = "捐赠列表")
public class ThanksFrontController {

    private final static Logger log= LoggerFactory.getLogger(ThanksFrontController.class);

    @Autowired
    private ThanksService thanksService;

    @RequestMapping(value = "/member/thanks",method = RequestMethod.GET)
    @ApiOperation(value = "捐赠列表")
    public Result<DataTablesResult> getThanksList(@RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "10") int size){

        DataTablesResult result=thanksService.getThanksListByPage(page,size);
        return new ResultUtil<DataTablesResult>().setData(result);
    }
}
