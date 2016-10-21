package af;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FetcherException;
import com.sun.syndication.fetcher.impl.*;
import com.sun.syndication.io.FeedException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ekrbj on 2014-06-17.
 */
public class FeedFetcher {
    private final String url;
    private URL feedUrl;
    private final FeedFetcherCache feedInfoCache;
    private HttpURLFeedFetcher feedFetcher;

    public FeedFetcher(String url) {
        this.url = url;
        feedInfoCache = HashMapFeedInfoCache.getInstance();
        feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
    }

    private String retrieveLatestEntryInFeed() throws IOException, FetcherException, FeedException {
        SyndFeed feed = feedFetcher.retrieveFeed(new URL(url));
        SyndEntry o = (SyndEntry) feed.getEntries().get(0);
        return o.getTitle();
    }

    public Status getStatus() {
        try {
            String title = retrieveLatestEntryInFeed();
            String statusString = extractStatus(title);
            return Status.getStatus(statusString);
        } catch (Exception e) {
            System.err.println("Could not retrieve RSS from " + url);
            e.printStackTrace();
            return Status.FAIL;
        }
    }

    String extractStatus(String title) {
        return title.replaceAll("^.*\\((.*)\\)$", "$1");
    }
}
