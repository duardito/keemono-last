package com.keemono.core.solr.repository.layout;

import com.keemono.core.solr.domain.layout.Layout;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by edu on 31/05/2015.
 */
public interface LayoutSolrRepository extends SolrCrudRepository<Layout, String> {
}
