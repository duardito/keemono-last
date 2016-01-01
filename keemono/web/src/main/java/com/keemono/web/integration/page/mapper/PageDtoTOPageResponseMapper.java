package com.keemono.web.integration.page.mapper;

import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.mapper.CustomBaseMapper;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 01/01/2016.
 */
@Component
public class PageDtoTOPageResponseMapper extends CustomBaseMapper<PageDto, PageResponse> {
}
