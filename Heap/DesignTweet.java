package Heap;

import java.util.*;

public class DesignTweet {
    public class Tweet{
        int userId;
        int tweetId;
        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    HashMap<Integer,Set<Integer>> followings;
    List<Tweet> tweets;

    public DesignTweet() {
        followings = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsTweetes(int userId){
        int n = this.tweets.size();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> follows = new HashSet<>();
        for(int i=n-1; i>=0; i--){
            if(ans.size() == 10) {
                return ans;
            }
            Tweet tweet = tweets.get(i);
            if(tweet.userId == userId || follows.contains(tweet.userId)){
                ans.add(tweet.tweetId);
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set;
        if(this.followings.containsKey(followerId)){
            set = this.followings.get(followerId);
        } else {
            set = new HashSet<>();
            this.followings.put(followerId, set);
        }
        set.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = this.followings.get(followerId);
        if(set!=null){
            set.remove(followeeId);
        }
    }

}
