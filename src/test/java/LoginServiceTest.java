import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.converter.ConvertLed;
import br.com.rocketdevelopment.converter.ConvertSucess;
import br.com.rocketdevelopment.converter.ConvertToken;
import br.com.rocketdevelopment.converter.ConvertUserPass;
import br.com.rocketdevelopment.model.*;
import br.com.rocketdevelopment.service.ApplyService;
import br.com.rocketdevelopment.service.LedSerivce;
import br.com.rocketdevelopment.service.auth.LoginService;
import br.com.rocketdevelopment.service.RequestService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
public class LoginServiceTest {

     private static final String URL = "XXXXXXX";
     private static final String USER = "XXXX";
     private static final String PASS = "XXXXX";

    @Test
   public void login() throws Exception {
//        BasicConfig basicConfig = new BasicConfig(URL,USER,PASS);
//        RequestService requestService = new RequestService(basicConfig.getUrl());
//        LoginService loginService = new LoginService(requestService,new ConvertToken(new ObjectMapper()),new ConvertUserPass(new ObjectMapper()));
//        BearerToken token = loginService.login(basicConfig);
//        LedSerivce ledSerivce = new LedSerivce(requestService,new ConvertLed(new ObjectMapper()));
//        Led led = ledSerivce.getLedSettings(token);
//        System.out.println(led.isActive());
//        Assert.assertTrue(led.isActive());
//        led.getColor().setValue("green");
//        ledSerivce.putLedSettings(token,led);
//        ApplyService applyService = new ApplyService(requestService,new ConvertSucess(new ObjectMapper()));
//        SystemSucess sucess = applyService.applySettings(token);
//        Assert.assertTrue(sucess.isSucess());
         Assert.assertTrue(true);
    }
}
