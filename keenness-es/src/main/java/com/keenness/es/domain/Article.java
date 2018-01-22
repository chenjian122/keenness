package com.keenness.es.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author cj
 * @create 2018-01-22 13:50
 **/
@Data
@Document(indexName="projectname",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Article {

    private Long id;

    private String title;

    private String abstracts;

    private String content;

    private Date postTime;

    private Long clickCount;

    private Author author;

    private Tutorial tutorial;
}
