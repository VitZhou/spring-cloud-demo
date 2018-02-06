package org.vit.sc.gateway.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.client.discovery.event.HeartbeatMonitor;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.cloud.client.discovery.event.ParentHeartbeatEvent;
import org.springframework.cloud.netflix.zuul.ZuulProxyAutoConfiguration;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class EurekaDiscoveryConfig {

    @Bean
    public ApplicationListener<ApplicationEvent> zuulDiscoveryRefreshRoutesListener() {
        return new ZuulDiscoveryRefreshListener();
    }

    private static class ZuulDiscoveryRefreshListener
            implements ApplicationListener<ApplicationEvent> {

        private HeartbeatMonitor monitor = new HeartbeatMonitor();

        @Autowired
        private ZuulHandlerMapping zuulHandlerMapping;

        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            if (event instanceof InstanceRegisteredEvent) {
                reset();
            }
            else if (event instanceof ParentHeartbeatEvent) {
                ParentHeartbeatEvent e = (ParentHeartbeatEvent) event;
                resetIfNeeded(e.getValue());
            }
            else if (event instanceof HeartbeatEvent) {
                HeartbeatEvent e = (HeartbeatEvent) event;
                resetIfNeeded(e.getValue());
            }

        }

        private void resetIfNeeded(Object value) {
            if (this.monitor.update(value)) {
                reset();
            }
        }

        private void reset() {
            this.zuulHandlerMapping.setDirty(true);
        }

    }
}
