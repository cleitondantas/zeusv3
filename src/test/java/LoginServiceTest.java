import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.converter.ConvertLed;
import br.com.rocketdevelopment.converter.ConvertToken;
import br.com.rocketdevelopment.model.Led;
import br.com.rocketdevelopment.model.Token;
import br.com.rocketdevelopment.service.LedSerivce;
import br.com.rocketdevelopment.service.auth.LoginService;
import br.com.rocketdevelopment.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {
    @Test
    public void login() throws Exception {
        BasicConfig basicConfig = new BasicConfig();
        basicConfig.addUsername("admin");
        basicConfig.addPassword("Pedepano10!");
        basicConfig.addUrl("http://192.168.1.2");
        LoginService loginService = new LoginService(new RequestService(basicConfig.getUrl()),new ConvertToken(new ObjectMapper()));
        Token token = loginService.login(basicConfig);
        LedSerivce ledSerivce = new LedSerivce(new RequestService(basicConfig.getUrl()),new ConvertLed(new ObjectMapper()));
        Led led = ledSerivce.ledSettings(token);
        System.out.println(led.isActive());
        Assert.assertTrue(led.isActive());
    }
}
