package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("*************插入结果"+i);
        if(i > 0){
            return new CommonResult(200,"插入数据成功！serverPort:"+serverPort,i);
        }else {
            return new CommonResult(444,"插入数据失败！",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("****************查询数据结果"+paymentById);

        if(paymentById != null){
            return new CommonResult(200,"查询数据成功！serverPort:"+serverPort,paymentById);
        }else {
            return new CommonResult(444,"查询数据失败！",null);
        }

    }

    @GetMapping(value = "payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
