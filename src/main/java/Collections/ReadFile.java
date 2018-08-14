package Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ReadFile {

        private Scanner scanner;
        private Map<String, Integer> statistics;

        public ReadFile (String path) throws FileNotFoundException {
            readFromFile(path);
        }

        public Map<String, Integer> getStatistics() {
            return statistics;
        }

        public static void main(String[] args) throws FileNotFoundException {

            ReadFile collections = new ReadFile("C:\\Users\\User\\Work\\Project_Idea\\src\\main\\java\\Collections\\ReadFile.txt");


            System.out.println("Содержание файла: ");
            System.out.println(collections.getStatistics());
            collections.alphabet(collections.getStatistics());
            System.out.println(" ");


            System.out.println("Слово с максимальным количеством повторений: ");
            collections.mostOften(collections.getStatistics());

        }


        void readFromFile(String path) throws FileNotFoundException {
            scanner = new Scanner(new File(path));
            statistics = new HashMap<String, Integer>();
            while (scanner.hasNext()) {
                String word = scanner.useDelimiter("\\s+").next();
                Integer count = statistics.get(word);
                if (count == null) {
                    count = 0;
                }
                statistics.put(word, ++count);
            }
        }


        void alphabet (Map<String, Integer> statis) {
            Set<String> words = new TreeSet<String>();
            Iterator<Map.Entry<String,Integer>>entryIterator1 = statis.entrySet().iterator();
            while (entryIterator1.hasNext()){
                words.add(entryIterator1.next().getKey());
            }
            System.out.println("Слова в алфавитном порядке: ");
            System.out.println(words);


        }



        void mostOften (Map<String, Integer> stasis) {
            int max = 0;
            String maxWord = null;
            for (String e: stasis.keySet()){
                if (stasis.get(e) > max) {
                    max = stasis.get(e);
                    maxWord = e;
                }
            }
            System.out.println( maxWord );
        }
    }

