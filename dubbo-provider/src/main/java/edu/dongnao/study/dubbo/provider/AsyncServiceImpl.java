package edu.dongnao.study.dubbo.provider;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcContext;

import edu.dongnao.study.dubbo.facade.AsyncService;

/**
 * AsyncServiceImpl
 * 
 */
public class AsyncServiceImpl implements AsyncService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public CompletableFuture<String> sayHello(String name) {
		RpcContext savedContext = RpcContext.getContext();
		final String argName = name;
		return CompletableFuture.supplyAsync(()->{
			String key = savedContext.getAttachment("consumer-key1");
			logger.debug("key值为："+key);
			try {
				Thread.sleep(500L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "hello "+argName+". this is async response from provider, for consummer key: "+key;
		});
	}

}

