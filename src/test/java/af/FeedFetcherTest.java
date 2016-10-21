package af;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FeedFetcherTest {
    @Test
    public void differentMessagesShouldReturnRightStatusString() {
        FeedFetcher feedFetcher = new FeedFetcher("url");
        assertThat(feedFetcher.extractStatus("Elin - daily build #140 (stable)"), is("stable"));
        assertThat(feedFetcher.extractStatus("Elin - daily build #138 (back to normal)"), is("back to normal"));
        assertThat(feedFetcher.extractStatus("Elin - daily build #137 (1 test is still failing)"), is("1 test is still failing"));
        assertThat(feedFetcher.extractStatus("Elin - daily build #136 (1 test failure)"), is("1 test failure"));
        assertThat(feedFetcher.extractStatus("Elin - daily build #135 (broken since build #133)"), is("broken since build #133"));
        assertThat(feedFetcher.extractStatus("Elin - daily build #133 (broken since this build)"), is("broken since this build"));
    }

}