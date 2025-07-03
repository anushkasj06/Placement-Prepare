import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Word_Ladder_I {
    class Pair{
        String first;
        int second;
        Pair(String f, int s){
            first = f;
            second = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        int len = wordList.size();
        for(int i=0;i<len;i++){
            wordSet.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        if(!wordSet.contains(endWord)){
            return 0; // If endWord is not in the wordList, return 0
        }
        wordSet.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int level = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return level;
            }
            for(int i=0;i<word.length();i++){
                char[] chars = word.toCharArray();
                for(char c='a';c<='z';c++){
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(wordSet.contains(newWord)){
                        q.add(new Pair(newWord, level+1));
                        wordSet.remove(newWord); // Avoid cycles
                    }
                }
            }
        }
        return 0; // If no transformation sequence found
    }
}
