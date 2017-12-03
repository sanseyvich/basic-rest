package controller;

/**
 * Created by sanseyvich on 12/3/17.
 */
import java.util.concurrent.atomic.AtomicLong;

import model.InfoBlock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoBlockController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "You're now reading very interesting info in the field of %s!";

    @RequestMapping("/infoBlock")
    public InfoBlock infoBlock(@RequestParam(value="field", defaultValue="philosophy") String field) {
        return new InfoBlock(counter.incrementAndGet(),
                String.format(template, field));
    }
}
