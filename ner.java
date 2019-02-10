import java.io.FileInputStream; 
import java.io.InputStream;  
import opennlp.tools.namefind.*; 
//import namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.*; 
//import tokenize.TokenizerModel; 
import opennlp.tools.util.*; 

public class ner 
{  
   public static void main(String args[]) throws Exception
   {        
      InputStream inputStreamTokenizer = new FileInputStream("en-token.bin");
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); 
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
      String sentence = "Mike and Daniel are not Preity Zinta or Oscar Tango even though Charlie This That Aamir Dogra"; 
      String tokens[] = tokenizer.tokenize(sentence); 
      InputStream inputStreamNameFinder = new FileInputStream("en-ner-person.bin");       
      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
      NameFinderME nameFinder = new NameFinderME(model);       
      Span nameSpans[] = nameFinder.find(tokens);        
      for(Span s: nameSpans)        
         System.out.println(s.toString()+"  "+tokens[s.getStart()]);      
   }    
} 