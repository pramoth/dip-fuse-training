1. install Oracle JDK

    1.1 install download tools
    ```
    yum install -y wget
    ```
        
    1.2 Download and install JDK
    
    ```
    wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.rpm"
    yum localinstall -y jdk-8u121-linux-x64.rpm
    ```
    1.3 install VIM editor for edit linux environment variable
    
    ```
    yum install -y vim
    ```
    1.4 Add JAVA_HOME environment variable
    ```
    vim /etc/profile.d/jdk.sh
    ```
    add statement below to jdk.sh
    ```
    export JAVA_HOME=/usr/java/jdk1.8.0_121/
    ```
    save and exit
    call 'profile' script to update environment variable
    ```
    source /etc/profile.d/jdk.sh
    ```
    check configuration by ```echo $JAVA_HOME``` should display '/etc/alternatives/java'
    
2. install Netbeans
    * download Netbeans for linux at http://netbeans.org
3. install IntelliJ IDEA
    * download IntelliJ IDEA https://www.jetbrains.com/idea/
4. install Red Hat Developer Studio
    * download https://developers.redhat.com/products/fuse/download/
5. Install Git SCM
   ```
   yum install -y  git
   git config --global user.name "Your name"
   git config --global user.email "your email"
   ```
6. install maven 
    * download maven 
    ```
    wget http://www-us.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
    tar -zxvf apache-maven-3.3.9-bin.tar.gz --directory /opt/
    ```
    * setup maven home
    ```
    vim /etc/profile.d/maven.sh
    ```
    past below to editor
    ```
    export MAVEN_HOME=/opt/apache-maven-3.3.9
    export PATH=$PATH:$MAVEN_HOME/bin
    ```
    * config maven repository
7. install JBoss Fuse Karaf runtime
    * install unzip for extract zip file
    ```
    yum install -y  unzip
    ```
    * extract jboss-fuse-karaf-6.3.0.redhat-187.zip to  /opt/
    ```
    unzip jboss-fuse-karaf-6.3.0.redhat-187.zip -d  /opt/
    ```
    * setting admin user/password
    ```
    cd /opt/jboss-fuse-6.3.0.redhat-187
    vim etc/users.properties
    ```
    and uncomment line start with #admin=admin by remove # then save
    * try to start JBoss Fuse
    ```
    bin/fuse
    ```
    wait for Karaf shell ready
8.  Hello Karaf 
    * create sample project 
    ```
    mvn -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=osgi-archetype -DarchetypeVersion=1.4 -DarchetypeRepository=http://repo.maven.apache.org/maven2 -DgroupId=th.co.geniustree.training -DartifactId=hello-karaf -Dversion=1.0.0-SNAPSHOT -Dpackage=th.co.geniustree.training.hello.karaf  -Darchetype.interactive=false --batch-mode archetype:generate
    ```
    * install to karaf (type this command in karaf console)
    ```
    install mvn:th.co.geniustree.training.hello.karaf/hello-karaf/1.0.0-SNAPSHOT
    ```
    * list bundle already install
    ```
    list
    ```
    * uninstall bundle (*ID is id of your bundle)
    ```
    uninstall *ID
    ```