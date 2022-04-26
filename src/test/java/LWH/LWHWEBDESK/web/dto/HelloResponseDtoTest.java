package LWH.LWHWEBDESK.web.dto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        org.assertj.core.api.Assertions.assertThat(dto.getName()).isEqualTo(name);
        org.assertj.core.api.Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }

}