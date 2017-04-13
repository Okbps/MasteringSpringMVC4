package masterSpringMvc.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * Created by Aspire on 12.04.2017.
 */
@Service
public class CachedSearchService{
    private final AsyncSearch asyncSearch;

    @Autowired
    public CachedSearchService(AsyncSearch asyncSearch) {
        this.asyncSearch = asyncSearch;
    }

    public ListenableFuture<List<LightTweet>>search(String resultType, String keyword) {
        return asyncSearch.asyncFetch(resultType, keyword);
    }
}
