package bookrental;

import bookrental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRevfailed_Needtobuy(@Payload Revfailed revfailed){
        if(revfailed.isMe()) {
            System.out.println("================================================================");
            System.out.println("다음 서적의 재고가 부족합니다. 구매 검토 바랍니다.");
            System.out.println("Book ID: " + revfailed.getBookid());
            System.out.println("================================================================");
        }
    }
    ////////////////////////////////////////

}
