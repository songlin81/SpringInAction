package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@EnableAutoConfiguration
@RestController
public class FlashController {
    @RequestMapping("/flash")
    public String flashAPI()  throws Exception{
        return "Spring boot flash message!";
    }

    @Value("${quantity}")
    private int quantity;

    @Value("${tag}")
    private String tag;

    @GetMapping("/getquantity")
    public int getQuantity() {
        return quantity;
    }

    @GetMapping("/gettag")
    public String getTag() {
        return tag;
    }

    @Autowired
    private GetChassisInfoProperties getChassisInfoProperties;

    @GetMapping("/getchassisproperties")
    public String getChassisProperties() {
        return getChassisInfoProperties.getProp()+" -- "+getChassisInfoProperties.getAmount();
    }
}
