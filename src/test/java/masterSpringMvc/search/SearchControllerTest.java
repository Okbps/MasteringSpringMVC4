package masterSpringMvc.search;

import masterSpringMvc.MasterSpringMvcApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;

import static masterSpringMvc.utils.AuthUtil.basicAuth;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Aspire on 08.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = {
        MasterSpringMvcApplication.class,
        StubTwitterSearchConfig.class
})
public class SearchControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Autowired
    private FilterChainProxy springSecurityFilter;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilter(springSecurityFilter)
                .build();
    }

    @Test
    public void should_search() throws Exception {
        this.mockMvc.perform(get("/search/mixed;keywords=spring")
                .header("Authorization", basicAuth("admin", "admin"))
        )
                .andExpect(redirectedUrl("https://localhost/search/mixed;keywords=spring"))
                .andExpect(status().isFound());

//        TODO https /search test
//                .andExpect(status().isOk());
//                .andExpect(view().name("resultPage"))
//                .andExpect(model().attribute("tweets", hasSize(2)))
//                .andExpect(model().attribute("tweets",
//                        hasItems(
//                                hasProperty("text", is("tweetText")),
//                                hasPropertye("text", is("secondTweet"))
//                        ))
//                );
    }
}