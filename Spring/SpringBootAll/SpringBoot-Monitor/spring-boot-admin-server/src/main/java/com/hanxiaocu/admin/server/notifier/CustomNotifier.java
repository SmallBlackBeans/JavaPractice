package com.hanxiaocu.admin.server.notifier;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 3:38 PM
 */
//http://codecentric.github.io/spring-boot-admin/current/#customizing-notifiers
@Component
@ConfigurationProperties("hanxiaocu.custom.notifier")
@Setter
@Getter
@Slf4j
public class CustomNotifier extends AbstractStatusChangeNotifier {

	String name;

	public CustomNotifier(InstanceRepository repositpry) {
		super(repositpry);
	}

	@Override
	protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
		return Mono.fromRunnable(() -> {
			if (event instanceof InstanceStatusChangedEvent) {
				log.info("{}-自定义通知：应用 {} -({}) is {}",name, instance.getRegistration().getName(), event.getInstance(),
						((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
			} else {
				log.info("{}-自定义通知：应用 {} -({}) is {}",name, instance.getRegistration().getName(), event.getInstance(),
						event.getType());
			}
		});
	}
}
