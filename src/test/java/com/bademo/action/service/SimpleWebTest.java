package com.bademo.action.service;

import com.bademo.SaoneApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by: web测试2种方案：1 springMockMvc 模拟真实servlet容器测试
 *      2：web集成测试,在嵌入式Servlet容器(比如Tomcat或Jetty)里启动应用程序，在真正的应用服务器里执行测试
 *  ：第二种方案小试[练习Spring Boot版本与练习版本不同 😢]
 *  :https://aisensiy.github.io/2017/05/04/spring-mvc-and-test/
 *  :http://www.jianshu.com/p/ef8afa764f83
 * @author Bin.l
 * @date 2017/6/15 22:24
 */
@RunWith(SpringRunner.class) //老版本的 SpringJUnit4ClassRunner 被替换为更容易阅读的 SpringRunner
@SpringBootTest(classes = SaoneApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class SimpleWebTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void webTest() throws Exception {
        ResponseEntity entity = this.restTemplate.getForEntity("/book/1", String.class);
        //assertThat(entity.getBody()).isEqualTo("Hello World");
        assertThat(entity.getStatusCodeValue()).isEqualTo(200);
    }
}
