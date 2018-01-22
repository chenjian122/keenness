package com.keenness.es.repository;

import com.keenness.es.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author cj
 * @create 2018-01-22 13:55
 **/
public interface ArticleSearchRepository extends ElasticsearchRepository<Article,Long> {

}
