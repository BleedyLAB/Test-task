package com.Bleedy.Instrument;

import com.Bleedy.Application;
import com.Bleedy.Structure.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
class TransportManagerTest {


    @Test
    void testSentWeaver() {

        Response response = new Response("hi",
                ZonedDateTime.now().format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'h:m:ssZ")),
                15);

        TransportManager transportManager = new TransportManager();
        Assert.assertNotNull(transportManager.sentWeaver(response));
    }
}