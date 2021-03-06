/**
 * 
 */
package de.flexguse.soundseeder.service.impl;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import de.flexguse.soundseeder.service.ConfigurationService;

/**
 * @author Christoph Guse, info@flexguse.de
 *
 */
@Configuration
public class JsonConfigurationServiceTestConfiguration {

	/**
	 * The spring framework factory which provides the JSR303 validator. Use
	 * something like
	 * 
	 * <pre>
	 * &#064;Autowired
	 * private Validator validator;
	 * </pre>
	 * 
	 * for getting an {@link Validator} instance autowired.
	 * 
	 * @return
	 */
	@Bean
	public SpringValidatorAdapter validator() {

		return new LocalValidatorFactoryBean();

	}

	/**
	 * This spring framework bean postprocessor enables JSR303 bean validation
	 * for method arguments.
	 * 
	 * <p>
	 * Must only be configured and is used automatically by spring.
	 * </p>
	 * 
	 * @return
	 */
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		final MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
		methodValidationPostProcessor.setValidator(validator());

		return methodValidationPostProcessor;
	}
	
	@Bean
	public ConfigurationService jsonConfigurationService(){
		return new JsonConfigurationService();
	}

	
}
