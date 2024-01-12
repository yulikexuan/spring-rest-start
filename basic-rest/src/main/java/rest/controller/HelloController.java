//: rest.controller.HelloController.java


package rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class HelloController {

    @GetMapping("/hello")
    String greeting() {
        return "Hello There!";
    }

    @GetMapping("/ciao")
    String ciao() {
        return "Ciao!";
    }

}///:~