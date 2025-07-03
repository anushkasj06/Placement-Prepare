import java.util.*;

public class Word_Ladder_II {

    String b;
    HashMap<String, Integer> mp;
    List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        int len = beginWord.length();
        if (!wordSet.contains(endWord)) {
            return Collections.emptyList();
        }
        for (String word : wordList) {
            wordSet.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        b = beginWord;
        queue.add(beginWord);
        mp = new HashMap<>();
        mp.put(beginWord, 1);
        int size  = beginWord.length();
        wordSet.remove(beginWord);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals(endWord)) {
                break;
            }
            for (int i = 0; i < size; i++) {
                char[] ch = s.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String newWord = new String(ch);
                    if (wordSet.contains(newWord)) {
                        if (!mp.containsKey(newWord)) {
                            mp.put(newWord, mp.get(s) + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
            ans = new ArrayList<>();
            if(mp.containsKey(beginWord)==true) {
                List<String> temp = new ArrayList<>();
                temp.add(beginWord);
                dfs(endWord, temp);
            }

        }
        return ans;
    }

    private void dfs(String word, List<String> path) {
        if (word.equals(b)) {
            Collections.reverse(path);
            ans.add(new ArrayList<>(path));
            Collections.reverse(path);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            char[] ch = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                ch[i] = c;
                String newWord = new String(ch);
                if (mp.containsKey(newWord) && mp.get(newWord) == mp.get(word) - 1) {
                    path.add(newWord);
                    dfs(newWord, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
