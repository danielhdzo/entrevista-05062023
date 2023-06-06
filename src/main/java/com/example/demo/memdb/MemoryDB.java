package com.example.demo.memdb;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.Account;

public class MemoryDB {
	
	private MemoryDB() {
		super();
	}

	public static Map<Long, Account> mapDataAccount = new HashMap<Long, Account>();

}
