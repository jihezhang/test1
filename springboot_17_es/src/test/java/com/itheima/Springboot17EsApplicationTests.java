package com.itheima;

import com.alibaba.fastjson.JSON;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot17EsApplicationTests {

    @Autowired
    private BookDao bookDao;

    private RestHighLevelClient restHighLevelClient;

    @BeforeEach
    void setUp() {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        restHighLevelClient = new RestHighLevelClient(builder);
    }

    @Test
    void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateIndices() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        request.source(json, XContentType.JSON);
        restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    //单个查询
    @Test
    void testCreateIndexByID() throws IOException {
        Book book = bookDao.selectById(1);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    //批量插入
    @Test
    void testCreateIndexAll() throws IOException {
        BulkRequest bulk = new BulkRequest();
        List<Book> bookList = bookDao.selectList(null);
        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json,XContentType.JSON);
            bulk.add(request);
        }
        restHighLevelClient.bulk(bulk, RequestOptions.DEFAULT);
    }

    //按id查询
    @Test
    void testGet() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse res = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        String source = res.getSourceAsString();
        System.out.println(source);
    }

    //按条件查询
    @Test
    void testSearch() throws IOException {

        SearchRequest request = new SearchRequest("books");//2
        SearchSourceBuilder builder = new SearchSourceBuilder();//4
        builder.query(QueryBuilders.termQuery("name", "spring"));//5
        request.source(builder);//3
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);//1
        SearchHits hits = response.getHits();//6
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Book book = JSON.parseObject(sourceAsString, Book.class);
            System.out.println(book);
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        restHighLevelClient.close();
    }
}
