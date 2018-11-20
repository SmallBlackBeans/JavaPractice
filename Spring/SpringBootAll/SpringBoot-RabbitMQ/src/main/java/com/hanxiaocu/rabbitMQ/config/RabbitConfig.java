package com.hanxiaocu.rabbitMQ.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: RabbitMQ 配置
 * User: hanchenghai
 * Date: 2018/11/01 4:13 PM
 */
@Configuration
@Slf4j
public class RabbitConfig {

	public static final String DEFAULT_BOOK_QUEUE = "dev.book.register.default.queue";
	public static final String MANUAL_BOOK_QUEUE = "dev.book.register.manual.queue";

	/**
	 * 定义一个bbs 队列
	 *
	 * @return
	 */
	@Bean
	public Queue bbsQueue() {
		Queue bbs = new Queue("bbs");
		return bbs;
	}

	@Bean
	public Queue defaultBookQueue() {
		//第二个是消息是否需要持久化处理
		return new Queue(DEFAULT_BOOK_QUEUE, true);
	}

	@Bean
	public Queue manualBookQueue() {
		return new Queue(MANUAL_BOOK_QUEUE, true);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
		connectionFactory.setPublisherConfirms(true);
		connectionFactory.setPublisherReturns(true);
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMandatory(true);
		template.setConfirmCallback((correlationData, ack, cause) -> {
			log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause);
		});
		return template;
	}

	/**
	 * 延迟队列 TTL
	 */
	private static final String REGISTER_DELAY_QUEUE_NAME = "dev.book.register.delay.queue";

	/**
	 * DLX dead letter 发送到 死信交换机
	 * TODO 然后交换机具体处理这些消息到其他的队列还是销毁
	 */
	public static final String REGISTER_DELAY_EXCHANGE_NAME = "dev.book.register.delay.exchange";

	/**
	 * routing key 延迟名称
	 */
	public static final String DELAY_ROUTING_KEY = "";

	// 通过exchange 路由到的最终队列
	public static final String REGISTER_QUEUE_NAME = "dev.book.register.queue";
	//最终队列对应的exchange队列
	public static final String REGISTER_EXCHANGE_NAME = "dev.book.register.exchange";
	//路由到这个最终队列需要携带的路由key
	public static final String ROUTING_KEY = "all";

	//重试 路由key  应该还是正常的路由key 队列还是正常的路由队列
	public static final String REGISTER_RETRY_EXCHANGE = "dev.book.register.retry.exchange";

	/**
	 * Exchange消息交换机，它指定消息按什么规则，路由到哪个队列
	 */

	///做时间延迟的交换机和队列，不要有任何监听，然后消息过期后，就会自动进入转发流程，起到了延迟作用
	@Bean
	public Queue delayProcessQueue() {
		Map<String, Object> params = new HashMap<>();
		// 声明了队列里的死信转发到的死信exchange
		params.put("x-dead-letter-exchange", REGISTER_EXCHANGE_NAME);
		// params.put("x-message-ttl", 5 * 1000);
		// 声明了这些死信在转发时携带的 routing-key 名称。方便exchange 根据这个路由到正确的队列
		params.put("x-dead-letter-routing-key", ROUTING_KEY);
		return new Queue(REGISTER_DELAY_QUEUE_NAME, true, false, false, params);
	}

	@Bean
	public DirectExchange delayExchange() {
		return new DirectExchange(REGISTER_DELAY_EXCHANGE_NAME);
	}

	@Bean
	public Binding delayBinding() {
		//使用delayExchange 按照 routing-key 路由到 delayProcessQueue
		return BindingBuilder.bind(delayProcessQueue()).to(delayExchange()).with(DELAY_ROUTING_KEY);
	}

	//////////////////////// 最终转发的正常处理消息的队列和交换机
	@Bean
	public Queue registerBookQueue() {
		return new Queue(REGISTER_QUEUE_NAME, true);
	}

	/**
	 * 将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。
	 * 符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到“audit.irs”。
	 **/
	@Bean
	public TopicExchange registerBookTopicExchange() {
		return new TopicExchange(REGISTER_EXCHANGE_NAME);
	}

	//正常的接收消息
	@Bean
	public Binding registerBookBinding() {
		// TODO 如果要让延迟队列之间有关联,这里的 routingKey 和 绑定的交换机很关键
		return BindingBuilder.bind(registerBookQueue()).to(registerBookTopicExchange()).with(ROUTING_KEY);
	}

}
