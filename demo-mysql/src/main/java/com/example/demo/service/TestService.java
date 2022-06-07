package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Test;

@Service
public class TestService {	
	public int addition(Test test) {
		int res = test.getV1() + test.getV2();
		return res;
	}

	public int summation(int v1, int v2) {
		return v1+v2;
	}
}
