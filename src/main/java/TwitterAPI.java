import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.signature.TwitterCredentials;

public class TwitterAPI {
    private TwitterClient twitterClient;

    public TwitterAPI(){
        this.twitterClient = initWeatherBot();
    }

    private TwitterClient initWeatherBot(){
        TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder()
                .accessToken("ACCESS_TOKEN")
                .accessTokenSecret("ACCESS_TOKEN_SECRET")
                .apiKey("API_KEY")
                .apiSecretKey("API_KEY_SECRET")
                .build());
        return twitterClient;
    }

    public void postTweet(String text){
        this.twitterClient.postTweet(text);
    }
}
