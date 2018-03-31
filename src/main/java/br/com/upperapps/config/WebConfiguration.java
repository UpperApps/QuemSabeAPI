package br.com.upperapps.config;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan("br.com.upperapps")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

	public WebConfiguration() {
		super();
	}

	// Configura as mensagens JSON utilizando a biblioteca Jackson.
	@Override
	public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
		Optional<HttpMessageConverter<?>> converterFound = converters.stream()
				.filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();

		if (converterFound.isPresent()) {
			final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) converterFound
					.get();
			converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}
	}

	// Configura o ResourceHandler para permitir a utilização da interface do swagger-ui.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
}
