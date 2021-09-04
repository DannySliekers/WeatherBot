import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.signature.TwitterCredentials;

public class TwitterAPI {
    private TwitterClient twitterClient;

<<<<<<< HEAD
    public TwitterAPI(){
        this.twitterClient = initWeatherBot();
    }

    private TwitterClient initWeatherBot(){
=======
    public TwitterAPI() {
        this.twitterClient = initWeatherBot();
    }

    private TwitterClient initWeatherBot() {
>>>>>>> master
        TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder()
                .accessToken("ACCESS_TOKEN")
                .accessTokenSecret("ACCESS_TOKEN_SECRET")
                .apiKey("API_KEY")
                .apiSecretKey("API_KEY_SECRET")
                .build());
        return twitterClient;
    }

<<<<<<< HEAD
    public void postTweet(String text){
=======
    public void postTweet(String text) {
>>>>>>> master
        this.twitterClient.postTweet(text);
    }
}
