package org.vit.sc.eureka.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "demo")
public class ModulusConfig {
    private float modulus;

    public float getModulus() {
        return modulus;
    }

    public void setModulus(float modulus) {
        this.modulus = modulus;
    }
}
