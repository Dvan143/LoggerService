package org.dmitriyprojects.bankapploggingservice.db;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ElasticsearchRepository<LogDocument, Long> {

}
