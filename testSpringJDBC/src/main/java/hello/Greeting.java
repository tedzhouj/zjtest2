package hello;

import lombok.Data;

/**
 * Created by zhoujun on 2017/7/5.
 */
@Data
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
