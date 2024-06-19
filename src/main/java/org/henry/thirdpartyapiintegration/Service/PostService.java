package org.henry.thirdpartyapiintegration.Service;

import java.util.Map;
import java.util.List;

public interface PostService {
    List<Map<String, Object>> getPosts();
    Map<String, Object> getPostById(int id);
    Map<String, Object> insertPost(Map<String, Object> post);
    Map<String, Object> updatePost(Map<String, Object> payload, int id);
    String deletePost(int id);
}
