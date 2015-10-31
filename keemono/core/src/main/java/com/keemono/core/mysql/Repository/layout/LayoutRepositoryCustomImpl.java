package com.keemono.core.mysql.Repository.layout;

import com.keemono.core.mysql.domain.layout.Layout;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by edu on 31/10/2015.
 */
public class LayoutRepositoryCustomImpl implements LayoutRepositoryCustom{

    @Autowired
    private EntityManager entityManager;

    public Layout update(Layout layout){
        return entityManager.merge(layout);
    }

    @Override
    public Layout findByUUID(String uuid) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Layout> criteria = builder.createQuery(Layout.class);
        Root<Layout> root = criteria.from(Layout.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("uuid"),uuid));
        TypedQuery<Layout> query = entityManager.createQuery(criteria);

        List<Layout> queryResult = query.getResultList();

        Layout returnObject = null;

        if (CollectionUtils.isNotEmpty(queryResult)){
            returnObject = queryResult.get(0);
        }

        return returnObject;
    }

}
