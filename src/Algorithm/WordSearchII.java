package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        String[] words = new String[]{"oath","eat"};
        findWords(board, words);

        board = new char[][]{{'a','b'}};

        words = new String[]{"ba"};
        findWords(board, words);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        TrieNode p =  buildTrie(words);
        for(int i =0;i < board.length;i++){
            for(int j =0; j< board[0].length;j++){
                for(String s : words){
                    if(s.charAt(0)==board[i][j]){
                        //possible match
                        helper(board, i, j, s,0, res , visited,p);

                    }
                }
            }
        }
        return res;
    }

    public static boolean helper(char[][] board, int i , int j, String word, int wordIdx,  List<String> res, boolean visited[][], TrieNode p){


        if(i<0|| i>=board.length|| j<0 || j>=board[0].length || visited[i][j]){
            return false;
        }

        if(p.next[board[i][j]-'a']==null) //cant find the word
            return false;

        p = p.next[board[i][j]-'a'];
        if( p.word != null){//find the word
            res.add(p.word);
            p.word=null;//remove from trie , de-duplicate
        }

//        if(wordIdx==word.length( )-1 && word.charAt(wordIdx) == board[i][j]){
//            res.add(word);
//            return true;
//        }


//        if(word.charAt(wordIdx) != board[i][j]){
//            return false;
//        }
        visited[i][j]=true;
        helper(board, i-1, j, word, wordIdx+1,  res,visited, p);
        helper(board, i+1, j, word, wordIdx+1,  res,visited,p);
        helper(board, i, j-1, word, wordIdx+1,  res, visited,p);
        helper(board, i, j+1, word, wordIdx+1,  res, visited,p);
        visited[i][j]=false;

         return false;

    }

    public static TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word:words){
            TrieNode p  = root;
            for(char c: word.toCharArray()){
                int id = c-'a';
                if( p.next[id]==null  )
                    p.next[id] = new TrieNode();
                p = p.next[id];
            }
            p.word =  word;
        }
        return root;

    }

    static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }


 }
