package af;

/**
 * Created by ekrbj on 2014-06-17.
 */
public class Main {

    public static String URL;

    public static void main(String[] args) throws InterruptedException {
        URL = args[0];
        FeedFetcher feedFetcher = new FeedFetcher(URL);
        //FeedFetcher feedFetcher = new FeedFetcher("http://w7700722:8080/job/Elin%20-%20daily%20build/rssAll");
        //FeedFetcher feedFetcher = new FeedFetcher("https://jenkins-master1.ws.ams.se/job/Elin_CommitStage_fromtemplate_SNAPSHOT/rssAll");
        Outlet outlet = new Outlet("Kontakt1");

        Status oldStatus = null;

        while (true) {
            Status status = feedFetcher.getStatus();
            if (status != oldStatus) {
                oldStatus = status;
                switch (status) {
                    case ABORTED:
                        // Do nothing
                        break;
                    case OK:
                        outlet.turnOff();
                        break;
                    case FAIL:
                        outlet.turnOn();
                        break;
                }
            }
            System.out.print(".");
            Thread.sleep(20000);
        }
    }
}
