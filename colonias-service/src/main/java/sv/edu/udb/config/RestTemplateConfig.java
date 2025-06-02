package sv.edu.udb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.client.RestTemplate;
import sv.edu.udb.security.JwtService;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {
    
    private final JwtService jwtService;
    
    public RestTemplateConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        
        // Crear un usuario de servicio con rol ASTRAADMIN
        UserDetails serviceUser = new User(
            "ServiceUser",
            "unused",
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_ASTRAADMIN"))
        );
        
        // Generar token JWT para el usuario de servicio
        String serviceToken = jwtService.generateToken(serviceUser);
        
        // Agregar interceptor para incluir el token en cada solicitud
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + serviceToken);
            return execution.execute(request, body);
        };
        
        restTemplate.setInterceptors(Collections.singletonList(interceptor));
        return restTemplate;
    }
} 