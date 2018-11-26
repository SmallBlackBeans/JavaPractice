package com.hanxiaocu.elastitc_java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc: ESClientHelper 按照Elasticsearch API，在Java端使用是ES服务需要创建Java
 * Client，但是每一次连接都实例化一个client，对系统的消耗很大， 即使在使用完毕之后将client
 * close掉，由于服务器不能及时回收socket资源，极端情况下会导致服务器达到最大连接数。
 * 为了解决上述问题并提高client利用率，可以参考使用池化技术复用client。
 * @author: hanchenghai
 * @date: 2018/11/26 11:10 AM
 */
@Slf4j
public class ESClientHelper {

	private static ESClientHelper instance;

	private Map<String, Client> clientMap = new ConcurrentHashMap<String, Client>();

	private Settings setting;

	private Map<String, Integer> ips = new HashMap<String, Integer>();
	private String clusterName = Configs.ES_CONFIG.getCluster();

	public static synchronized ESClientHelper getInstance() {
		if (instance == null) {
			instance = new ESClientHelper();
		}
		return instance;
	}

	private ESClientHelper() {
		init();
	}

	/**
	 * 初始化默认的客户端
	 */
	private void init() {
		String address = Configs.ES_CONFIG.getAddress();
		if (StringUtils.isNotEmpty(address)) {
			//分割
			StringTokenizer tokenizer = new StringTokenizer(address, ",");
			while (tokenizer.hasMoreTokens()) {
				String ip = tokenizer.nextToken();
				ips.put(ip, Configs.ES_CONFIG.getPort());
			}
		}

		setting = Settings.builder().put("cluster.name", Configs.ES_CONFIG.getCluster()).build();
		addClient(setting, getAllAddress(ips));
	}

	public Client getClient(String clusterName) {
		return clientMap.get(clusterName);
	}

	private void addClient(Settings setting, List<InetSocketTransportAddress> allAddress) {
		Client client = new PreBuiltTransportClient(setting)
				.addTransportAddresses(allAddress.toArray(new InetSocketTransportAddress[allAddress.size()]));
		clientMap.put(setting.get("cluster name"), client);
	}

	private List<InetSocketTransportAddress> getAllAddress(Map<String, Integer> ips) {
		List<InetSocketTransportAddress> addressList = new ArrayList<InetSocketTransportAddress>();
		for (String ip : ips.keySet()) {
			try {
				addressList.add(new InetSocketTransportAddress(InetAddress.getByName(ip), ips.get(ip)));
			} catch (UnknownHostException e) {
				log.info("添加 inetSocketTransportAddress exception:[{}],ip:[{}]", e.getMessage(), ip);
			}
		}
		return addressList;
	}

}
