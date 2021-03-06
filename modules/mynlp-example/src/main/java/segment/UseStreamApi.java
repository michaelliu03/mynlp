package segment;

import com.mayabot.nlp.segment.MynlpAnalyzer;
import com.mayabot.nlp.segment.Tokenizers;
import com.mayabot.nlp.segment.WordTerm;
import com.mayabot.nlp.segment.analyzer.DefaultMynlpAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseStreamApi {

    public static void main(String[] args) throws Exception {

        MynlpAnalyzer analyzer = new DefaultMynlpAnalyzer(Tokenizers.coreTokenizer());

        List<String> lisk = analyzer.stream("").map(x -> x.word).collect(Collectors.toList());

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(
                new File("data/红楼梦.txt"))))) {
            Stream<WordTerm> stream = analyzer.stream(bufferedReader)
                    .filter(it -> it.word.length() > 1);

            stream.forEach(x -> {

            });
            //System.out.println(stream.count());

        }
    }
}
