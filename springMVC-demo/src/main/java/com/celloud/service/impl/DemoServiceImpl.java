package com.celloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.celloud.service.DemoService;
@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Override
	public List<String> findAll() {
		return new ArrayList<String>();
	}

}
