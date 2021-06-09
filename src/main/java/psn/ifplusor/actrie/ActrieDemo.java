package psn.ifplusor.actrie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ActrieDemo implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    String pattern = "f|(a|b).{0,5}(e(?&!ef)|g)\nabc\nefg";
    String content = "abcdefg";

    // create matcher by string
    try (Matcher matcher = Matcher.createByString(pattern)) {
      try (Context context = matcher.match(content)) {
        // iterator
        for (Word word : context) {
          System.out.println(word);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
