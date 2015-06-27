import os
os.system("mvn package -Dmaven.test.skip=true")
os.system("java -jar target/dependency/webapp-runner.jar target/*.war") 
