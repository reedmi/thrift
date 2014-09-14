package com.reedmi.enjoy.thrift;

import org.apache.thrift.TException;

public class AdditionServiceHandler implements AdditionService.Iface {

	@Override
	public int add(int n1, int n2) throws TException {
	    System.out.println("receive n1:" + n1 +",n2:" + n2);
		return n1 + n2;
	}

}