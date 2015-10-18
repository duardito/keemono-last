package com.keemono.layout;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.service.layout.ILayoutService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by edu on 17/10/2015.
 */
public class MyTest extends LayoutITCase {

    @Autowired
    private ILayoutService layoutService;

    @Test
    public void initTest() {
        List<LayoutDto> lista = layoutService.getAllLayoutList();
        Assert.assertEquals(2,lista.size());
    }

}
