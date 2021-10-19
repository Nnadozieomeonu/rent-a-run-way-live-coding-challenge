/*
  Write a function that prints a count of how many times each word appears in a string, in descending order.
  String sentence = "Great dress. The dress fit guide was also great - the fit of the dress was as described.";
  printWordCount(sentence);
*/ 
import java.io.*;
import java.util.*;

class Solution {
  
  public static void main(String[] args) {
    //Assumption that sequence of words in the string is separated by space.
    String sentence = "Great dress. The dress fit guide was also great - the fit of the dress was as described.";
    List<String> words = new ArrayList<>();
    words = Arrays.asList(sentence.trim().split(" "));
    HashMap<String, Integer> dictionaryOfWordsAndCount = Solution.getDictionaryOfWords(words);
    Solution.printOccuranceOfWordsInDescendingOrder(dictionaryOfWordsAndCount);
  }  
  
  private static HashMap<String,Integer> getDictionaryOfWords(List<String> listOfWords){   
    HashMap<String,Integer> dictionaryOfWords = new HashMap<>();
    for(String word: listOfWords){
      word = Solution.cleanUpWord(word);
      if(dictionaryOfWords.containsKey(word)){
        Integer occuranceOfWord = dictionaryOfWords.get(word);
        occuranceOfWord+=1;
        dictionaryOfWords.put(word,occuranceOfWord);
      }else{
        dictionaryOfWords.put(word,1);
      }    
    }
    return dictionaryOfWords;
    
  }
  
  private static void printOccuranceOfWordsInDescendingOrder(HashMap<String,Integer> dictionaryOfWords){
    LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
    dictionaryOfWords.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
    Iterator<Map.Entry<String,Integer>> iterator =   reverseSortedMap.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String,Integer> word = iterator.next();
      System.out.println(word.getKey()+" is Repeated "+word.getValue()+" times");
    } 
  }       
        
  private static String cleanUpWord(String word){
    if(word.contains(".")){
      word = ""; //clean up full stop
    }
    if(word.contains("-")){
      word = ""; //clean up hyphen stop
    }
    return word; 
  }
    
  
}
