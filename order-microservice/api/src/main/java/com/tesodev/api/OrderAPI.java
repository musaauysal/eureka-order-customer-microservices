package com.tesodev.api;



import com.tesodev.common.exception.ApiSuccess;
import com.tesodev.entity.Customer;
import com.tesodev.entity.Ordering;
import com.tesodev.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderAPI {

    @Autowired
    OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    /*
    * GET MAPPING
    * */
    @ApiOperation(value = "Sipariş Uygulaması Api")
    @GetMapping("/get-all")
    public ResponseEntity<?> retrieveAllOrder() {
        return new ResponseEntity<>(new ApiSuccess("Tüm Siparişler Getirildi",orderService.getAll()),HttpStatus.OK);
    }

    @GetMapping("/get-all/{orderingId}")
    public ResponseEntity<?> retrieveAllOrderById(@PathVariable("orderingId")Integer orderingId) {
        return new ResponseEntity<>(new ApiSuccess("Id'e Göre Bütün Siparişler Getirildi",orderService.getById(orderingId)),HttpStatus.OK);
    }

    @GetMapping("/get/{orderingId}")
    public ResponseEntity<?> retrieveOrderById(@PathVariable("orderingId")Integer orderingId) {
        return new ResponseEntity<>(new ApiSuccess("Id'e Göre Sipariş Getirildi", orderService.get(orderingId)),HttpStatus.OK);
    }


    /*
    * POST MAPPING
    * */

    @PostMapping("create")
    public ResponseEntity<?> createOrder(@RequestBody Ordering ordering){

        return new ResponseEntity<>(new ApiSuccess("Sipariş Kaydedildi", orderService.create(ordering)),HttpStatus.OK);

    }

    @PostMapping("update")
    public ResponseEntity<?> updateOrder(@RequestBody Ordering ordering){

        return new ResponseEntity<>(new ApiSuccess("Sipariş Güncellendi",orderService.update(ordering)),HttpStatus.OK);

    }

    /*
    * PUT MAPPING
    * */

    @DeleteMapping("/delete/{orderingId}")
    public ResponseEntity<?> delete(@PathVariable("orderingId")Integer orderingId){
        orderService.deleteOrder(orderingId);
        return new ResponseEntity<>(new ApiSuccess("Sipariş Silindi",null),HttpStatus.OK);

    }



}
