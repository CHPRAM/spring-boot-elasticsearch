package com.journaldev.elasticsearch.dao;

import java.util.Map;
import java.util.UUID;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.elasticsearch.bean.Book;
import com.journaldev.elasticsearch.bean.ProductView;

@Repository
public class ProductViewDao {
	
	    private final String INDEX = "pvt";
	    private final String TYPE = "bhachp";
	    
	    private RestHighLevelClient restHighLevelClient;

	    private ObjectMapper objectMapper;

	    public ProductViewDao( ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
	        this.objectMapper = objectMapper;
	        this.restHighLevelClient = restHighLevelClient;
	    }
	    
	        public ProductView insertProductView(ProductView productView){
	        productView.setId(UUID.randomUUID().toString());
	        Map<String, Object> dataMap = objectMapper.convertValue(productView, Map.class);
	        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, productView.getId())
	                .source(dataMap);
	        try {
	            IndexResponse response = restHighLevelClient.index(indexRequest);
	        } catch(ElasticsearchException e) {
	            e.getDetailedMessage();
	        } catch (java.io.IOException ex){
	            ex.getLocalizedMessage();
	        }
	        return productView;
	    }


}
