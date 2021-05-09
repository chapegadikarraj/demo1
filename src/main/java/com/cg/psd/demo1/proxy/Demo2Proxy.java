package com.cg.psd.demo1.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.psd.demo1.model.Profile;

//@FeignClient(name="zuul") For calling zuul rather than directly calling demo2. Zuul will load balance instead. No need to use ribbon for client side load balancing.
@FeignClient(name="demo2"/*, url="localhost:8083"*/) // In new versions, feign can only used to load balance without ribbon.
@RibbonClient(name="demo2")
public interface Demo2Proxy {
	/**
	 * 
	 * take method signature from Demo2 not Demo1.
	 * 
	 * 1. When Zuul is load balancer, then @RicbbonClient is not used and in RequestMapping Url
	 *    pass url as "/{app-name}/{url}".
	 * 2. If Ribbon is used as load balancer, then @RibbonClient is used and in @RequestMapping use url as "{url}".
	 * 
	 */
	@RequestMapping(value="demo2/funPost", method=RequestMethod.POST/*, produces="application/xml"*/)
	public String funPost(
			@RequestBody Profile profile);
		
	
}
