package com.revature.services;

import java.util.List;
import java.util.Map;
import org.springframework.validation.BindingResult;

/**
 *
 * @author May Love
 */
public interface ValidationService {
    Map<String, List<String>> validate(BindingResult result);
}
