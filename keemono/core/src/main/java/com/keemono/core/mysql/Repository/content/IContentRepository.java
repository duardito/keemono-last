package com.keemono.core.mysql.Repository.content;

import com.keemono.core.mysql.domain.content.Content;
import com.keemono.core.mysql.domain.user.User;

import java.util.List;

/**
 * Created by edu on 20/05/2016.
 */
public interface IContentRepository {
    List<Content> findAllByCreator(User owner);

    Content update(Content layout);

    Content save(Content content);

    Content findUUID(String uuid);
}
