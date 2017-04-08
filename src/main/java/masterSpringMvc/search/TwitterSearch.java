package masterSpringMvc.search;

import java.util.List;

/**
 * Created by Aspire on 08.04.2017.
 */
public interface TwitterSearch {
    List<LightTweet> search(String searchType, List<String> keywords);
}
