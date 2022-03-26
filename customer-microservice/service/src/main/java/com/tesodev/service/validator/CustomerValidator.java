package com.tesodev.service.validator;

import com.tesodev.common.exception.ErrorMessageUtil;
import com.tesodev.common.exception.MetaMessageUtil;
import com.tesodev.entity.Customer;
import com.tesodev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerValidator {

    @Autowired
    CustomerService customerService;

    private MetaMessageUtil metaMessageUtil = new MetaMessageUtil();

    public void validateSaveForStopCauseDatabase(Customer customer) {

        metaMessageUtil = new MetaMessageUtil();
        //if save
        if (customer.getCustomerId() == null) {
            Customer tmpCustomer = customerService.retrieveCustomerByCustomerName(customer.getCustomerName());
            if (tmpCustomer != null) {
                metaMessageUtil.addMetaMessageWarning("Kaydedilmeye çalışılan müşterinin(" + customer.getCustomerName() + ")olan müşteri adı benzersiz olmalıdır.");
            }
        }
        // ıf update
        else {
            Customer customerForCustomerName = customerService.retrieveCustomerByCustomerName(customer.getCustomerName());
            if (customerForCustomerName != null) {
                if (!Objects.equals(customer.getCustomerName(), customerForCustomerName.getCustomerName())) {
                    metaMessageUtil.addMetaMessageWarning("Kaydedilmeye çalışılan müşterinin(" + customer.getCustomerName() + ")olan müşteri adı benzersiz olmalıdır");
                }
            }
        }
        ErrorMessageUtil.checkBusinessException(metaMessageUtil);

    }

}
