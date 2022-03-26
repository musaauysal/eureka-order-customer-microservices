package com.tesodev.api;



import com.tesodev.common.exception.ApiSuccess;
import com.tesodev.entity.Customer;
import com.tesodev.service.CustomerService;
import lombok.RequiredArgsConstructor;


import org.apache.commons.collections4.Get;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
     CustomerService customerService;
    @Autowired
    private RestTemplate restTemplate;
    /*
    * GET MAPPING
    * */
    @GetMapping("/get-all")
    public ResponseEntity<?> retrieveAllCustomer() {
        return new ResponseEntity<>(new ApiSuccess("Tüm Müşteriler Listelendi",customerService.getAll()),HttpStatus.OK);
    }

    @GetMapping("/get-all/{customerId}")
    public ResponseEntity<?> retrieveAllCustomerById(@PathVariable("customerId")Integer customerId) {
        return new ResponseEntity<>(new ApiSuccess("Id Göre Tüm Müşteri Listesi",customerService.getById(customerId)),HttpStatus.OK) ;

    }

    @GetMapping("/get/{customerId}")
    public ResponseEntity<?> retrieveCustomerById(@PathVariable("customerId")Integer customerId) {
        return new ResponseEntity<>(new ApiSuccess("Id Ye Göre bir Müşteri ",customerService.get(customerId)),HttpStatus.OK);
    }


    /*
    * POST MAPPING
    * */

    @PostMapping("create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(new ApiSuccess("Müşteri Kaydedildi",customerService.create(customer)),HttpStatus.OK);

    }

    @PostMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){

       return new ResponseEntity<> (new ApiSuccess("Müşteri Güncellendi",customerService.update(customer)),HttpStatus.OK);

    }

    /*
    * DELETE MAPPING
    * */

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> delete(@PathVariable("customerId")Integer customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(new ApiSuccess("Müşteri Silindi",null),HttpStatus.OK);

    }


}
