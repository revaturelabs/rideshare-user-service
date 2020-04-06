package com.revature.services.impl;

import com.revature.services.ValidationService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 *
 * @author May Love
 */

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public Map<String, List<String>> validate(BindingResult result) {
            // Uses a list to retain insertion order of multiple errors
            Map<String, List<String>> errors = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()){
                List<String> fieldErrorList = errors.computeIfAbsent(fieldError.getField(),
                        x -> new ArrayList<String>());
                // Prioritizes blank fields by putting them at the front of the list
                // when there are multiple errors, since the validator checks
                // constraints in a random order, but the implementation of the
                // client-side application may not necessarily display more than one
                if ("NotBlank".equals(fieldError.getCode())) fieldErrorList.add(0,
                        fieldError.getDefaultMessage());
                else fieldErrorList.add(fieldError.getDefaultMessage());
            }
            return errors;
    }
    
}
