package unit;

import com.zsenyuk.bbqtime.controller.BBQTimeController;
import com.zsenyuk.bbqtime.model.DoBBQ;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(BBQTimeController.class)
public class BBQControllerTest {

    @Autowired
    private BBQTimeController bbqTimeController;

    @Test
    public void goodTemperatureHighPrecipitation()
            throws Exception {
        DoBBQ res = bbqTimeController.calculateDecision(20, 2);
        Assert.assertFalse(res.isDoBBQ());
    }

    @Test
    public void goodTemperatureGoodPrecipitation()
            throws Exception {
        DoBBQ res = bbqTimeController.calculateDecision(20, 1.9);
        Assert.assertTrue(res.isDoBBQ());
    }

    @Test
    public void lowTemperatureGoodPrecipitation()
            throws Exception {
        DoBBQ res = bbqTimeController.calculateDecision(19.9, 1.9);
        Assert.assertFalse(res.isDoBBQ());
    }

    @Test
    public void negativeTemperatureGoodPrecipitation()
            throws Exception {
        DoBBQ res = bbqTimeController.calculateDecision(-19.9, 1.9);
        Assert.assertFalse(res.isDoBBQ());
    }

}

