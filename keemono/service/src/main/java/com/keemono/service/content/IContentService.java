package com.keemono.service.content;

import com.keemono.core.mysql.domain.content.Content;

import java.util.List;

/**
 * Created by edu on 21/05/2016.
 */
public interface IContentService {

    Content createContent(Content content);

    List<Content> getAllContentByOwner();
}
