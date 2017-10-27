package com.asmith.right.rate.wikipedia.table.parser.impl;

import com.asmith.wikipedia.parser.api.TableParser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author asmith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContainerConfig.class})
@Ignore
public class PS4GameTableParserTest {

    @Autowired
    @Qualifier("ps4GameTableParser")
    TableParser instance;

    @Test
    public void testParseTables() {
        instance.parseTables();
    }

}
