package fashionette.automation.tech.extentions;

import java.util.List;
import java.util.Random;

public class ListExtension {
    public static <T> T randomItem(List<T> lst) {
        return lst.get(new Random().nextInt(lst.size()));
    }
}
