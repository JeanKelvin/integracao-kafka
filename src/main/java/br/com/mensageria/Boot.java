package br.com.mensageria;

import br.com.mensageria.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class Boot
{
   @Autowired
   Sender sender;

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }

   @GetMapping("/")
   @ResponseBody
   public void home()
   {
      for(int i = 0; i < 100; i++) {
         sender.send("test", "Testando Kafka" + " " + i);
      }
   }
}
