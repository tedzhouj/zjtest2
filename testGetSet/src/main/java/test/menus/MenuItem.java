package test.menus;

import com.auth0.jwt.internal.com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * Created by zhoujun on 2017/8/25.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class MenuItem {

    String id;
    String parentId;
    String name;
    String iconId;

    String order ;
    String level;
    String rootId;

    String route;

}
