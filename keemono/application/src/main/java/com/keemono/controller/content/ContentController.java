package com.keemono.controller.content;

import com.keemono.common.Constants;
import com.keemono.common.converter.request.content.ContentCreateRequest;
import com.keemono.common.converter.response.Content.ContentResponse;
import com.keemono.common.converter.response.Content.ListContentResponse;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.common.ordination.OrdinationRequest;
import com.keemono.common.pagination.PaginationRequest;
import com.keemono.core.mysql.domain.content.Content;
import com.keemono.service.content.IContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by edu on 21/05/2016.
 */
@PreAuthorize("@securityService.hasProtectedAccess()")
@Api(value = "/content", description = "Operations to do about content")
@RequestMapping(value = Constants._CONTENT_URL)
@RestController
public class ContentController extends BaseMapper {

    @Autowired
    private IContentService contentService;

    @ApiOperation(value = "create a content", notes = "create a content", response = ContentResponse.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = Constants._APPLICATION_JSON, consumes = Constants._APPLICATION_JSON)
    public ContentResponse createContent(@ApiParam(value = "basic data to create content", required = true)
                                         @RequestBody @Valid final ContentCreateRequest contentCreateRequest) throws Exception {

        Content content = mapper.map(contentCreateRequest, Content.class);
        content = contentService.createContent(content);
        return mapper.map(content, ContentResponse.class);
    }

    @ApiOperation(value = "get all content by user", notes = "get all content list", response = ListContentResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._LIST, method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public ListContentResponse getContent(@ModelAttribute @Valid final PaginationRequest paginationRequest,
                                          @Valid final OrdinationRequest ordinationRequest) {

        List<Content> contents = contentService.getAllContentByOwner();

        final ListContentResponse lista = new ListContentResponse();
        List<ContentResponse> out = mapper.mapAsList(contents, ContentResponse.class);
        lista.addAll(out);
        return lista;
    }

}
