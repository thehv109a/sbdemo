// package thehv.controller;

// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import lombok.extern.log4j.Log4j2;

// @RestController
// @Log4j2
// public class TestRabbitController {
//     @Autowired
//     RabbitTemplate rabbitTemplate;

//     @RabbitListener(queues = "DEMO_QUEUE")
//     public void recievedMessage(String message) {
//         log.info(message);
//     }

//     @GetMapping("/testRabbitMQ")
//     public Object testRabbitMQ() {
//         rabbitTemplate.convertAndSend("DEMO_QUEUE", "hello");
//         return "OK";
//     }
// }