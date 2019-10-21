import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class COunter
{
    public static void main(String[] args)
    {
        //Creating wordCountMap which holds words as keys and their occurrences as values
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        BufferedReader reader = null;

        try
        {
            //Creating BufferedReader object
            reader = new BufferedReader(new FileReader("C:\Users\Bebop\Desktop\school\softdev\macbeth.txt"));
            //Reading the first line into currentLine
            String currentLine = reader.readLine();

            while (currentLine != null)
            {
                //splitting the currentLine into words
                String[] words = currentLine.toLowerCase().split("\\W");

                //Iterating each word
                for (String word : words)
                {
                    //if word is already present in wordCountMap, updating its count
                    if(wordCountMap.containsKey(word))
                    {
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                    //otherwise inserting the word as key and 1 as its value
                    else
                    {
                        wordCountMap.put(word, 1);
                    }
                }
                //Reading next line into currentLine
                currentLine = reader.readLine();
            }

            //Getting all the entries of wordCountMap in the form of Set
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
            //Creating a List by passing the entrySet
            List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(entrySet);
            //Sorting the list in the decreasing order of values
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
            @Test
            public void testForThe()
            {
                MyUnit myUnit = new MyUnit();
                String result = arrayWord[0];
                assertEquals("the", result);
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
                reader.close();           //Closing the reader
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

