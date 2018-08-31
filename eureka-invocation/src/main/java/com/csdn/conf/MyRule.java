package com.csdn.conf;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡规则
 */
public class MyRule implements IRule {
   
   private ILoadBalancer lb;

   public Server choose(Object key) {
      Random r = new Random();
      int randomNum = r.nextInt(10);
      List<Server> servers = lb.getAllServers();
      if(randomNum > 7) {
         Server s = getServerByPort(servers, 8081);
         return s;
      }
      return getServerByPort(servers, 8082);
   }
   
   private Server getServerByPort(List<Server> servers, int port) {
      for(Server s : servers) {
         if(s.getPort() == port) {
            return s;
         }
      }
      return null;
   }

   public void setLoadBalancer(ILoadBalancer lb) {
      this.lb = lb;
   }

   public ILoadBalancer getLoadBalancer() {
      return lb;
   }

}
