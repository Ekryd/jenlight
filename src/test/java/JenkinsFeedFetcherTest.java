import af.*;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ekrbj on 2014-06-17.
 */
public class JenkinsFeedFetcherTest {
    @Test
    public void getStatusFromFeed() {
        FeedFetcher feedFetcher = new FeedFetcher("http://l7700676.ws.ams.se:8080/job/Diariet/job/Diariet_CommitStage/rssAll");
        assertThat(feedFetcher.getStatus(), is(Status.OK));
    }

}
