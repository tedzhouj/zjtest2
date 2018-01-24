package hello;

import hello.Dao.UserDao;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhoujun on 2017/7/5.
 */
@Api(value = "TRADE-MANAGE", description = "交易管理")
@RestController
@RequestMapping("/test")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    UserDao userDao;

    static final String GPS_DESC = "gpsDesc";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/testdb")
    public MyUser testdb(@RequestParam(value="name") String name) {
        return  userDao.getUserByName(name);
    }

    @PostMapping("/testutf")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", value = "gps位置描述", name = GPS_DESC, dataType = "string")
    })
    public String testUtf(@RequestParam(value="name") String name) {
        return  request.getHeader(GPS_DESC);

    }


    @ApiOperation("查询用户绑定银行卡信息")
    @RequestMapping(value = "/testGet/{orgCode}", method = RequestMethod.GET)
    public String  queryCustomerAgree(  @PathVariable String orgCode , @RequestParam String productCode) {
        return  orgCode+productCode;
    }

    @ApiOperation("查询用户绑定银行卡信息222")
    @RequestMapping(value = "/testGet222/{orgCode}", method = RequestMethod.GET)
    public String  queryCustomerAgree222(  @PathVariable String orgCode , String productCode) {
        return  orgCode+productCode;
    }




}
