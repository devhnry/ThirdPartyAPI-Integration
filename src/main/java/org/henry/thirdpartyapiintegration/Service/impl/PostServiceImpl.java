package org.henry.thirdpartyapiintegration.Service.impl;

import org.henry.thirdpartyapiintegration.Service.PostService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    String baseUrl = "https://jsonplaceholder.typicode.com/";
    String POST = "/posts";
    String POSTBYID = "/posts/";

    private RestTemplate restTemplate;

    public PostServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Map<String, Object>> getPosts(){
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());

        String url = baseUrl + POST;
        var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id){
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = baseUrl + POSTBYID + id;
        var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);

        return response.getBody();
    }

    private static HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Override
    public Map<String, Object> insertPost(Map<String, Object> post) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(post, getHttpHeaders());
        String url = baseUrl + POST;
        var response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        return response.getBody();
    }

    @Override
    public Map<String, Object> updatePost(Map<String, Object> payload, int id) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
        String url = baseUrl + POSTBYID + id;
        var response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Map.class);

        return response.getBody();
    }

    @Override
    public String deletePost(int id){
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = baseUrl + POSTBYID + id;
        System.out.println(url);
        restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Map.class);

        return "Post has been deleted";
    }
}
