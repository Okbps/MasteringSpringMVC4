package masterSpringMvc.search.api;

import masterSpringMvc.search.LightTweet;
import masterSpringMvc.search.SearchService;
import masterSpringMvc.search.TwitterSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Aspire on 31.03.2017.
 */
@RestController
@RequestMapping("/api/search")
public class SearchApiController implements TwitterSearch{
    private SearchService searchService;
    @Autowired
    public SearchApiController(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    @RequestMapping(value = "/{searchType}", method = RequestMethod.GET)
    public List<LightTweet> search(@PathVariable String searchType, @MatrixVariable List<String> keywords) {
        return searchService.search(searchType, keywords);
    }
}
