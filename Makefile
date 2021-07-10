.PHONY: all test clean build


agentPath = /Users/kgebczyn/agents/agent-21.5/javaagent.jar
controllerHostName = controller2143-2143nos-jvlvjmhe.appd-cloudmachine.com
controllerPort = 8090
controllerAccountName = customer1
controllerAccountAccessKey = f7161983-e13b-4585-bd9d-abb885e852aa
ssl = flase
applicationName = Simple-Servlet-second
tierName = test-tier--n
nodeName = test-node--n

#agentPath = /Users/kgebczyn/agents/agent-21.5/javaagent.jar
#controllerHostName = ces-controller.saas.appdynamics.com
#controllerPort = 443
#controllerAccountName = ces-controller
#controllerAccountAccessKey = 11f24f59-e01a-4cab-9e27-0e94b3c14b9f
#ssl = true
#applicationName = "SimpleServlet_ArgentoTest"
#tierName = test-tier-b
#nodeName = test-node-b

run:
	java -javaagent:${agentPath} \
	-Dappdynamics.agent.applicationName=${applicationName} \
	-Dappdynamics.agent.tierName=${tierName} \
	-Dappdynamics.agent.nodeName=${nodeName} \
	-Dappdynamics.controller.ssl.enabled=${ssl} \
	-Dappdynamics.controller.hostName=${controllerHostName} \
	-Dappdynamics.controller.port=${controllerPort} \
	-Dappdynamics.agent.accountName=${controllerAccountName} \
	-Dappdynamics.agent.accountAccessKey=${controllerAccountAccessKey} \
	-Dserver.port=8081 \
	-jar target/simple-servlet.jar

#  	-Dserver.port=8081 \
#	-Dappdynamics.agent.reuse.nodeName=true \
#	-Dappdynamics.agent.reuse.nodeName.prefix=AKAI \