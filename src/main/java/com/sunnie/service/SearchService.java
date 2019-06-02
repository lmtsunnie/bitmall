package com.sunnie.service;


import com.sunnie.pojo.common.SearchResult;

public interface SearchService {

	SearchResult search(String keyword, int page, int size, String sort, int priceGt, int priceLte);
}
