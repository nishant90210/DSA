package String;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class WordAnalyzer {
	public static void main(String args[]) throws IOException
	{
			String [] words;
            HashMap<String,Integer> hashMap = new HashMap<>();
			FileReader fr = new FileReader("/Users/b0095748/Desktop/count");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null){
				
				words = line.split("\\W+");
				for(int i =0 ; i< words.length;i++)
				{
					if(hashMap.containsKey(words[i]))
					{
						int count = hashMap.get(words[i]);
						count++;
						hashMap.put(words[i], count);
					}
					else
					{
						hashMap.put(words[i],1);
					}
				}
			}
			br.close();
			Iterator it = hashMap.entrySet().iterator();
			while(it.hasNext())
			{
				Entry pairs = (Entry)it.next();
				System.out.println("word: \""+pairs.getKey()+"\" , count: "+pairs.getValue());
				it.remove();
			}
//			for(Entry<String, Integer> en:hashMap.entrySet()){
//				String word = en.getKey();
//				int count = en.getValue();
//				System.out.println("word: \""+word+"\" count: "+count);
//			}			
		}
	}
	

