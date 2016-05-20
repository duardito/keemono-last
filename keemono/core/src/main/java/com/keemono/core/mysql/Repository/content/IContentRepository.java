package com.keemono.core.mysql.Repository.content;

import com.keemono.core.mysql.domain.content.Content;

/**
 * Created by edu on 20/05/2016.
 */
public interface IContentRepository {
    Content update(Content layout);

    Content save(Content content);

    Content findUUID(String uuid);
}
