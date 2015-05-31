package com.keemono.core.solr.repository.user;

import com.keemono.core.mysql.domain.user.User;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by edu on 30/05/2015.
 */
public interface UserSolrRepository  extends SolrCrudRepository<User, Long> {
}
