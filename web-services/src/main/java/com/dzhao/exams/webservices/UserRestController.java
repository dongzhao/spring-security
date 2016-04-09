package com.dzhao.exams.webservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by dzhao on 2/11/2015.
 */
@RestController
public class UserRestController {

    @RequestMapping(value="/api/user/greeting", method= RequestMethod.GET)
    public ResponseEntity<String> sayHello(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello User, welcome to my world!");
        return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
    }
}
