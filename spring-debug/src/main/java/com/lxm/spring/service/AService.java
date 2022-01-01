package com.lxm.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("aService")
public class AService {
	@Autowired
	private BService bService;
}
