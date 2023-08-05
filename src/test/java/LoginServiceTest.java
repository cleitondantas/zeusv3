import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.converter.ConvertLed;
import br.com.rocketdevelopment.converter.ConvertSucess;
import br.com.rocketdevelopment.converter.ConvertToken;
import br.com.rocketdevelopment.model.*;
import br.com.rocketdevelopment.service.ApplyService;
import br.com.rocketdevelopment.service.LedSerivce;
import br.com.rocketdevelopment.service.auth.LoginService;
import br.com.rocketdevelopment.service.RequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class LoginServiceTest {


//    @Test
//    public void login() throws Exception {
//        BasicConfig basicConfig = new BasicConfig("http://192.168.1.2","admin","Pedepano10!");
//
//        RequestService requestService = new RequestService(basicConfig.getUrl());
//        LoginService loginService = new LoginService(requestService,new ConvertToken(new ObjectMapper()));
//        Token token = loginService.login(basicConfig);
//
//        LedSerivce ledSerivce = new LedSerivce(requestService,new ConvertLed(new ObjectMapper()));
//        Led led = ledSerivce.getLedSettings(token);
//        System.out.println(led.isActive());
//        Assert.assertTrue(led.isActive());
//        led.getColor().setValue("green");
//        ledSerivce.putLedSettings(token,led);
//        ApplyService applyService = new ApplyService(requestService,new ConvertSucess(new ObjectMapper()));
//        Sucess sucess = applyService.applySettings(token);
//        Assert.assertTrue(sucess.isSucess());
//    }
}
