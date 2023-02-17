package com.testApi.service.integrations;

import com.testApi.api.dto.UserDTO;
import com.testApi.api.error.ErrorControllerException;
import com.testApi.persistence.entity.UsersEntity;
import com.testApi.persistence.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static com.testApi.constants.AppConstants.GITHUB.URL_GET_PROFILE;

@Slf4j
@Setter
@Component
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserComponent {
    final Environment env;

    public UserDTO getProfileFromGithub(String login) {
        try {
            String url = env.getRequiredProperty(URL_GET_PROFILE).concat("/") + login;
            UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();

            ResponseEntity<UserDTO> response = new RestTemplate()
                    .exchange(builder.toString(), HttpMethod.GET, this.getHttpEntity(), UserDTO.class);

            if (HttpStatus.OK == response.getStatusCode()) {
                return response.getBody();
            }

        } catch (Exception exception) {
            String msgError =  exception.getMessage();
            log.error("stage=error-get-profile, msg={}", exception.getMessage(), exception);
            throw new ErrorControllerException( msgError);
        }
        return null;
    }



    private HttpEntity<String> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setCacheControl(CacheControl.noCache());
        return new HttpEntity<>(null, httpHeaders);
    }
}
