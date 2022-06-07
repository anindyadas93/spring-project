package springTest.testing.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller 
{
     @GetMapping("/mappingname1")
     public String test()
     {
         return "i am in";
     }

     @GetMapping("/mappingname2")
     public String func()
     {
         return "page 2";
     }
}
