package com.capgemini.ribbon.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient
public interface DepartmentService {
}
