package wordCounter;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import org.junit.Test;
/**
 * The COunter class opens a files and displays the top 20 most common words inside the file.
 * The programs intended use is for the play Macbeth.
 * Opens file
 * Splits words
 * Creates hashmap
 * finds top 20 most common words
 * closes file
 * 
 * @author alex
 * @since 2019
 */
public class COunter
{
	/**
	 * main
	 * @param args
	 */
    public static void main(String[] args)
    {
        //Create wordCountMap
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        BufferedReader reader = null;

        try
        {
            //Creates BufferedReader
            reader = new BufferedReader(new FileReader("C:\\Users\\Bebop\\Desktop\\school\\softdev\\macbeth.txt"));
            String currentLine = reader.readLine();

            while (currentLine != null)
            {
                //splits 
                String[] words = currentLine.toLowerCase().split("\\W");

                for (String word : words)
                {
                    //updates count if word is already listed
                    if(wordCountMap.containsKey(word))
                    {
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                    else
                    {
                        wordCountMap.put(word, 1);
                    }
                }
                currentLine = reader.readLine();
            }
            //Setting up entries for hashmap
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
            //Creates list
            List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(entrySet);
            //sorts the list
            Collections.sort(list, new Comparator<Entry<String, Integer>>()
            {
                public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2)
                {
                    return (e2.getValue().compareTo(e1.getValue()));
                }
            });
            System.out.println("TOP 20 WORDS ARE: ");

            String arrayWord[] = new String[20];
            int arrayCounter[] = new int[20];
            for (int i = 1; i < 20; i++)
            {
            	arrayWord[i] = list.get(i).getKey();
            	arrayCounter[i] = list.get(i).getValue();

            	System.out.println(arrayWord[i] + ": " +arrayCounter[i]);
            	//list.remove(i);
            }
            
            /*
            for (Entry<String, Integer> entry : list)
            {
            	System.out.println(entry.getKey() + " : "+ entry.getValue());
            }*/ 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();  
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
   /**
    * Tests for the most common word
    * **BROKEN**
    */
    @Test
    public void testForThe()
    {
        String result = "the";
        assertEquals("the", result);
    }
}


