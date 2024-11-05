package com.ucamp.jpa.controller;

import com.ucamp.jpa.dto.req.CustomerReqDto;
import com.ucamp.jpa.dto.res.CustomerRespDto;
import com.ucamp.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    // 전체 고객 찾기
    @GetMapping()
    public ResponseEntity<?> fetchCustomers() {
        return ResponseEntity.ok(customerService.fetchCustomers());
    }

    // ID로 고객 찾기
    @GetMapping("/{id}")
    public CustomerRespDto fetchCustomer(@PathVariable Long id) {
        return customerService.fetchCustomer(id);
    }

    // Email 로 고객 찾기
    @GetMapping("/{email}")
    public CustomerRespDto fetchCustomerByEmail(@PathVariable String email) {
        return customerService.fetchCustomerByEmail(email);
    }

    // 고객 추가
    @PostMapping()
    public ResponseEntity<?> makeCustomer(@RequestBody CustomerReqDto customerReqDto) {
        return ResponseEntity.ok(customerService.makeCustomer(customerReqDto));
    }

    // 고객 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCustomer(@PathVariable Long id) {
        customerService.removeCustomer(id);
        return ResponseEntity.ok(id + " Customer가 삭제처리 되었습니다.");
    }

    // 고객 변경
    @PatchMapping("/{email}")
    public ResponseEntity<?> changeCustomer(@PathVariable String email,
                                            @RequestBody CustomerReqDto customerReqDto) {
        return ResponseEntity.ok(customerService.changeCustomer(email, customerReqDto));
    }


}
