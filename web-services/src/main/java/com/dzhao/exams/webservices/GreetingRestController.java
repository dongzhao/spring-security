package com.dzhao.exams.webservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dzhao on 2/11/2015.
 */
@RestController
public class GreetingRestController {

    @RequestMapping(value="/api/greeting/{name}", method= RequestMethod.GET)
    public ResponseEntity<String> sayHello(@PathVariable("name") String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        sb.append(name);
        sb.append(", welcome to my world!");
        return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
    }

}
